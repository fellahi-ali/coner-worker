package org.coner.worker.page

import javafx.scene.Node
import org.coner.worker.ConerPalette
import org.coner.worker.model.ConnectionPreferences
import org.coner.worker.model.KEY_CONNECTION_PREFERENCES
import tornadofx.*

class MainView : View() {

    val controller: MainController by inject()
    lateinit var center: Node

    override val root = borderpane {
        top {
            hbox {
                style {
                    background = ConerPalette.LOGO_DARK_GRAY.asBackground()
                }
                add(LogoView::class)
            }
        }
        center(MainCenterView::class)
    }

    init {
        title = messages["title"]
        runLater { controller.afterInit() }
    }
}

class MainCenterView : View() {
    override val root = pane { }
}

class MainController : Controller() {

    fun afterInit() {
        if (app.config.jsonModel<ConnectionPreferences>(KEY_CONNECTION_PREFERENCES) == null) {
            find(MainCenterView::class).replaceChildren { replaceWith(EstablishConnectionView::class) }
        } else {
            TODO("handle launch with config defined")
        }
    }
}
