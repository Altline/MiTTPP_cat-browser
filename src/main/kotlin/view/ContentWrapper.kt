package view

import react.create
import react.fc
import react.router.Route
import react.router.Routes
import styled.css
import styled.styledMain
import view.styles.AppStyles

external interface ContentWrapperProps : ApplicationProps

val ContentWrapper = fc<ContentWrapperProps> { props ->
    styledMain {
        css { +AppStyles.pageContent }

        Routes {
            Route {
                attrs.index = true
                attrs.element = HomePage.create {
                    coroutineScope = props.coroutineScope
                    catService = props.catService
                }
            }
            Route {
                attrs.path = "/breeds"
                attrs.element = BreedsPage.create {
                    coroutineScope = props.coroutineScope
                    catService = props.catService
                }
            }
            Route {
                attrs.path = "/breeds/:breedId"
                attrs.element = BreedDetailsPage.create {
                    coroutineScope = props.coroutineScope
                    catService = props.catService
                }
            }
            Route {
                attrs.path = "/categories"
                attrs.element = CategoriesPage.create {
                    coroutineScope = props.coroutineScope
                    catService = props.catService
                }
            }
        }
    }
}