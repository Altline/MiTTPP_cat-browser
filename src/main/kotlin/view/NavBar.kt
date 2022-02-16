package view

import react.Props
import react.RBuilder
import react.dom.ul
import react.fc
import react.router.dom.Link
import react.router.useLocation
import styled.css
import styled.styledLi
import styled.styledNav
import view.styles.AppStyles

val NavBar = fc<Props> {
    val location = useLocation()

    val currentSelection = when (location.pathname) {
        "/" -> 0
        "/breeds" -> 1
        "/categories" -> 2
        else -> -1
    }

    styledNav {
        css { +AppStyles.navbar }

        ul {
            navListElement(0, "/", "Home", currentSelection)
            navListElement(1, "/breeds", "Breeds", currentSelection)
            navListElement(2, "/categories", "Categories", currentSelection)
        }
    }
}

private fun RBuilder.navListElement(
    id: Int,
    to: String,
    text: String,
    currentSelection: Int
) {
    NavListElement {
        attrs.id = id
        attrs.to = to
        attrs.text = text
        attrs.active = currentSelection == id
    }
}

private external interface NavListElementProps : Props {
    var id: Int
    var to: String
    var text: String
    var active: Boolean
}

private val NavListElement = fc<NavListElementProps> { props ->
    styledLi {
        css {
            if (props.active) +AppStyles.active
            else classes.remove("active")
        }

        Link {
            attrs.to = props.to
            +props.text
        }
    }
}