package cbconnectit.portfolio.web.data.repos

import cbconnectit.portfolio.web.data.models.domain.Service
import cbconnectit.portfolio.web.data.models.domain.Tag
import cbconnectit.portfolio.web.data.models.domain.toService
import cbconnectit.portfolio.web.data.models.dto.responses.ServiceDto
import com.varabyte.kobweb.compose.http.http
import kotlinx.browser.window
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

object ServiceRepo {

    suspend fun getServices(baseUrl: String): List<Service> {
        val responseServicesText = window.http.get("${baseUrl}/api/v1/services").decodeToString()
        return Json.decodeFromString<List<ServiceDto>>(responseServicesText).map { it.toService() }
    }

    suspend fun getServiceById(baseUrl: String, id: String): Service? {
        val responseServiceText = window.http.get("${baseUrl}/api/v1/services/$id").decodeToString()
        return Json.decodeFromString<ServiceDto?>(responseServiceText)?.toService()
    }
}