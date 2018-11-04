package team.corpore.`in`.messenger.domain.interactors.base

import team.corpore.`in`.messenger.domain.executor.Executor
import team.corpore.`in`.messenger.domain.executor.MainThread


abstract class AbstractInteractor(protected var threadExecutor: Executor, protected var mainThread: MainThread) : Interactor {

    @Volatile
    protected var isCanceled: Boolean = false
    @Volatile
    var isRunning: Boolean = false
        protected set

    abstract fun run()

    fun cancel() {
        isCanceled = true
        isRunning = false
    }

    fun onFinished() {
        isRunning = false
        isCanceled = false
    }

    final override fun execute() {
        this.isRunning = true
        threadExecutor.execute(this)
    }

}