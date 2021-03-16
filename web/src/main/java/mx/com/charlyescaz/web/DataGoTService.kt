package mx.com.charlyescaz.web

import mx.com.charlyescaz.web.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DataGoTService {

    // Get All Battles
    @GET(BuildConfig.api_base + "show/battles")
    fun getBattles(): Call<List<BattleWS>>

    // Get Battles By Conflict
    @GET(BuildConfig.api_base + "show/battles/byConflict/{conflict}")
    fun getBattlesByConflict(@Path("conflict") conflict: String): Call<List<BattleWS>>

    // Get Battles By Name
    @GET(BuildConfig.api_base + "show/battles/{name}")
    fun getBattlesByName(@Path("name") name: String): Call<List<BattleWS>>

    // Get All Characters
    @GET(BuildConfig.api_base + "show/characters")
    fun getCharacters(): Call<List<CharacterWS>>

    // Get Character by name
    @GET(BuildConfig.api_base + "show/characters/{name}")
    fun getCharacter(@Path("name") name: String): Call<CharacterWS>

    // Get Characters by house
    @GET(BuildConfig.api_base + "show/characters/byHouse/{house}")
    fun getCharactersByHouse(@Path("house") house: String): Call<List<CharacterWS>>

    // Get All Continents
    @GET(BuildConfig.api_base + "book/continents")
    fun getContinents(): Call<List<ContinentWS>>

    // Get Continents by name
    @GET(BuildConfig.api_base + "book/continents/{name}")
    fun getContinentsByName(@Path("name") name: String): Call<List<ContinentWS>>

    // Get All Episodes
    @GET(BuildConfig.api_base + "show/episodes")
    fun getEpisodes(): Call<List<EpisodeWS>>

    // Get Episode by Title
    @GET(BuildConfig.api_base + "show/episodes/{title}")
    fun getEpisode(@Path("title") title: String): Call<EpisodeWS>

    // Get All Houses
    @GET(BuildConfig.api_base + "show/houses")
    fun getHouses(): Call<List<HouseWS>>

    // Get House By Name
    @GET(BuildConfig.api_base + "show/houses/{name}")
    fun getHouse(@Path("name") name: String): Call<HouseWS>

    // Get All Cities
    @GET(BuildConfig.api_base + "show/cities")
    fun getCities(): Call<List<PlaceWS>>

    // Get City by name
    @GET(BuildConfig.api_base + "show/cities/{name}")
    fun getCityByName(@Path("name") name: String): Call<List<PlaceWS>>

    // Get All Castles
    @GET(BuildConfig.api_base + "show/castles")
    fun getCastles(): Call<List<PlaceWS>>

    // Get Castle by name
    @GET(BuildConfig.api_base + "show/castles/{name}")
    fun getCastlesByName(@Path("name") name: String): Call<List<PlaceWS>>

    // Get All Religions
    @GET(BuildConfig.api_base + "show/religions")
    fun getReligions(): Call<List<ReligionWS>>

    // Get Religions by title
    @GET(BuildConfig.api_base + "show/religions/{title}")
    fun getReligionsByTitle(@Path("title") title: String): Call<List<ReligionWS>>

}