package team.corpore.`in`.messenger.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_login.*
import team.corpore.`in`.messenger.R
import team.corpore.`in`.messenger.outside.net.NetRepository
import team.corpore.`in`.messenger.presentation.presenters.LoginPresenter
import team.corpore.`in`.messenger.presentation.presenters.impl.LoginPresenterImpl
import team.corpore.`in`.messenger.presentation.ui.BaseFragment
import team.corpore.`in`.messenger.threading.ExecutorImpl
import team.corpore.`in`.messenger.threading.MainThreadImpl

class LoginFragment : BaseFragment(), LoginPresenter.View {
    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

    private val netRepository = NetRepository(disposable)
    private val presenter = LoginPresenterImpl(ExecutorImpl, MainThreadImpl, netRepository, this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setOnClicks()
    }

    private fun setOnClicks() {
        loginButton.setOnClickListener {
            presenter.login(emailTIL.editText!!.text.toString(), passwordTIL.editText!!.text.toString())
        }
    }

    override fun loginSuccess() {

    }
}