package mx.com.charlyescaz.datagot.interactors

import mx.com.charlyescaz.datagot.models.ContinentViewModel
import mx.com.charlyescaz.datagot.utils.ModelExtensions.toListModel
import mx.com.charlyescaz.web.APIDataGoT

object ContinentInteractor {

    val api = APIDataGoT

    fun retrieveContinents(cb: (result: List<ContinentViewModel>?) -> Unit ){
        api.getContinents{ success, result ->
            if (!success && result !== null) {
                cb(null)
                return@getContinents
            }
            cb(result?.toListModel(ContinentViewModel::class.java))
        }
    }

    fun retrieveContinentsByName(name: String, cb: (result: List<ContinentViewModel>?) -> Unit ){
        api.getContinentsByName(name){ success, result ->
            if (!success && result !== null) {
                cb(null)
                return@getContinentsByName
            }
            cb(result?.toListModel(ContinentViewModel::class.java))
        }
    }


}