package view

import react.Props
import react.fc
import styled.css
import styled.styledFooter
import view.styles.AppStyles

val Footer = fc<Props> {
    styledFooter {
        css { +AppStyles.footer }

        +"Footer"
    }
}