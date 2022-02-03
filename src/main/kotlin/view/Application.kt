package view

import kotlinx.coroutines.CoroutineScope
import react.Props
import react.fc
import react.router.dom.BrowserRouter
import services.CatService
import styled.css
import styled.styledDiv
import view.styles.AppStyles

external interface  ApplicationProps : Props {
    var coroutineScope: CoroutineScope
    var catService: CatService
}

val Application = fc<ApplicationProps> { props ->
    BrowserRouter {
        styledDiv {
            css { +AppStyles.application }

            NavBar()
            ContentWrapper {
                attrs.coroutineScope = props.coroutineScope
                attrs.catService = props.catService
            }
            Footer()
        }
    }
}