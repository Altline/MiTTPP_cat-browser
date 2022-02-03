import kotlinx.browser.window
import org.w3c.dom.Document

fun Document.isNearScrollEnd() =
    window.innerHeight + documentElement!!.scrollTop > documentElement!!.scrollHeight.toDouble() - 500