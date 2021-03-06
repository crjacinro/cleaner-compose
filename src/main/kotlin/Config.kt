import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

const val SQUARE_SIZE = 15
const val GRID_SIZE = 15
const val WINDOW_SIZE = GRID_SIZE * SQUARE_SIZE
const val WINDOW_HEIGHT_OFFSET = 22
const val NUMBER_OF_GRIDS_PER_SIDE = WINDOW_SIZE.div(GRID_SIZE)
const val WINDOW_WIDTH = NUMBER_OF_GRIDS_PER_SIDE
const val WINDOW_HEIGHT = NUMBER_OF_GRIDS_PER_SIDE
val GRID_SIZE_DP = GRID_SIZE.dp

// UI Configuration
val WALL_COLOR = Color.Black
val VISITED_COLOR = Color.White
val BACKGROUND_COLOR = Color.Yellow
val ROOMBA_COLOR = Color.Red

const val SPEED = 16.toLong()