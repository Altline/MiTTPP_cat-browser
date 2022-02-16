package view

import react.RBuilder
import styled.css
import styled.styledSpan
import view.styles.ComponentStyles

fun RBuilder.conditionalDescriptor(name: String, value: Boolean) {
    if (value) {
        styledSpan {
            css { +ComponentStyles.conditionalDescriptor }

            +name
        }
    }
}