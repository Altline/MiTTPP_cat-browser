package view.styles

import kotlinx.css.*
import styled.StyleSheet

object ComponentStyles : StyleSheet("ComponentStyles", isStatic = true) {

    val gradeScale by css {
        margin(vertical = 4.px)

        descendants("img") {
            margin(top = 5.px, right = 5.px)
        }
    }
}