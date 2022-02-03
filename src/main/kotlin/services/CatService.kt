package services

import kotlinx.browser.window
import kotlinx.coroutines.await
import model.Breed
import org.w3c.fetch.RequestInit
import kotlin.js.json

class CatService {
    private val baseAddress = "https://api.thecatapi.com/v1/"
    private val apiKey by lazy { js("API_KEY").toString() }

    suspend fun getBreeds(page: Int, limit: Int = 18): Array<Breed> {
        val json = getAuthorized("breeds", arrayOf(
            "limit" to limit.toString(),
            "page" to page.toString()
        ))

        return JSON.parse(json)
    }

    private suspend fun getAuthorized(location: String, params: Array<Pair<String, String>>): String {
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
