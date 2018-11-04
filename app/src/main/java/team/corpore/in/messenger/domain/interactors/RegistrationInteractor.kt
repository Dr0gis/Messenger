package team.corpore.`in`.messenger.domain.interactors

import team.corpore.`in`.messenger.domain.interactors.base.Interactor

interface RegistrationInteractor : Interactor {

    interface Callback {
        fun onRegistrationSuccess()
        fun onRegistrationFail(message: String)
    }

}