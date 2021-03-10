package mx.com.charlyescaz.datagot.models

import com.google.gson.annotations.SerializedName

class CharacterViewModel {
    val id: String = ""

    val name: String = ""

    @SerializedName("image")
    val imgUrl: String = ""

    val titles: List<String>? = null

    val origin: List<String>? = null

    val siblings: List<String>? = null

    val spouse: List<String>? = null

    val lovers: List<String>? = null

    @SerializedName("religion")
    val religions: List<String>? = null

    val allegiances: List<String>? = null

    val gender: String = ""

    val alive: Boolean = false

    val death: Int = 0

    val father: String = ""

    val house: String = ""

    val actor: String = ""

//    var appearances: List<String>? = null
}