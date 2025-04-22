package cbconnectit.portfolio.web.data.repos

import cbconnectit.portfolio.web.data.models.domain.Experience
import cbconnectit.portfolio.web.data.models.domain.toExperience
import cbconnectit.portfolio.web.data.models.dto.responses.ExperienceDto
import com.varabyte.kobweb.browser.http.http
import kotlinx.browser.window
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

object ExperienceRepo {

    suspend fun getExperiences(baseUrl: String): List<Experience> {
        val responseText = window.http.get("${baseUrl}/api/v1/experiences").decodeToString()
        return Json.decodeFromString<List<ExperienceDto>>(responseText).map { it.toExperience() }
    }
}
