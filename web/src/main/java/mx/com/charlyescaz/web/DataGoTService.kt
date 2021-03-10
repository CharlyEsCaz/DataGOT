package mx.com.charlyescaz.web

import mx.com.charlyescaz.web.models.CharacterWS
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DataGoTService {

    @GET(BuildConfig.api_base + "show/characters/{name}")
    fun getCharacter(@Path("name") name: String): Call<CharacterWS>

}