package team.corpore.`in`.messenger.presentation.ui

import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity : AppCompatActivity() {

    val disposable = CompositeDisposable()

    fun showProgress() {

    }

    fun hideProgress() {

    }

    fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}