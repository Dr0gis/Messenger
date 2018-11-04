package team.corpore.`in`.messenger.domain.repository

interface RegistrationRepository {
    fun registration(username: String, password: String) : Boolean
}