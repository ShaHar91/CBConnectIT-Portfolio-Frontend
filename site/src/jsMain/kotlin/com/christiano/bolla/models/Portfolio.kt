package com.christiano.bolla.models

import com.christiano.bolla.utils.Res

enum class Portfolio(
    val image: String,
    val title: String,
    val description: String,
    val link: String
) {
    One(
        image = Res.Image.portfolio1,
        title = "Android Core",
        description = "Android Library",
        link = "https://github.com/wisemen-digital/AndroidCore"
    ),
    Two(
        image = Res.Image.portfolio2,
        title = "Measurements",
        description = "Android Library",
        link = "https://github.com/wisemen-digital/Measurements"
    ),
    Three(
        image = Res.Image.portfolio3,
        title = "Pokédex",
        description = "Android",
        link = "https://github.com/ShaHar91/DemoPokedex"
    ),
    Four(
        image = Res.Image.portfolio4,
        title = "FoodWatcher",
        description = "Android",
        link = "https://github.com/ShaHar91/FoodWatcher-Android"
    ),
    Five(
        image = Res.Image.portfolio5,
        title = "PoemCollection Backend",
        description = "Kotlin",
        link = "https://github.com/ShaHar91/PoemCollection-backend-ktor"
    ),
}