package mx.com.charlyescaz.datagot.interactors

import mx.com.charlyescaz.datagot.models.HouseViewModel
import mx.com.charlyescaz.datagot.utils.ModelExtensions.toHouseViewModel
import mx.com.charlyescaz.datagot.utils.ModelExtensions.toListModel
import mx.com.charlyescaz.web.APIDataGoT

object HouseInteractor {

    val api = APIDataGoT

    fun retrieveHouses(cb: (result: List<HouseViewModel>?) -> Unit ){
        api.getHouses{ success, result ->
            if (!success && result !== null) {
                cb(null)
                return@getHouses
            }
            cb(result?.toListModel(HouseViewModel::class.java))
        }
    }

    fun retrieveHouse(name: String, cb: (result: HouseViewModel?) -> Unit ){
        api.getHouseByName(name){ success, result ->
            if (!success && result !== null) {
                cb(null)
                return@getHouseByName
            }
            cb(result?.toHouseViewModel())
        }
    }


}