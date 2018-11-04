package team.corpore.`in`.messenger.presentation.presenters

import team.corpore.`in`.messenger.presentation.ui.BaseView

interface LoginPresenter {

    fun login(email: String, password: String)

    interface View : BaseView {
        fun loginSuccess()
    }

}