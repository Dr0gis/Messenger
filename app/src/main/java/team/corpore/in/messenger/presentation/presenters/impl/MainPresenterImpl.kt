package team.corpore.`in`.messenger.presentation.presenters.impl

import team.corpore.`in`.messenger.domain.executor.Executor
import team.corpore.`in`.messenger.domain.executor.MainThread
import team.corpore.`in`.messenger.domain.interactors.WelcomingInteractor
import team.corpore.`in`.messenger.presentation.presenters.MainPresenter
import team.corpore.`in`.messenger.presentation.presenters.base.AbstractPresenter
import team.corpore.`in`.messenger.domain.interactors.impl.WelcomingInteractorImpl
import team.corpore.`in`.messenger.domain.repository.MessageRepository

class MainPresenterImpl(
    executor: Executor,
    mainThread: MainThread,
    private val messageRepository: MessageRepository,
    private val view: MainPresenter.View
) : AbstractPresenter(executor, mainThread), MainPresenter, WelcomingInteractor.Callback {

    override fun onMessageRetrieved(message: String) {
        view.hideProgress()
        view.displayWelcomeMessage(message)
    }

    override fun onRetrievalFailed(error: String) {
        view.hideProgress()
        onError(error)
    }

    override fun resume() {
        view.showProgress()
        val interactor = WelcomingInteractorImpl(
            executor,
            mainThread,
            this,
            messageRepository
        )
        interactor.execute()
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
}