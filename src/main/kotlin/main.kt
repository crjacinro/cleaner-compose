@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

import androidx.compose.desktop.Window
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.window.application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay

private val appState = State()
private val scope = CoroutineScope(Dispatchers.Default)

@OptIn(ExperimentalComposeUiApi::class)
fun main() = application {
    Window(
        title = "Cleaner using Compose",
        resizable = false,
        size = IntSize(WINDOW_SIZE, WINDOW_SIZE + WINDOW_HEIGHT_OFFSET),
        centered = true
    ) {
        CleanerWindow()
    }
}

@Suppress("FunctionName")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CleanerWindow() {
    val grid = remember { mutableStateOf(appState.drawDataGrid()) }
    CleanerApp(grid.value)

    LaunchedEffect(Unit) {
        while (true) {
            delay(SPEED)
            grid.value = appState.drawDataGrid()
        }
    }
    LaunchedEffect(Unit, scope) {
        delay(2_000)
        startDfs(appState)
    }
}
