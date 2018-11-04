package team.corpore.`in`.messenger.presentation.presenters.impl

import team.corpore.`in`.messenger.domain.executor.Executor
import team.corpore.`in`.messenger.domain.executor.MainThread
import team.corpore.`in`.messenger.domain.interactors.LoginInteractor
import team.corpore.`in`.messenger.domain.interactors.impl.LoginInteractorImpl
import team.corpore.`in`.messenger.domain.repository.LoginRepository
import team.corpore.`in`.messenger.presentation.presenters.LoginPresenter
import team.corpore.`in`.messenger.presentation.presenters.base.AbstractPresenter

class LoginPresenterImpl(
    executor: Executor,
    mainThread: MainThread,
    private val loginRepository: LoginRepository,
    private val view: LoginPresenter.View
) : AbstractPresenter(executor, mainThread), LoginPresenter, LoginInteractor.Callback {

    override fun resume() {

    }

    override fun pause() {

    }

    override fun stop() {

    }

    override fun destroy() {

    }

    override fun onError(message: String) {
        view.showError(message)
    }

    override fun login(email: String, password: String) {
        view.showProgress()
        val interactor = LoginInteractorImpl(
            executor,
            mainThread,
            this,
            loginRepository,
            email,
            password
        )
        interactor.execute()
    }

    override fun onLoginSuccess() {
        view.hideProgress()
        view.loginSuccess()
    }

    override fun onLoginFail(message: String) {
        view.hideProgress()
        onError(message)
    }

}