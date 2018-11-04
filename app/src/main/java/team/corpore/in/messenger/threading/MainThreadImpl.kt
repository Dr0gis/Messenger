package team.corpore.`in`.messenger.threading

import android.os.Handler
import android.os.Looper
import team.corpore.`in`.messenger.domain.executor.MainThread


object MainThreadImpl : MainThread {

    private val mHandler: Handler = Handler(Looper.getMainLooper())

    override fun post(runnable: Runnable) {
        mHandler.post(runnable)
    }

}