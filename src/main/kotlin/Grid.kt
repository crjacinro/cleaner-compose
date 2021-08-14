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
    BACKGROUND
}

@Suppress("FunctionName")
@Composable
fun CleanerGrid(cellData: CellData) {
    val boxModifier = Modifier
        .padding(0.dp)
        .border(BorderStroke(1.dp, Color.Gray))
        .size(GRID_SIZE_DP)
        .background(getBackground(cellData))

    Box(modifier = boxModifier)
}

private fun getBackground(cell: CellData) =
    when {
        cell.isCleaner -> ROOMBA_COLOR
        cell.isVisited -> VISITED_COLOR
        cell.type == CellType.BACKGROUND -> BACKGROUND_COLOR
        cell.type == CellType.WALL -> WALL_COLOR
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