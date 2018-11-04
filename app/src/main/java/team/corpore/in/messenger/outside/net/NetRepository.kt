package team.corpore.`in`.messenger.outside.net

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import team.corpore.`in`.messenger.domain.repository.LoginRepository
import team.corpore.`in`.messenger.domain.repository.RegistrationRepository

class NetRepository(private val disposable: CompositeDisposable) :
    LoginRepository,
    RegistrationRepository {

    override fun login(username: String, password: String): Boolean {
        var result = false

        disposable.add(
            RetrofitHolder.getApiService().login(username, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    result = it
                }, {
                    it.printStackTrace()
                })
        )

        return result
    }

    override fun registration(username: String, password: String): Boolean {
        var result = false

        disposable.add(
            RetrofitHolder.getApiService().login(username, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    result = it
                }, {
                    it.printStackTrace()
                })
        )
        return result
    }

}