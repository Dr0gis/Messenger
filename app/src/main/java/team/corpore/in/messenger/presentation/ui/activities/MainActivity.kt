package team.corpore.`in`.messenger.presentation.ui.activities

import android.os.Bundle
import android.widget.Toast
import team.corpore.`in`.messenger.R
import team.corpore.`in`.messenger.outside.MessageRepositoryHandler
import team.corpore.`in`.messenger.presentation.presenters.MainPresenter
import team.corpore.`in`.messenger.presentation.presenters.impl.MainPresenterImpl
import team.corpore.`in`.messenger.presentation.ui.BaseActivity
import team.corpore.`in`.messenger.threading.ExecutorImpl
import team.corpore.`in`.messenger.threading.MainThreadImpl

class MainActivity : BaseActivity(), MainPresenter.View {

    private val presenter = MainPresenterImpl(ExecutorImpl, MainThreadImpl, MessageRepositoryHandler(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    override fun displayWelcomeMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}