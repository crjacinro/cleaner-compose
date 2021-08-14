import kotlinx.coroutines.delay

class State {
    private var grid: MutableList<MutableList<CellData>> = mutableListOf()
    private var previousCleanerPosition: Position = Position(0, 0)
    private var roombaPosition: Position = Position(0, 0)

    init {
        clear()
    }

    private fun clear() {
        grid = getInitGridState()
        grid.addRandomWalls()
        grid.addCleanerStart()
    }

    fun findStartPosition(): Position? {
        for (i in 0 until WINDOW_WIDTH) {
            for (j in 0 until WINDOW_HEIGHT) {
                if (grid[i][j].isCleaner) {
                    roombaPosition = Position(i, j)
                    return roombaPosition
                }
            }
        }
        return null
    }

    fun drawDataGrid(): List<List<CellData>> {
        val updatedGrid = getInitGridState()

        for (i in 0 until updatedGrid.size) {
            for (j in 0 until updatedGrid[i].size) {
                updatedGrid[i][j] = grid[i][j]
            }
        }

        return updatedGrid
    }

    fun getCurrentGrid(): List<List<CellData>> = grid

    fun setCellVisitedAtPosition(p: Position) {
        grid[p.row][p.column] = getCellAtPosition(p).copy(isVisited = true, isCleaner = true)
    }

    suspend fun moveCleaner(p: Position) {
        grid[p.row][p.column] = getCellAtPosition(p).copy(isCleaner = true)
        delay(SPEED + 50)
        grid[p.row][p.column] = getCellAtPosition(p).copy(isCleaner = false)
    }

    private fun getCellAtPosition(p: Position) = grid[p.row][p.column]
}

fun getInitGridState(): MutableList<MutableList<CellData>> {
    val mutableGrid = MutableList(NUMBER_OF_GRIDS_PER_SIDE) {
        MutableList(NUMBER_OF_GRIDS_PER_SIDE) { CellData(CellType.BACKGROUND, Position(0, 0)) }
    }

    for (i in 0 until WINDOW_WIDTH) {
        for (j in 0 until WINDOW_HEIGHT) {
            mutableGrid[i][j] = CellData(CellType.BACKGROUND, Position(i, j))
        }
    }

    return mutableGrid
}