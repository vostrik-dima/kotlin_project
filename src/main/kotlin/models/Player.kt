package models

data class Player(val id: Int, val name: String, val surname: String, val number: Int, val footballClubID: Int) {
    override fun toString(): String {
        return "Player $name $surname, number: $number, id: $id, football club id: $footballClubID"
    }
}