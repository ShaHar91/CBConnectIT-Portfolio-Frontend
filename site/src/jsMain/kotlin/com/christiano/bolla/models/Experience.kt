package com.christiano.bolla.models

import com.christiano.bolla.utils.Constants

enum class Experience(
    val number: String,
    val jobPosition: String,
    val description: String,
    val company: String,
    val from: String,
    val to: String
) {
    First(
        number = "01",
        jobPosition = "Kotlin Multi-Platform Developer",
        description = Constants.LOREM_IPSUM_SHORT,
        company = "Google",
        from = "February 2022",
        to = "NOW"
    ),
    Second(
        number = "02",
        jobPosition = "Mobile Developer",
        description = Constants.LOREM_IPSUM_SHORT,
        company = "Facebook",
        from = "January 2021",
        to = "October 2021"
    ),
    Third(
        number = "03",
        jobPosition = "Freelancer",
        description = Constants.LOREM_IPSUM_SHORT,
        company = "Netflix",
        from = "March 2020",
        to = "December 2020"
    )
}