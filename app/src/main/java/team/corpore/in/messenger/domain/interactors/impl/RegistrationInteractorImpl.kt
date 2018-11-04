package team.corpore.`in`.messenger.domain.interactors.impl

import team.corpore.`in`.messenger.domain.executor.Executor
import team.corpore.`in`.messenger.domain.executor.MainThread
import team.corpore.`in`.messenger.domain.interactors.RegistrationInteractor
import team.corpore.`in`.messenger.domain.interactors.base.AbstractInteractor
import team.corpore.`in`.messenger.domain.repository.RegistrationRepository

class RegistrationInteractorImpl(
    threadExecutor: Executor,
    mainThread: MainThread,
    private val callback: RegistrationInteractor.Callback,
    private val registrationRepository: RegistrationRepository,
    private val username: String,
    private val password: String
) : AbstractInteractor(threadExecutor, mainThread), RegistrationInteractor {

    private fun registrationSuccess() {
        mainThread.post(Runnable {
            callback.onRegistrationSuccess()
        })
    }

    private fun registrationFailed(message: String) {
        mainThread.post(Runnable {
            callback.onRegistrationFail(message)
        })
    }

    override fun run() {
        val response = registrationRepository.registration(username, password)
        if (response) {
            registrationSuccess()
        }
        else{
            registrationFailed("Registration failed!")
        }
    }

}