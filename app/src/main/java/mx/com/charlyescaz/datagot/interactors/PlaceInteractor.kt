package mx.com.charlyescaz.datagot.interactors

import mx.com.charlyescaz.datagot.models.PlaceViewModel
import mx.com.charlyescaz.datagot.utils.ModelExtensions.toListModel
import mx.com.charlyescaz.datagot.utils.ModelExtensions.toPlaceViewModel
import mx.com.charlyescaz.web.APIDataGoT

object PlaceInteractor {

    val api = APIDataGoT

    fun retrieveCities(cb: (result: List<PlaceViewModel>?) -> Unit ){
        api.getCities{ success, result ->
            if (!success && result !== null) {
                cb(null)
                return@getCities
            }
            cb(result?.toListModel(PlaceViewModel::class.java))
        }
    }

    fun retrieveCity(name: String, cb: (result: PlaceViewModel?) -> Unit ){
        api.getCityByName(name){ success, result ->
            if (!success && result !== null) {
                cb(null)
                return@getCityByName
            }
            cb(result?.toPlaceViewModel())
        }
    }

    fun retrieveCastles(cb: (result: List<PlaceViewModel>?) -> Unit ){
        api.getCastles{ success, result ->
            if (!success && result !== null) {
                cb(null)
                return@getCastles
            }
            cb(result?.toListModel(PlaceViewModel::class.java))
        }
    }

    fun retrieveCastlesByName(name: String, cb: (result: List<PlaceViewModel>?) -> Unit ){
        api.getCastlesByName(name){ success, result ->
            if (!success && result !== null) {
                cb(null)
                return@getCastlesByName
            }
            cb(result?.toListModel(PlaceViewModel::class.java))
        }
    }


}