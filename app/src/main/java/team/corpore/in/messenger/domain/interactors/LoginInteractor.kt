package team.corpore.`in`.messenger.domain.interactors

import team.corpore.`in`.messenger.domain.interactors.base.Interactor

interface LoginInteractor : Interactor {

    interface Callback {
        fun onLoginSuccess()
        fun onLoginFail(message: String)
    }

}