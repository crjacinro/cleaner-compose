fun MutableList<MutableList<CellData>>.addRandomWalls() {
    for (i in 0 until WINDOW_WIDTH) {
        for (j in 0 until WINDOW_HEIGHT) {
            this[i][j] = CellData(weightedRandomWall(), Position(i, j))
        }
    }
}

fun MutableList<MutableList<CellData>>.addCleanerStart() {
    val i = (0 until WINDOW_WIDTH).random()
    val j = (0 until WINDOW_HEIGHT).random()

    this[i][j] = CellData(CellType.WALL, Position(i, j), isCleaner = true)
}

fun weightedRandomWall(): CellType {
    val random = (0..100).random()
    return if (random in 0..80) CellType.BACKGROUND else CellType.WALL
}