package cbconnectit.portfolio.web.data.repos

import cbconnectit.portfolio.web.data.models.domain.Project
import cbconnectit.portfolio.web.data.models.domain.toProject
import cbconnectit.portfolio.web.data.models.dto.responses.ProjectDto
import com.varabyte.kobweb.browser.http.http
import kotlinx.browser.window
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

object ProjectRepo {

    suspend fun getProjects(baseUrl: String): List<Project> {
        val responseText = window.http.get("$baseUrl/api/v1/projects").decodeToString()
        return Json.decodeFromString<List<ProjectDto>>(responseText).map { it.toProject() }
    }
}
