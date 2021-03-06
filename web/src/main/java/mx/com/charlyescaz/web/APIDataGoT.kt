package mx.com.charlyescaz.web

import android.util.Log
import com.google.gson.GsonBuilder
import mx.com.charlyescaz.web.api.serializers.BooleanDeserializer
import mx.com.charlyescaz.web.api.serializers.BooleanSerializer
import mx.com.charlyescaz.web.api.serializers.DateDeserializer
import mx.com.charlyescaz.web.api.serializers.DateSerializer
import mx.com.charlyescaz.web.models.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

object APIDataGoT {

    private const val TAG = "API_DATA_GOT"
    private val apiService: DataGoTService

    init{

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        //Prepare http client
        val httpClientBuilder = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build()

        // Prepare Gson instance
        val gson = GsonBuilder()
                .registerTypeAdapter(Boolean::class.java, BooleanSerializer())
                .registerTypeAdapter(Boolean::class.java, BooleanDeserializer())
                .registerTypeAdapter(Boolean::class.javaPrimitiveType, BooleanSerializer())
                .registerTypeAdapter(Boolean::class.javaPrimitiveType, BooleanDeserializer())
                .registerTypeAdapter(Date::class.java, DateSerializer())
                .registerTypeAdapter(Date::class.java, DateDeserializer())
                .create()

        //Prepare retrofit instance
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.api_base)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClientBuilder)
                .build()

        apiService = retrofit.create(DataGoTService::class.java)
    }

    private fun <T>doRequest(operation: String, call: Call<T>, cb: (success: Boolean, data: T?) -> Unit) {
        call.enqueue(object : Callback<T> {
            override fun onFailure(call: Call<T>, t: Throwable) {
                handleFailure(operation,t,cb)
            }
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    cb(true, response.body())
                } else {
                    handleUnsuccessful(operation, cb)
                }

            }

        })
    }

    private fun <T>handleUnsuccessful(operation: String,callback: (success: Boolean,data: T?) -> Unit) {
        Log.w(TAG,"$operation was unsuccessful")
        callback(false, null)
    }

    private fun <T>handleFailure(operation: String, t: Throwable,callback: (success: Boolean,data: T?) -> Unit) {
        Log.e(TAG, "$operation has failed")
        Log.e(TAG, "Message is: " + t.message)
        callback(false, null)
    }

    fun getBattles(cb: (success: Boolean, data: List<BattleWS>?) -> Unit){
        doRequest(
            "Get All Battles",
            apiService.getBattles(),
            cb
        )
    }

    fun getBattlesByConflict(conflict: String, cb: (success: Boolean, data: List<BattleWS>?) -> Unit){
        doRequest(
            "Get Battles By Conflict",
            apiService.getBattlesByConflict(conflict),
            cb
        )
    }

    fun getBattlesByName(name: String, cb: (success: Boolean, data: List<BattleWS>?) -> Unit){
        doRequest(
            "Get Battles By Name",
            apiService.getBattlesByName(name),
            cb
        )
    }

    fun getCharacters(cb: (success: Boolean, data: List<CharacterWS>?) -> Unit){
        doRequest(
            "Get All Characters",
            apiService.getCharacters(),
            cb
        )
    }

    fun getCharactersByHouse(house: String,cb: (success: Boolean, data: List<CharacterWS>?) -> Unit){
        doRequest(
            "Get Characters by House",
            apiService.getCharactersByHouse(house),
            cb
        )
    }

    fun getCharacter(name: String, cb: (success: Boolean, data: CharacterWS?) -> Unit){
        doRequest(
            "Get Character",
            apiService.getCharacter(name),
            cb
        )
    }

    fun getContinents(cb: (success: Boolean, data: List<ContinentWS>?) -> Unit){
        doRequest(
            "Get All Continents",
            apiService.getContinents(),
            cb
        )
    }

    fun getContinentsByName(name: String,cb: (success: Boolean, data: List<ContinentWS>?) -> Unit){
        doRequest(
            "Get Continents By Name",
            apiService.getContinentsByName(name),
            cb
        )
    }

    fun getEpisodes(cb: (success: Boolean, data: List<EpisodeWS>?) -> Unit){
        doRequest(
            "Get All Episodes",
            apiService.getEpisodes(),
            cb
        )
    }

    fun getEpisodeByTitle(title: String, cb: (success: Boolean, data: EpisodeWS?) -> Unit){
        doRequest(
            "Get Episode by Title",
            apiService.getEpisode(title),
            cb
        )
    }

    fun getHouses(cb: (success: Boolean, data: List<HouseWS>?) -> Unit){
        doRequest(
            "Get All Houses",
            apiService.getHouses(),
            cb
        )
    }

    fun getHouseByName(name: String, cb: (success: Boolean, data: HouseWS?) -> Unit){
        doRequest(
            "Get House by Name",
            apiService.getHouse(name),
            cb
        )
    }

    fun getCities(cb: (success: Boolean, data: List<PlaceWS>?) -> Unit){
        doRequest(
            "Get All Cities",
            apiService.getCities(),
            cb
        )
    }

    fun getCityByName(name: String, cb: (success: Boolean, data: List<PlaceWS>?) -> Unit){
        doRequest(
            "Get City by Name",
            apiService.getCityByName(name),
            cb
        )
    }

    fun getCastles(cb: (success: Boolean, data: List<PlaceWS>?) -> Unit){
        doRequest(
            "Get All Castles",
            apiService.getCastles(),
            cb
        )
    }

    fun getCastlesByName(name: String, cb: (success: Boolean, data: List<PlaceWS>?) -> Unit){
        doRequest(
            "Get Castles by Name",
            apiService.getCastlesByName(name),
            cb
        )
    }

    fun getReligions(cb: (success: Boolean, data: List<ReligionWS>?) -> Unit){
        doRequest(
            "Get All Religions",
            apiService.getReligions(),
            cb
        )
    }

    fun getReligionsByTitle(title: String, cb: (success: Boolean, data: List<ReligionWS>?) -> Unit){
        doRequest(
            "Get Religions by Title",
            apiService.getReligionsByTitle(title),
            cb
        )
    }

}