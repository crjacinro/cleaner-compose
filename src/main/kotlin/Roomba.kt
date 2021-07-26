@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Suppress("FunctionName")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RoombaApp(grid: List<List<GridType>>) {
    SnakeWindow(grid.toLinearList())
}

@Suppress("FunctionName")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SnakeWindow(gridData: List<GridType>) {
    LazyVerticalGrid(cells = GridCells.Fixed(NUMBER_OF_GRIDS_PER_SIDE)) {
        items(gridData) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                RoombaGrid(it)
            }
        }
    }
}