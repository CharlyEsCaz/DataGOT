package mx.com.charlyescaz.datagot.interactors

import mx.com.charlyescaz.datagot.models.BattleViewModel
import mx.com.charlyescaz.datagot.utils.ModelExtensions.toListModel
import mx.com.charlyescaz.web.APIDataGoT

object BattleInteractor {

    val api = APIDataGoT

    fun retrieveBattles(cb: (result: List<BattleViewModel>?) -> Unit ){
        api.getBattles{ success, result ->
            if (!success && result !== null) {
                cb(null)
                return@getBattles
            }
            cb(result?.toListModel(BattleViewModel::class.java))
        }
    }

    fun retrieveBattlesByConflict(conflict: String, cb: (result: List<BattleViewModel>?) -> Unit ){
        api.getBattlesByConflict(conflict){ success, result ->
            if (!success && result !== null) {
                cb(null)
                return@getBattlesByConflict
            }
            cb(result?.toListModel(BattleViewModel::class.java))
        }
    }

    fun retrieveBattlesByName(name: String, cb: (result: List<BattleViewModel>?) -> Unit ){
        api.getBattlesByName(name){ success, result ->
            if (!success && result !== null) {
                cb(null)
                return@getBattlesByName
            }
            cb(result?.toListModel(BattleViewModel::class.java))
        }
    }



}