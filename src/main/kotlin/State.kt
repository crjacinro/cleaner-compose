class State {
    private var grid: MutableList<MutableList<CellData>> = mutableListOf()

    init {
        clear()
    }

    private fun clear() {
        grid = getInitGridState()
        grid.addRandomWalls()
        grid.addRoombaStart()
    }

    fun findStartPosition(): Position? {
        for (i in 0 until WINDOW_WIDTH) {
            for (j in 0 until WINDOW_HEIGHT) {
                if (grid[i][j].type == CellType.ROOMBA) {
                    return Position(i, j)
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