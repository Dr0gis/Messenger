package team.corpore.`in`.messenger.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_registration.*
import team.corpore.`in`.messenger.R
import team.corpore.`in`.messenger.outside.net.NetRepository
import team.corpore.`in`.messenger.presentation.presenters.RegistrationPresenter
import team.corpore.`in`.messenger.presentation.presenters.impl.RegistrationPresenterImpl
import team.corpore.`in`.messenger.presentation.ui.BaseFragment
import team.corpore.`in`.messenger.threading.ExecutorImpl
import team.corpore.`in`.messenger.threading.MainThreadImpl

class RegistrationFragment : BaseFragment(), RegistrationPresenter.View {

    companion object {
        fun newInstance(): RegistrationFragment {
            return RegistrationFragment()
        }
    }

    private val netRepository = NetRepository(disposable)
    private val presenter = RegistrationPresenterImpl(ExecutorImpl, MainThreadImpl, netRepository, this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setOnClicks()
    }

    private fun setOnClicks() {
        registrationButton.setOnClickListener {
            presenter.registration(emailTIL.editText!!.text.toString(), passwordTIL.editText!!.text.toString())
        }
    }

    override fun registrationSuccess() {

    }
}