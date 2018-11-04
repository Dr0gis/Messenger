package team.corpore.`in`.messenger.outside.net

import io.reactivex.Observable
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("/oauth/token")
    fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): Observable<Boolean>

    @POST("/oauth/registration")
    fun registration(
        @Query("username") username: String,
        @Query("password") password: String
    ): Observable<Boolean>

}