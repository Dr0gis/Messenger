package team.corpore.`in`.messenger.domain.executor

interface MainThread {
    fun post(runnable: Runnable)
}