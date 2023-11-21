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
        imageDesc = "Mobile Development Icon",
        title = "Mobile Development",
        description = "Whether it's a new app or optimizing an existing one, I offer Mobile development expertise. Let's collaborate to make your mobile application a success in the Google Play or App Store."
    ),
    Tutoring(
        icon = Res.Image.tutoring,
        imageDesc = "Tutoring Icon",
        title = "Tutoring",
        description = "Looking to bring your (or your peer’s) skills to the next level, or just need someone to look into a bug/error? Let’s work together to maximize your potential and achieve your aspirations."
    ),
//    Teamwork(
//        icon = Res.Image.teamwork,
//        imageDesc = "Teamwork Icon",
//        title = "Teamwork",
//        description = Constants.LOREM_IPSUM_SHORTEST
//    ),
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