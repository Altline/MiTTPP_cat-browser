package view.breeds

import model.Breed
import react.Props
import react.dom.div
import react.dom.img
import react.fc
import react.router.dom.Link
import react.router.useLocation
import styled.css
import styled.styledDiv
import view.styles.BreedStyles

external interface BreedTileProps : Props {
    var breed: Breed
}

val BreedTile = fc<BreedTileProps> { props ->
    val location = useLocation()

    Link {
        attrs.to = "${location.pathname}/${props.breed.id}"

        styledDiv {
            css {
                +BreedStyles.breedTile
            }

            img("Image is missing", props.breed.image?.url) {
                attrs.width = "256px"
            }
            div {
                +props.breed.name
            }
        }
    }

}