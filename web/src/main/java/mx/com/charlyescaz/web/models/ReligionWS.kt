package mx.com.charlyescaz.web.models

data class ReligionWS (
    val id: String? = "",
    val rulers: List<String>? = null,
    val culture: List<String>? = null,
    val cities: List<String>? = null,
    val castles: List<String>? = null,
    val founder: List<String>? = null,
    val name: String? = ""
)