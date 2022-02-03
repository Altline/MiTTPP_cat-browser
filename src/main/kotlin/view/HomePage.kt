package view

import react.fc

external interface HomePageProps : ApplicationProps

val HomePage = fc<HomePageProps> { props ->
    +"Home"
}