package view

import react.*
import react.dom.events.MouseEvent
import react.dom.onClick
import react.dom.ul
import react.router.dom.Link
import react.router.useLocation
import styled.css
import styled.styledLi
import styled.styledNav
import view.styles.AppStyles

val NavBar = fc<Props> {
    val location = useLocation()
    var currentSelection: Int by useState(-1)

    val onClick: NavListElementProps.(MouseEvent<*, *>) -> Unit = {
        currentSelection = id
    }

    useEffectOnce {
        currentSelection = when (location.pathname) {
            "/" -> 0
            "/breeds" -> 1
            "/categories" -> 2
            else -> -1
        }
    }

    styledNav {
        css { +AppStyles.navbar }

        ul {
            navListElement(0, "/", "Home", currentSelection, onClick)
            navListElement(1, "/breeds", "Breeds", currentSelection, onClick)
            navListElement(2, "/categories", "Categories", currentSelection, onClick)
        }
    }
}

private fun RBuilder.navListElement(
    id: Int,
    to: String,
    text: String,
    currentSelection: Int,
    onClick: NavListElementProps.(MouseEvent<*, *>) -> Unit
) {
    NavListElement {
        attrs.id = id
        attrs.to = to
        attrs.text = text
        attrs.active = currentSelection == id
        attrs.onClick = {
            onClick(attrs, it)
        }
    }
}

private external interface NavListElementProps : Props {
    var id: Int
    var to: String
    var text: String
    var active: Boolean
    var onClick: (event: MouseEvent<*, *>) -> Unit
}

private val NavListElement = fc<NavListElementProps> { props ->
    styledLi {
        css {
            if (props.active) +AppStyles.active
            else classes.remove("active")
        }

        attrs.onClick = props.onClick

        Link {
            attrs.to = props.to
            +props.text
        }
    }
}