package team.corpore.`in`.messenger.domain.interactors.impl

import team.corpore.`in`.messenger.domain.executor.Executor
import team.corpore.`in`.messenger.domain.executor.MainThread
import team.corpore.`in`.messenger.domain.interactors.LoginInteractor
import team.corpore.`in`.messenger.domain.interactors.base.AbstractInteractor
import team.corpore.`in`.messenger.domain.repository.LoginRepository

class LoginInteractorImpl(
    threadExecutor: Executor,
    mainThread: MainThread,
    private val callback: LoginInteractor.Callback,
    private val loginRepository: LoginRepository,
    private val username: String,
    private val password: String
) : AbstractInteractor(threadExecutor, mainThread), LoginInteractor {

    private fun loginSuccess() {
        mainThread.post(Runnable {
            callback.onLoginSuccess()
        })
    }

    private fun loginFailed(message: String) {
        mainThread.post(Runnable {
            callback.onLoginFail(message)
        })
    }

    override fun run() {
        val response = loginRepository.login(username, password)
        if (response) {
            loginSuccess()
        }
        else{
            loginFailed("Login failed!")
        }
    }

}