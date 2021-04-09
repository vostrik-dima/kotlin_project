package models

data class Sponsor(val id: Int, val name: String, val budget: Int) {
    override fun toString(): String {
        return "Sponsor $name has budget: $budget. Id: $id"
    }
}