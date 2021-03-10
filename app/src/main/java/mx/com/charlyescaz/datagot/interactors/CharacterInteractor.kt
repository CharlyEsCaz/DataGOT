package mx.com.charlyescaz.datagot.interactors

import mx.com.charlyescaz.datagot.models.CharacterViewModel
import mx.com.charlyescaz.datagot.utils.ModelExtensions.toCharacterViewModel
import mx.com.charlyescaz.web.APIDataGoT

object CharacterInteractor {

    val api = APIDataGoT

    fun retrieveCharacter(name: String, cb: (result: CharacterViewModel?) -> Unit ){
        api.getCharacter(name){ success, result ->
            if (!success && result !== null) {
                cb(null)
                return@getCharacter
            }
            cb(result?.toCharacterViewModel())
        }
    }
}