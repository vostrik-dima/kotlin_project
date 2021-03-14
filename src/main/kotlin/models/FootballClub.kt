package models

data class FootballClub(val id: Int, val name: String, val country: String) {
    override fun toString(): String {
        return "Football club $name, country: $country, id: $id"
    }
}