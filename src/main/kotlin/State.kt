class State {
    private var gridState: MutableList<MutableList<GridType>> = mutableListOf()

    init {
        clear()
    }

    private fun clear() {
        gridState = getInitGridState()
        gridState.addRandomWalls()
        gridState.addRoombaStart()
    }

    fun drawSnakeDataGrid(): List<List<GridType>> {
        val updatedGrid = getInitGridState()

        for (i in 0 until updatedGrid.size) {
            for (j in 0 until updatedGrid[i].size) {
                updatedGrid[i][j] = gridState[i][j]
            }
        }

        return updatedGrid
    }
}

fun getInitGridState(): MutableList<MutableList<GridType>> {
    val mutableGrid = MutableList(NUMBER_OF_GRIDS_PER_SIDE) {
        MutableList(NUMBER_OF_GRIDS_PER_SIDE) { GridType.BACKGROUND }
    }

    for (i in 0 until WINDOW_WIDTH) {
        for (j in 0 until WINDOW_HEIGHT) {
            mutableGrid[i][j] = GridType.BACKGROUND
        }
    }

    return mutableGrid
}