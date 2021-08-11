import kotlinx.coroutines.delay

suspend fun startBfs(gridState: State) {
    val start = gridState.findStartPosition() as Position
    val queue = mutableListOf(start)
    val visited = mutableSetOf<Position>()

    while(queue.isNotEmpty()){
        val position = queue.shift()
        visited.add(position)

        gridState.setCellVisitedAtPosition(position)
        gridState.moveRooomba(position)

        val neighbors = getValidNeighbors(position, gridState.getCurrentGrid())
        for(each in neighbors){
            if(visited.none { it.row == each.position.row && it.column == each.position.column }){
                queue.add(each.position)
            }
        }

    }
}

private fun getValidNeighbors(
    position: Position,
    grid: List<List<CellData>>
): List<CellData> {
    val neighbors = mutableListOf<CellData>()
    val (row, column) = position

    if (row > 0) neighbors.add(grid[row - 1][column])
    if (row < grid.size - 1) neighbors.add(grid[row + 1][column])
    if (column > 0) neighbors.add(grid[row][column - 1])
    if (column < grid[0].size - 1) neighbors.add(grid[row][column + 1])

    return neighbors.filter { it.type != CellType.WALL }
}
