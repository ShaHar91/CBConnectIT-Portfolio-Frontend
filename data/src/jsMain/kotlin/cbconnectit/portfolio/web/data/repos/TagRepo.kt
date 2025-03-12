package cbconnectit.portfolio.web.data.repos

import cbconnectit.portfolio.web.data.models.domain.Tag
import cbconnectit.portfolio.web.data.models.domain.toTag
import cbconnectit.portfolio.web.data.models.dto.responses.TagDto
import com.varabyte.kobweb.browser.http.http
import kotlinx.browser.window
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

object TagRepo {

    suspend fun getTags(baseUrl: String): List<Tag> {
        val responseTagText = window.http.get("${baseUrl}/api/v1/tags").decodeToString()
        return Json.decodeFromString<List<TagDto>>(responseTagText).sortedBy { it.name }.map { it.toTag() }
    }
}