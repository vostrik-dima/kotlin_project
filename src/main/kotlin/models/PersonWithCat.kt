package models

import Breed

data class PersonWithCat(val id: Int,
                         val name: String,
                         val age: Int,
                         val nickname: String,
                         val breed: Breed,
                         val ownerID: Int)