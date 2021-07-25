
fun MutableList<MutableList<GridType>>.addRandomWalls(){
    for (i in 0 until WINDOW_WIDTH) {
        for (j in 0 until WINDOW_HEIGHT) {
            this[i][j] = weightedRandomWall()
        }
    }
}

fun MutableList<MutableList<GridType>>.addRoombaStart(){
    val i = (0..WINDOW_WIDTH).random()
    val j = (0..WINDOW_HEIGHT).random()

    this[i][j] = GridType.ROOMBA
}


fun weightedRandomWall(): GridType {
    val random = (0..100).random()
    return if (random in 0..80) GridType.BACKGROUND else GridType.WALL
}