package model

import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val id: String,
    val width: Int,
    val height: Int,
    val url: String
)
