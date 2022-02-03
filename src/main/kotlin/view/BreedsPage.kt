package view

import react.fc

external interface BreedsPageProps : ApplicationProps

val BreedsPage = fc<BreedsPageProps> { props ->
    +"Breeds"
}