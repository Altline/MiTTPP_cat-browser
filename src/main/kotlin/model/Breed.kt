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
    @SerialName("energy_level")         val energyLevel: Int = 0,
    @SerialName("affection_level")      val affectionLevel: Int = 0,
    @SerialName("child_friendly")       val childFriendly: Int = 0,
    @SerialName("dog_friendly")         val dogFriendly: Int = 0,
    @SerialName("stranger_friendly")    val strangerFriendly: Int = 0,
    @SerialName("intelligence")         val intelligence: Int = 0,
    @SerialName("adaptability")         val adaptability: Int = 0,
    @SerialName("grooming")             val grooming: Int = 0,
    @SerialName("shedding_level")       val sheddingLevel: Int = 0,
    @SerialName("health_issues")        val healthIssues: Int = 0,
    @SerialName("social_needs")         val socialNeeds: Int = 0,
    @SerialName("vocalisation")         val vocalization: Int = 0,
    @SerialName("indoor")               val indoor: Int? = null,
    @SerialName("natural")              val natural: Int? = null,
    @SerialName("rare")                 val rare: Int? = null,
    @SerialName("hairless")             val hairless: Int? = null,
    @SerialName("hypoallergenic")       val hypoallergenic: Int? = null,
    @SerialName("short_legs")           val shortLegs: Int? = null,
    @SerialName("suppressed_tail")      val suppressedTail: Int? = null,
    @SerialName("reference_image_id")   val refImageId: String = "",
    @SerialName("image")                val image: CatImage? = null
) {
    val isIndoor = indoor == 1
    val isNatural = natural == 1
    val isRare = rare == 1
    val isHairless = hairless == 1
    val isHypoallergenic = hypoallergenic == 1
    val hasShortLegs = shortLegs == 1
    val hasSuppressedTail = suppressedTail == 1
}