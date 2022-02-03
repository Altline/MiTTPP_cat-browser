package services

import kotlinx.browser.window
import kotlinx.coroutines.await
import model.Breed
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

    suspend fun getBreeds(page: Int, limit: Int = 18): Array<Breed> {
        return runCatching {
            val json = getAuthorized(
                "breeds", arrayOf(
                    "limit" to limit.toString(),
                    "page" to page.toString()
                )
            )

            JSON.parse<Array<Breed>>(json)

        }.getOrDefault(emptyArray())
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
