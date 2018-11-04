package team.corpore.`in`.messenger.domain.executor

import team.corpore.`in`.messenger.domain.interactors.base.AbstractInteractor


interface Executor {
    fun execute(interactor: AbstractInteractor)
}