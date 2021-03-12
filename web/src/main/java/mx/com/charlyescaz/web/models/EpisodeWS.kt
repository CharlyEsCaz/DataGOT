package mx.com.charlyescaz.web.models

import com.google.gson.annotations.SerializedName

data class EpisodeWS (

    val id: String? = "",

    val title: String? = "",

    val season: Int? = 0,

    val episode: Int? = 0,

    @SerializedName("written_by")
    val writtenBy: List<String>? = null,

    @SerializedName("directed_by")
    val directedBy: List<String>? = null,

    val characters: List<String>? = null,

    val deaths: List<String>? = null,

    val places: List<String>? = null,
)