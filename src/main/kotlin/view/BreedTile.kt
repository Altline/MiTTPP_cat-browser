package view

import model.Breed
import react.Props
import react.dom.div
import react.dom.img
import react.fc
import styled.css
import styled.styledDiv
import view.styles.BreedsStyles

external interface BreedTileProps : Props {
    var breed: Breed
}

val BreedTile = fc<BreedTileProps> { props ->
    styledDiv {
        css {
            +BreedsStyles.breedTile
        }

        img(props.breed.name, props.breed.image?.url) {
            attrs.width = "256px"
        }
        div {
            +props.breed.name
        }
    }
}