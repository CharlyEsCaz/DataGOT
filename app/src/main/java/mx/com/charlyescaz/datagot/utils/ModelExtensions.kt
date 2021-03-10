package mx.com.charlyescaz.datagot.utils

import com.google.gson.Gson
import mx.com.charlyescaz.datagot.models.CharacterViewModel
import mx.com.charlyescaz.web.models.CharacterWS

object ModelExtensions {
    val gson = Gson()

    fun CharacterWS.toCharacterViewModel() = toModel(this, CharacterViewModel::class.java)

    fun <T> Any.toModel(ob: Any, cl: Class<T>): T {
        val data = gson.toJsonTree(ob).asJsonObject
        return gson.fromJson(data, cl)
    }
}