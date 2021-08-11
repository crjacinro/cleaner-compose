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

enum class CellType {
    WALL,
    PATH,
    BACKGROUND
}

@Suppress("FunctionName")
@Composable
fun RoombaGrid(cellData: CellData) {
    val boxModifier = Modifier
        .padding(0.dp)
        .border(getBorderStroke(cellData))
        .size(GRID_SIZE_DP)
        .background(getBackground(cellData))

    Box(modifier = boxModifier)
}

private fun getBorderStroke(cell: CellData) =
    when {
        cell.isRoomba  -> BorderStroke(0.dp, ROOMBA_COLOR)
        cell.isVisited -> BorderStroke(0.dp, VISITED_COLOR)
        cell.type == CellType.BACKGROUND -> BorderStroke(1.dp, Color.Gray)
        cell.type == CellType.WALL -> BorderStroke(0.dp, WALL_COLOR)
        cell.type == CellType.PATH -> BorderStroke(0.dp, PATH_COLOR)
        else -> BorderStroke(1.dp, Color.Gray)
    }

private fun getBackground(cell: CellData) =
    when {
        cell.isRoomba -> ROOMBA_COLOR
        cell.isVisited -> VISITED_COLOR
        cell.type == CellType.BACKGROUND -> BACKGROUND_COLOR
        cell.type == CellType.WALL -> WALL_COLOR
        cell.type == CellType.PATH -> PATH_COLOR
        else -> BACKGROUND_COLOR
    }

fun List<List<CellData>>.toLinearList(): MutableList<CellData> {
    val mutableList = mutableListOf<CellData>()
    for (i in this.indices) {
        for (j in this[i].indices) {
            mutableList.add(this[i][j])
        }
    }
    return mutableList
}