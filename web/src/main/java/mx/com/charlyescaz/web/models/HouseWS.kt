package mx.com.charlyescaz.web.models

data class HouseWS (

    val id: String? = "",

    val name: String? = "",

    val sigil: String? = "",

    val words: String? = "",

    val seat: List<String>? = null,

    val allegiance: List<String>? = null,

    val region: List<String>? = null,

    val religion: List<String>? = null
)