package view.styles

import kotlinx.css.*
import kotlinx.css.properties.scale
import kotlinx.css.properties.transform
import styled.StyleSheet

object BreedsStyles : StyleSheet("BreedsStyles", isStatic = true) {

    val breedTileHolder by css {
        padding(20.px, 40.px)
        display = Display.grid
        gridTemplateColumns = GridTemplateColumns(GridAutoRows.auto, GridAutoRows.auto, GridAutoRows.auto)
        backgroundColor = Color.lightGray
        borderRadius = 8.px
    }

    val breedTile by css {
        margin(5.px)
        padding(5.px)
        borderRadius = 3.px
        backgroundColor = Color.white
        display = Display.grid
        gridTemplateRows = GridTemplateRows(GridAutoRows.auto, GridAutoRows.auto)

        hover {
            backgroundColor = Color("#ffe")
            transform {
                scale(1.02)
            }
        }

        descendants("img") {
            alignSelf = Align.center
        }
        descendants("div") {
            margin(vertical = 10.px)
            alignSelf = Align.selfEnd
            textAlign = TextAlign.center
            fontSize = 1.2.em
        }
    }
}