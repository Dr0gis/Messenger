package team.corpore.`in`.messenger.domain.interactors.impl

import team.corpore.`in`.messenger.domain.executor.Executor
import team.corpore.`in`.messenger.domain.executor.MainThread
import team.corpore.`in`.messenger.domain.interactors.WelcomingInteractor
import team.corpore.`in`.messenger.domain.interactors.base.AbstractInteractor
import team.corpore.`in`.messenger.domain.repository.MessageRepository

class WelcomingInteractorImpl(
    threadExecutor: Executor,
    mainThread: MainThread,
    private val callback: WelcomingInteractor.Callback,
    private val messageRepository: MessageRepository
) : AbstractInteractor(threadExecutor, mainThread), WelcomingInteractor {

    private fun notifyError() {
        mainThread.post(Runnable {
           callback.onRetrievalFailed("Nothing to welcome you with :(")
        })
    }

    private fun postMessage(msg: String) {
        mainThread.post(Runnable {
            callback.onMessageRetrieved(msg)
        })
    }

    override fun run() {
        val message = messageRepository.getWelcomeMessage()
        if (message.isEmpty()) {
            notifyError()
            return
        }
        postMessage(message)
    }

}