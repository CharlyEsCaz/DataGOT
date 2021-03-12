package mx.com.charlyescaz.datagot.interactors

import mx.com.charlyescaz.datagot.models.EpisodeViewModel
import mx.com.charlyescaz.datagot.utils.ModelExtensions.toEpisodeViewModel
import mx.com.charlyescaz.datagot.utils.ModelExtensions.toListModel
import mx.com.charlyescaz.web.APIDataGoT

object EpisodeInteractor {

    val api = APIDataGoT

    fun retrieveEpisodes(cb: (result: List<EpisodeViewModel>?) -> Unit ){
        api.getEpisodes{ success, result ->
            if (!success && result !== null) {
                cb(null)
                return@getEpisodes
            }
            cb(result?.toListModel(EpisodeViewModel::class.java))
        }
    }

    fun retrieveEpisodeByTitle(title: String, cb: (result: EpisodeViewModel?) -> Unit ){
        api.getEpisodeByTitle(title){ success, result ->
            if (!success && result !== null) {
                cb(null)
                return@getEpisodeByTitle
            }
            cb(result?.toEpisodeViewModel())
        }
    }


}