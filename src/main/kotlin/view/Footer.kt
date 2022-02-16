package view

import react.Props
import react.dom.div
import react.fc
import styled.css
import styled.styledFooter
import view.styles.AppStyles

val Footer = fc<Props> {
    styledFooter {
        css { +AppStyles.footer }

        div {
            +"Footer"
        }
    }
}