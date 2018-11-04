package team.corpore.`in`.messenger.presentation.presenters.impl

import team.corpore.`in`.messenger.domain.executor.Executor
import team.corpore.`in`.messenger.domain.executor.MainThread
import team.corpore.`in`.messenger.domain.interactors.RegistrationInteractor
import team.corpore.`in`.messenger.domain.interactors.impl.RegistrationInteractorImpl
import team.corpore.`in`.messenger.domain.repository.RegistrationRepository
import team.corpore.`in`.messenger.presentation.presenters.RegistrationPresenter
import team.corpore.`in`.messenger.presentation.presenters.base.AbstractPresenter

class RegistrationPresenterImpl(
    executor: Executor,
    mainThread: MainThread,
    private val loginRepository: RegistrationRepository,
    private val view: RegistrationPresenter.View
) : AbstractPresenter(executor, mainThread), RegistrationPresenter, RegistrationInteractor.Callback {

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

    override fun registration(email: String, password: String) {
        view.showProgress()
        val interactor = RegistrationInteractorImpl(
            executor,
            mainThread,
            this,
            loginRepository,
            email,
            password
        )
        interactor.execute()
    }

    override fun onRegistrationSuccess() {
        view.hideProgress()
        view.registrationSuccess()
    }

    override fun onRegistrationFail(message: String) {
        view.hideProgress()
        onError(message)
    }

}