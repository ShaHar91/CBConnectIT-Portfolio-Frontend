package com.christiano.bolla.models

import com.christiano.bolla.utils.Res

enum class Section(
    val id: String,
    val title: String,
    val subtitle: String,
    val path: String
) {
    Home("home", Res.String.Home, "", "/#home"),
    About("about", Res.String.AboutMe, Res.String.AboutMeSubtitle, "/#about"),
    Service("service", Res.String.Service, Res.String.ServiceSubtitle, "/#service"),
    Portfolio("portfolio", Res.String.Portfolio, Res.String.PortfolioSubtitle, "/#portfolio"),
    Experience("experience", Res.String.Experience, Res.String.ExperienceSubtitle, "/#experience"),
    Contact("contact", Res.String.ContactMe, Res.String.ContactMeSubtitle, "/#contact"),
    Testimonial("testimonial", Res.String.Testimonial, Res.String.TestimonialsSubtitle, "/#testimonial"),
    Achievements("achievements", Res.String.Achievements, Res.String.AchievementsSubtitle, "/#achievements")
}