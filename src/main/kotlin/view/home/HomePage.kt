package view.home

import react.fc
import view.ApplicationProps

external interface HomePageProps : ApplicationProps

val HomePage = fc<HomePageProps> { props ->
    +"Home"
}