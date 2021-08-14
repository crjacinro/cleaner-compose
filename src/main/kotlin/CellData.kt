data class CellData(
    var type: CellType,
    val position: Position,
    var isVisited: Boolean = false,
    var isCleaner: Boolean = false,
)
