package mx.com.charlyescaz.web.models

data class ContinentWS (
    val id: String? = "",
    val name: String? = "",
    val cardinalDirection: String? = "",
    val neighbors: List<String>? = null,
)