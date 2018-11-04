package team.corpore.`in`.messenger.presentation.ui.activities

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_in.*
import team.corpore.`in`.messenger.R
import team.corpore.`in`.messenger.presentation.ui.BaseActivity
import team.corpore.`in`.messenger.presentation.ui.BaseFragment
import team.corpore.`in`.messenger.presentation.ui.fragments.LoginFragment
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import team.corpore.`in`.messenger.presentation.ui.fragments.RegistrationFragment

class SignInActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        setupToolbar()
        setupViewPager()
    }

    private fun setupToolbar() {
        toolbar.title = getString(R.string.sign_in)
    }

    private fun setupViewPager() {
        val adapter = FragmentPagerItemAdapter(
            supportFragmentManager, FragmentPagerItems.with(this)
                .add(R.string.login, LoginFragment::class.java)
                .add(R.string.registration, RegistrationFragment::class.java)
                .create()
        )

        viewPager.adapter = adapter
        viewPagerTab.setViewPager(viewPager)
    }
}