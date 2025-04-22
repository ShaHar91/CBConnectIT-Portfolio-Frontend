package cbconnectit.portfolio.web.data.repos

import cbconnectit.portfolio.web.data.models.domain.Testimonial
import cbconnectit.portfolio.web.data.models.domain.toTestimonial
import cbconnectit.portfolio.web.data.models.dto.responses.TestimonialDto
import com.varabyte.kobweb.browser.http.http
import kotlinx.browser.window
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

object TestimonialRepo {

    suspend fun getTestimonials(baseUrl: String): List<Testimonial> {
        val responseText = window.http.get("${baseUrl}/api/v1/testimonials").decodeToString()
        return Json.decodeFromString<List<TestimonialDto>>(responseText).map { it.toTestimonial() }
    }
}
