package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Breed(
    @SerialName("id")                   val id: String = "",
    @SerialName("name")                 val name: String = "",
    @SerialName("alt_names")            val altNames: String = "",
    @SerialName("description")          val description: String = "",
    @SerialName("temperament")          val temperament: String = "",
    @SerialName("origin")               val origin: String = "",
    @SerialName("life_span")            val lifespan: String = "",
    @SerialName("reference_image_id")   val refImageId: String = "",
    @SerialName("image")                val image: CatImage? = null
)