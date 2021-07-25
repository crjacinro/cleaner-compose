@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

import androidx.compose.desktop.Window
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.window.application

import kotlinx.coroutines.delay
val appState = State()

@OptIn(ExperimentalComposeUiApi::class)
fun main() = application {
    Window(
        title = "Roomba using Jetpack Compose",
        resizable = false,
        size = IntSize(WINDOW_SIZE, WINDOW_SIZE + WINDOW_HEIGHT_OFFSET),
        centered = true
    ) {
        val grid = remember { mutableStateOf(appState.drawSnakeDataGrid()) }

        RoombaApp(grid.value)

        LaunchedEffect(Unit) {
            while (true) {
                delay(SPEED.toLong())
            }
        }
    }
}