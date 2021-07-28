@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

import androidx.compose.desktop.Window
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.window.application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val appState = State()
private val scope = CoroutineScope(Dispatchers.Default)

@OptIn(ExperimentalComposeUiApi::class)
fun main() = application {
    Window(
        title = "Roomba using Jetpack Compose",
        resizable = false,
        size = IntSize(WINDOW_SIZE, WINDOW_SIZE + WINDOW_HEIGHT_OFFSET),
        centered = true
    ) {
        val grid = remember { mutableStateOf(appState.drawDataGrid()) }

        RoombaApp(grid.value)

        LaunchedEffect(Unit) {
            while (true) {
                delay(SPEED)
                grid.value = appState.drawDataGrid()
            }
        }
        scope.launch {
            startBfs(appState)
        }
    }
}