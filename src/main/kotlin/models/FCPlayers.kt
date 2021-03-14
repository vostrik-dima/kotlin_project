package models

data class FCPlayers(val fcName: String, val playerName: String, val playerSurname: String) {
    override fun toString(): String {
        return "$fcName $playerName + $playerSurname"
    }
}