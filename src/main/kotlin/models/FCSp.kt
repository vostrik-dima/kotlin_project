package models

data class FCSp(val fcName: String, val spName: String) {
    override fun toString(): String {
        return "$fcName + $spName"
    }
}