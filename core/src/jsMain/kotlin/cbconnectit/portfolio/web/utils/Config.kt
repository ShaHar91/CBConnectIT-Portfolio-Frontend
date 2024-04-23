package cbconnectit.portfolio.web.utils

object Config {

    var baseUrl: String = ""
        private set

    fun init(baseUrl: String?) {
        Config.baseUrl = baseUrl ?: ""
    }
}