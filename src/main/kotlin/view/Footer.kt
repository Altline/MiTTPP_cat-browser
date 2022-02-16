package view

import kotlinx.css.Display
import kotlinx.css.JustifyContent
import kotlinx.css.display
import kotlinx.css.justifyContent
import react.Props
import react.dom.span
import react.fc
import styled.css
import styled.styledDiv
import styled.styledFooter
import view.styles.AppStyles

val Footer = fc<Props> {
    styledFooter {
        css { +AppStyles.footer }

        styledDiv {
            css {
                display = Display.flex
                justifyContent = JustifyContent.spaceBetween
            }
            span {
                +"Dominik Živko, 1. godina diplomskog studija programskog inženjerstva"
            }
            span {
                +"Fakultet elektrotehnike, računarstva i informacijskih tehnologija Osijek, 2022."
            }
        }
    }
}