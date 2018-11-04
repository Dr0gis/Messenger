package team.corpore.`in`.messenger.presentation.presenters.base

interface BasePresenter {

    fun resume()

    fun pause()

    fun stop()

    fun destroy()

    fun onError(message: String)
}