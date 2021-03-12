package mx.com.charlyescaz.datagot.interactors

import mx.com.charlyescaz.datagot.models.CharacterViewModel
import mx.com.charlyescaz.datagot.utils.ModelExtensions.toCharacterViewModel
import mx.com.charlyescaz.datagot.utils.ModelExtensions.toListModel
import mx.com.charlyescaz.web.APIDataGoT

object CharacterInteractor {

    val api = APIDataGoT

    fun retrieveCharacters(cb: (result: List<CharacterViewModel>?) -> Unit ){
        api.getCharacters{ success, result ->
            if (!success && result !== null) {
                cb(null)
                return@getCharacters
            }
            cb(result?.toListModel(CharacterViewModel::class.java))
        }
    }

    fun retrieveCharactersByHouse(house: String, cb: (result: List<CharacterViewModel>?) -> Unit ){
        api.getCharactersByHouse(house){ success, result ->
            if (!success && result !== null) {
                cb(null)
                return@getCharactersByHouse
            }
            cb(result?.toListModel(CharacterViewModel::class.java))
        }
    }

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