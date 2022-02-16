package view.categories

import react.fc
import view.ApplicationProps

external interface CategoriesPageProps : ApplicationProps

val CategoriesPage = fc<CategoriesPageProps> {
    +"Categories"
}