import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

enum class GridType {
    VISITED,
    WALL,
    ROOMBA,
    PATH,
    BACKGROUND
}

@Suppress("FunctionName")
@Composable
fun RoombaGrid(gridType: GridType) {
    val boxModifier = Modifier
        .padding(0.dp)
        .border(getBorderStroke(gridType))
        .size(GRID_SIZE_DP)
        .background(getBackground(gridType))

    Box(modifier = boxModifier)
}

private fun getBorderStroke(gridType: GridType) =
    when (gridType) {
        GridType.BACKGROUND -> BorderStroke(1.dp, Color.Gray)
        GridType.VISITED -> BorderStroke(0.dp, VISITED_COLOR)
        GridType.WALL -> BorderStroke(0.dp, WALL_COLOR)
        GridType.PATH -> BorderStroke(0.dp, PATH_COLOR)
        GridType.ROOMBA -> BorderStroke(0.dp, ROOMBA_COLOR)
    }

private fun getBackground(gridType: GridType) =
    when (gridType) {
        GridType.BACKGROUND -> BACKGROUND_COLOR
        GridType.VISITED -> VISITED_COLOR
        GridType.WALL -> WALL_COLOR
        GridType.PATH -> PATH_COLOR
        GridType.ROOMBA -> ROOMBA_COLOR
    }

fun List<List<GridType>>.toLinearList(): List<GridType> {
    val mutableList = mutableListOf<GridType>()
    for (i in this.indices) {
        for (j in this[i].indices) {
            mutableList.add(this[i][j])
        }
    }
    return mutableList.toList()
}