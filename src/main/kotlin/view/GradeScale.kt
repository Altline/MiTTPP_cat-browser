package view

import react.Props
import react.RBuilder
import react.dom.div
import react.dom.img
import react.fc
import styled.css
import styled.styledDiv
import view.styles.ComponentStyles

fun RBuilder.gradeScale(name: String, level: Int, maxLevel: Int = 5) {
    GradeScale {
        attrs.name = name
        attrs.level = level
        attrs.maxLevel = maxLevel
    }
}

external interface GradeScaleProps : Props {
    var name: String
    var maxLevel: Int
    var level: Int
}

val GradeScale = fc<GradeScaleProps> { props ->
    styledDiv {
        css { +ComponentStyles.gradeScale }

        div {
            +props.name
        }
        div {
            for (i in 1..props.maxLevel) {
                img {
                    attrs.width = "20px"
                    attrs.src =
                        if (i <= props.level) Images.catHeadFilled
                        else Images.catHead
                }
            }
        }
    }
}