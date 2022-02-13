package services

import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.Breed
import model.CatImage
import org.w3c.fetch.RequestInit
import kotlin.js.json

class CatService {
    private val baseAddress = "https://api.thecatapi.com/v1/"
    private val apiKey by lazy {
        kotlin.runCatching {
            js("API_KEY").toString()
        }.onFailure {
            console.error("The API key is not present in the configuration! Please acquire the key in order to access the cat API.")
        }.getOrNull()
    }

    private val json = Json {
        ignoreUnknownKeys = true
    }

    suspend fun getBreeds(page: Int, limit: Int = 18): Array<Breed> {
        val response = getAuthorized(
            "breeds", arrayOf(
                "limit" to limit.toString(),
                "page" to page.toString()
            )
        )
        return json.decodeFromString(response)
    }

    suspend fun getBreed(breedId: String): Breed {
        val image = searchImages(breedId = breedId).first()
        return image.breeds!!.find { it.id == breedId }!!
    }

    suspend fun searchImages(page: Int? = null, limit: Int? = null, breedId: String? = null, categoryId: String? = null): Array<CatImage> {
        val params = mutableListOf<Pair<String, String>>()

        if (page != null) params.add("page" to page.toString())
        if (limit != null) params.add("limit" to limit.toString())
        if (breedId != null) params.add("breed_id" to breedId)
        if (categoryId != null) params.add("category_id" to categoryId)

        val response = getAuthorized("images/search", params.toTypedArray())
        return json.decodeFromString(response)
    }

    private suspend fun getAuthorized(location: String, params: Array<Pair<String, String>>): String {
        check(apiKey != null) { "No API key." }

        val urlParams = params.fold("?") { acc, param ->
            acc + param.first + "=" + param.second + "&"
        }.dropLast(1)

        return window.fetch(
            baseAddress + location + urlParams, RequestInit(
                "GET",
                headers = json(
                    "x-api-key" to apiKey
                )
            )
        ).await().text().await()
    }
}
