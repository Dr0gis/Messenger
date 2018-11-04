package team.corpore.`in`.messenger.presentation.presenters

import team.corpore.`in`.messenger.presentation.ui.BaseView

interface RegistrationPresenter {

    fun registration(email: String, password: String)

    interface View : BaseView {
        fun registrationSuccess()
    }

}