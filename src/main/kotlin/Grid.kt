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
    VISITED,
    WALL,
    ROOMBA,
    PATH,
    BACKGROUND
}

@Suppress("FunctionName")
@Composable
fun RoombaGrid(cellData: CellData) {
    val boxModifier = Modifier
        .padding(0.dp)
        .border(getBorderStroke(cellData.type))
        .size(GRID_SIZE_DP)
        .background(getBackground(cellData.type))

    Box(modifier = boxModifier)
}

private fun getBorderStroke(cellType: CellType) =
    when (cellType) {
        CellType.BACKGROUND -> BorderStroke(1.dp, Color.Gray)
        CellType.VISITED -> BorderStroke(0.dp, VISITED_COLOR)
        CellType.WALL -> BorderStroke(0.dp, WALL_COLOR)
        CellType.PATH -> BorderStroke(0.dp, PATH_COLOR)
        CellType.ROOMBA -> BorderStroke(0.dp, ROOMBA_COLOR)
    }

private fun getBackground(cellType: CellType) =
    when (cellType) {
        CellType.BACKGROUND -> BACKGROUND_COLOR
        CellType.VISITED -> VISITED_COLOR
        CellType.WALL -> WALL_COLOR
        CellType.PATH -> PATH_COLOR
        CellType.ROOMBA -> ROOMBA_COLOR
    }

fun List<List<CellData>>.toLinearList(): List<CellData> {
    val mutableList = mutableListOf<CellData>()
    for (i in this.indices) {
        for (j in this[i].indices) {
            mutableList.add(this[i][j])
        }
    }
    return mutableList.toList()
}