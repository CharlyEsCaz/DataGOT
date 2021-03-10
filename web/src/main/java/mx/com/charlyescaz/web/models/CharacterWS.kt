package mx.com.charlyescaz.web.models

import com.google.gson.annotations.SerializedName

data class CharacterWS (

    var id: String? = "",

    var name: String? = "",

    @SerializedName("image")
    var imgUrl: String? = "",

    var titles: List<String>? = null,

    var origin: List<String>? = null,

    var siblings: List<String>? = null,

    var spouse: List<String>? = null,

    var lovers: List<String>? = null,

    var religion: List<String>? = null,

    var allegiances: List<String>? = null,

    var gender: String? = "",

    var alive: Boolean? = false,

    var death: Int? = 0,

    var father: String? = "",

    var house: String? = "",

    var actor: String? = ""

//    var appearances: List<String>? = null
)