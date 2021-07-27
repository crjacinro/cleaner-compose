fun MutableList<MutableList<CellData>>.addRandomWalls() {
    for (i in 0 until WINDOW_WIDTH) {
        for (j in 0 until WINDOW_HEIGHT) {
            this[i][j] = CellData(weightedRandomWall(), Position(i, j))
        }
    }
}

fun MutableList<MutableList<CellData>>.addRoombaStart() {
    val i = (0..WINDOW_WIDTH).random()
    val j = (0..WINDOW_HEIGHT).random()

    this[i][j] = CellData(CellType.ROOMBA, Position(i, j))
}

fun MutableList<Position>.shift(): Position {
    val first = this.first()
    this.removeAt(0)
    return first
}

fun weightedRandomWall(): CellType {
    val random = (0..100).random()
    return if (random in 0..80) CellType.BACKGROUND else CellType.WALL
}