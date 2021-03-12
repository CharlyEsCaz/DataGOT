package mx.com.charlyescaz.datagot.interactors

import mx.com.charlyescaz.datagot.models.ReligionViewModel
import mx.com.charlyescaz.datagot.utils.ModelExtensions.toListModel
import mx.com.charlyescaz.web.APIDataGoT

object ReligionInteractor {

    val api = APIDataGoT

    fun retrieveReligions(cb: (result: List<ReligionViewModel>?) -> Unit ){
        api.getReligions{ success, result ->
            if (!success && result !== null) {
                cb(null)
                return@getReligions
            }
            cb(result?.toListModel(ReligionViewModel::class.java))
        }
    }

    fun retrieveReligionsByTitle(title: String, cb: (result: List<ReligionViewModel>?) -> Unit ){
        api.getReligionsByTitle(title){ success, result ->
            if (!success && result !== null) {
                cb(null)
                return@getReligionsByTitle
            }
            cb(result?.toListModel(ReligionViewModel::class.java))
        }
    }


}