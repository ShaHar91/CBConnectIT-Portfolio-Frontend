package com.christiano.bolla.models

import com.christiano.bolla.utils.Constants
import com.christiano.bolla.utils.Res

enum class Service(
    val icon: String,
    val imageDesc: String,
    val title: String,
    val description: String
) {
    Android(
        icon = Res.Image.android,
        imageDesc = "Android Icon",
        title = "Android Development",
        description = Constants.LOREM_IPSUM_SHORTEST
    ),
    Tutoring(
        icon = Res.Image.tutoring,
        imageDesc = "Tutoring Icon",
        title = "Tutoring",
        description = Constants.LOREM_IPSUM_SHORTEST
    ),
    Teamwork(
        icon = Res.Image.teamwork,
        imageDesc = "Teamwork Icon",
        title = "Teamwork",
        description = Constants.LOREM_IPSUM_SHORTEST
    ),
//    IOS(
//        icon = Res.Icon.ios,
//        imageDesc = "Apple Icon",
//        title = "iOS Development",
//        description = Constants.LOREM_IPSUM_SHORTEST
//    ),
//    Web(
//        icon = Res.Icon.web,
//        imageDesc = "Desktop Icon",
//        title = "Web Development",
//        description = Constants.LOREM_IPSUM_SHORTEST
//    ),
//    Design(
//        icon = Res.Icon.design,
//        imageDesc = "Pen Icon",
//        title = "UX/UI Design",
//        description = Constants.LOREM_IPSUM_SHORTEST
//    ),
//    Business(
//        icon = Res.Icon.business,
//        imageDesc = "Chart Icon",
//        title = "Business Analysis",
//        description = Constants.LOREM_IPSUM_SHORTEST
//    ),
//    SEO(
//        icon = Res.Icon.seo,
//        imageDesc = "Megaphone Icon",
//        title = "SEO Marketing",
//        description = Constants.LOREM_IPSUM_SHORTEST
//    ),
}