package view

import kotlinx.coroutines.launch
import model.Breed
import react.fc
import react.router.useParams
import react.useEffectOnce
import react.useState
import styled.css
import styled.styledDiv
import view.styles.AppStyles

external interface BreedDetailsPageProps : ApplicationProps

val BreedDetailsPage = fc<BreedDetailsPageProps> { props ->
    val breedId: String = useParams()["breedId"]!!
    var breed: Breed by useState(Breed())
    +"Details"

    useEffectOnce {
        props.coroutineScope.launch {
            breed = props.catService.getBreed(breedId)
        }
    }

    styledDiv {

        styledDiv {
            css { +AppStyles.pageTitle }
            +breed.name
        }
    }
}