package org.coner.worker.util.testfx

import javafx.scene.Node
import org.testfx.api.FxRobot

inline fun <reified T : Node> FxRobot.lookupAndQuery(query: String): T {
    return lookup(query).query()
}