package mx.com.charlyescaz.datagot.utils

import com.google.gson.Gson
import mx.com.charlyescaz.datagot.models.*
import mx.com.charlyescaz.web.models.*

object ModelExtensions {
    val gson = Gson()

    fun BattleWS.toBattleViewModel() = toModel(this, BattleViewModel::class.java)
    fun CharacterWS.toCharacterViewModel() = toModel(this, CharacterViewModel::class.java)
    fun ContinentWS.toContinentViewModel() = toModel(this, ContinentViewModel::class.java)
    fun EpisodeWS.toEpisodeViewModel() = toModel(this, EpisodeViewModel::class.java)
    fun HouseWS.toHouseViewModel() = toModel(this, HouseViewModel::class.java)
    fun PlaceWS.toPlaceViewModel() = toModel(this, PlaceViewModel::class.java)
    fun ReligionWS.toReligionViewModel() = toModel(this, ReligionViewModel::class.java)

    fun <T> Any.toModel(ob: Any, cl: Class<T>): T {
        val data = gson.toJsonTree(ob).asJsonObject
        return gson.fromJson(data, cl)
    }

    public fun <T> List<Any>.toListModel(model: Class<T>): List<T> {
        val list = mutableListOf<T>()
        this.forEach { list.add(it.toModel(it, model)) }
        return list
    }
}