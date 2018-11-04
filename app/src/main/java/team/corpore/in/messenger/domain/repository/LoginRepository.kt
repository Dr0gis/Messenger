package team.corpore.`in`.messenger.domain.repository

interface LoginRepository {
    fun login(username: String, password: String) : Boolean
}