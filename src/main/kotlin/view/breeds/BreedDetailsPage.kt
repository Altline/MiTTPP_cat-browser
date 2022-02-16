package view.breeds

import kotlinx.coroutines.launch
import model.Breed
import model.CatImage
import react.dom.*
import react.fc
import react.router.useParams
import react.useEffectOnce
import react.useState
import styled.css
import styled.styledDiv
import view.ApplicationProps
import view.conditionalDescriptor
import view.gradeScale
import view.loadingSign
import view.styles.AppStyles
import view.styles.BreedStyles

external interface BreedDetailsPageProps : ApplicationProps

val BreedDetailsPage = fc<BreedDetailsPageProps> { props ->
    val breedId: String = useParams()["breedId"]!!
    var breed: Breed by useState(Breed())
    var images: Array<CatImage> by useState(emptyArray())
    var referenceImage: CatImage by useState(CatImage())

    useEffectOnce {
        props.coroutineScope.launch {
            val newBreed = props.catService.getBreed(breedId)
            breed = newBreed
            images = props.catService.searchImages(page = 0, limit = 6, breedId = breedId)
            referenceImage = props.catService.getImage(newBreed.refImageId)
        }
    }

    if (breed.id == "") {
        loadingSign()
        return@fc
    }

    styledDiv {
        css { +BreedStyles.breedHead }

        img {
            attrs.src = referenceImage.url
        }
        h1 {
            +breed.name
        }
        if (breed.altNames.isNotBlank()) {
            h2 {
                +"Alternate names: ${breed.altNames}"
            }
        }
    }

    div {
        conditionalDescriptor("Indoor", breed.isIndoor)
        conditionalDescriptor("Natural", breed.isNatural)
        conditionalDescriptor("Rare", breed.isRare)
        conditionalDescriptor("Hairless", breed.isHairless)
        conditionalDescriptor("Hypoallergenic", breed.isHypoallergenic)
        conditionalDescriptor("Short Legs", breed.hasShortLegs)
        conditionalDescriptor("Suppressed Tail", breed.hasSuppressedTail)
    }

    styledDiv {
        css { +BreedStyles.descriptionPanel }

        p { +breed.temperament }
        p { +breed.description }
        p { +"Origin: ${breed.origin}" }
        p { +"Lifespan: ${breed.lifespan} years" }
    }

    styledDiv {
        css { +BreedStyles.traitPanel }

        gradeScale("Energy Level", breed.energyLevel)
        gradeScale("Affection Level", breed.affectionLevel)
        gradeScale("Child Friendly", breed.childFriendly)
        gradeScale("Dog Friendly", breed.dogFriendly)
        gradeScale("Stranger Friendly", breed.strangerFriendly)
        gradeScale("Intelligence", breed.intelligence)
        gradeScale("Adaptability", breed.adaptability)
        gradeScale("Grooming", breed.grooming)
        gradeScale("Shedding Level", breed.sheddingLevel)
        gradeScale("Health Issues", breed.healthIssues)
        gradeScale("Social Needs", breed.socialNeeds)
        gradeScale("Vocalization", breed.vocalization)
    }

    styledDiv {
        css { +AppStyles.mosaic }

        for (image in images) {
            img {
                attrs.height = "256px"
                attrs.src = image.url
            }
        }
    }
}