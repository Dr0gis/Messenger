package team.corpore.`in`.messenger.threading

import team.corpore.`in`.messenger.domain.executor.Executor
import team.corpore.`in`.messenger.domain.interactors.base.AbstractInteractor
import java.util.concurrent.Executors

object ExecutorImpl : Executor {

    private val executorService = Executors.newCachedThreadPool()

    override fun execute(interactor: AbstractInteractor) {
        executorService.execute {
            interactor.run()
        }
    }

}