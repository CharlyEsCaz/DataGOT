package mx.com.charlyescaz.web.models

data class PlaceWS (
    val id: String? = "",
    val name: String? = "",
    val type: String? = "",
    val location: String? = "",
    val religion: List<String>? = null,
    val rulers: List<String>? = null,
    val founder: List<String>? = null,
)