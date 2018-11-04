package team.corpore.`in`.messenger.presentation.presenters

import team.corpore.`in`.messenger.presentation.presenters.base.BasePresenter
import team.corpore.`in`.messenger.presentation.ui.BaseView

interface MainPresenter : BasePresenter {
    interface View : BaseView {
        fun displayWelcomeMessage(msg: String)
    }
}