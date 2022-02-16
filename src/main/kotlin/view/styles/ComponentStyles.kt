package view.styles

import kotlinx.css.*
import styled.StyleSheet

object ComponentStyles : StyleSheet("ComponentStyles", isStatic = true) {

    val conditionalDescriptor by css {
        margin(0.px, 6.px, 24.px)
        padding(10.px)
        display = Display.inlineBlock
        backgroundColor = Color.lightGray
        borderRadius = 16.px
    }

    val gradeScale by css {
        margin(vertical = 8.px)

        descendants("img") {
            margin(top = 5.px, right = 5.px)
        }
    }
}