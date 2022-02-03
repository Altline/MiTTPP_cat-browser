import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import react.dom.render
import services.CatService
import view.Application

private class Client(
    val coroutineScope: CoroutineScope,
    val catService: CatService
) {
    fun start() {
        window.onload = {
            val root = document.getElementById("root")!!
            render(root) {
                Application {
                    attrs.coroutineScope = coroutineScope
                    attrs.catService = catService
                }
            }
        }
    }
}

fun main() {
    Client(MainScope(), CatService()).start()
}
