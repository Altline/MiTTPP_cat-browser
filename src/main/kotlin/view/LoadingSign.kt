package view

import react.Props
import react.RBuilder
import react.fc
import styled.css
import styled.styledDiv
import view.styles.AppStyles

fun RBuilder.loadingSign(isLoading: Boolean = true) {
    LoadingSign {
        attrs.isLoading = isLoading
    }
}

external interface LoadingSignProps : Props {
    var isLoading: Boolean
}

val LoadingSign = fc<LoadingSignProps> { props ->
    if (props.isLoading) {
        styledDiv {
            css { +AppStyles.loading }
            +"Loading..."
        }
    }
}