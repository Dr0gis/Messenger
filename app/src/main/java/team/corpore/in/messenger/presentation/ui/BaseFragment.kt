package team.corpore.`in`.messenger.presentation.ui

import android.support.v4.app.Fragment
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment : Fragment() {

    val disposable = CompositeDisposable()

    fun showProgress() = (activity as BaseActivity).showProgress()

    fun hideProgress() = (activity as BaseActivity).hideProgress()

    fun showError(message : String) = (activity as BaseActivity).showError(message)

    override fun onDetach() {
        super.onDetach()
        disposable.dispose()
    }
}