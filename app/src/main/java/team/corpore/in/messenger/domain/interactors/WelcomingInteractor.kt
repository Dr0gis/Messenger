package team.corpore.`in`.messenger.domain.interactors

import team.corpore.`in`.messenger.domain.interactors.base.Interactor

interface WelcomingInteractor : Interactor {

    interface Callback {
        fun onMessageRetrieved(message: String)
        fun onRetrievalFailed(error: String)
    }

}
