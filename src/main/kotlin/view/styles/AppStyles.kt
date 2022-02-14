package view.styles

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import styled.StyleSheet
import styled.injectGlobal

object AppStyles : StyleSheet("AppStyles", isStatic = true) {

    init {
        CssBuilder(allowClasses = false).apply {
            body {
                margin(0.px)
                padding(0.px)
            }

            injectGlobal(toString())
        }
    }

    val application by css {
        display = Display.grid
        gridTemplateAreas = GridTemplateAreas("'header' 'main' 'footer'")
        justifyItems = JustifyItems.center
        fontFamily = "sans-serif"
    }

    val pageContent by css {
        margin(top = 50.px)
        display = Display.flex
        flexDirection = FlexDirection.column
        alignItems = Align.center
        width = 80.pct
    }

    val navbar by css {
        descendants("ul") {
            margin(0.px)
            padding(horizontal = 50.px)
            position = Position.fixed
            top = 0.px
            left = 0.px
            width = 100.pct
            listStyleType = ListStyleType.none
            backgroundColor = Color("#333")
            overflow = Overflow.hidden
        }
        descendants("li") {
            display = Display.inline
            float = Float.left

            hover {
                not(".AppStyles-active") {
                    backgroundColor = Color("#111")
                }
            }
        }
        descendants("a") {
            padding(14.px, 16.px)
            display = Display.block
            color = Color.white
            textAlign = TextAlign.center
            textDecoration = TextDecoration.none
        }
    }

    val footer by css {

    }

    val pageTitle by css {
        margin(vertical = 30.px)
        fontSize = 1.5.em
        fontWeight = FontWeight.bold
        color = Color.darkOliveGreen
    }

    val pageSubtitle by css {
        margin(vertical = 10.px)
        fontSize = 1.2.em
        fontWeight = FontWeight.initial
        color = Color("#555")
    }

    val headImage by css {
        borderRadius = 50.pct
        width = 350.px
    }

    val active by css {
        backgroundColor = Color("#04AA6D")
    }

    val loading by css {
        margin(vertical = 30.px)
        fontSize = 1.2.em
    }
}