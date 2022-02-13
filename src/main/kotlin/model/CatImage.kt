package model

import kotlinx.serialization.Serializable

@Serializable
data class CatImage(
    val id: String = "",
    val width: Int = 0,
    val height: Int = 0,
    val url: String = "",
    val breeds: List<Breed>? = null
)
