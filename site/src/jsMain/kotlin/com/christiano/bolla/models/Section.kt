package com.christiano.bolla.models

enum class Section(
    val id: String,
    val title: String,
    val subtitle: String,
    val path: String
) {
    Home("home", "Home", "", "#home"),
    About("about", "About me", "Why Hire Me?", "#about"),
    Service("service", "Service", "I'm Good at", "#service"),
    Portfolio("portfolio", "Portfolio", "My Work", "#portfolio"),
    Experience("experience", "Experience", "Work Experience", "#experience"),
    Contact("contact", "Contact me", "Get In Touch", "#contact"),
    Testimonial("testimonial", "Testimonial", "What they say", "#testimonial"),
    Achievements("achievements", "Achievements", "Personal Achievements", "#achievements")
}