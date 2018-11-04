package team.corpore.`in`.messenger.presentation.presenters.base

import team.corpore.`in`.messenger.domain.executor.Executor
import team.corpore.`in`.messenger.domain.executor.MainThread

abstract class AbstractPresenter(protected var executor: Executor, protected var mainThread: MainThread) : BasePresenter