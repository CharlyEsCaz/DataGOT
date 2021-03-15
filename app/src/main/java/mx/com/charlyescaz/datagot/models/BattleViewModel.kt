package mx.com.charlyescaz.datagot.models

import com.google.gson.annotations.SerializedName

class BattleViewModel {
    val id: String = ""

    val name: String = ""

    @SerializedName("dateOfBattle")
    val date: String = ""

    val conflict: String = ""

    val places: List<String>? = null

    val factionsOne: List<String>? = null

    val factionsTwo: List<String>? = null

    val commandersOne: List<String>? = null

    val commandersTwo: List<String>? = null

    val forcesOne: List<String>? = null

    val forcesTwo: List<String>? = null
}