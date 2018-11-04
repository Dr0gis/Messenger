package team.corpore.`in`.messenger.outside

import team.corpore.`in`.messenger.domain.repository.MessageRepository

class MessageRepositoryHandler : MessageRepository {

    override fun getWelcomeMessage(): String {

        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        return "Hello World!!!"
    }

}