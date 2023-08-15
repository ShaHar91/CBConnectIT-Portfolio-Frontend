package com.christiano.bolla.models

import com.christiano.bolla.utils.Res

enum class Achievement(
    val icon: String,
    val number: Int,
    val description: String
) {
    Completed(
        icon = Res.Icon.checkmark,
        number = 15,
        description = "Completed Projects"
    ),
    Active(
        icon = Res.Icon.shield,
        number = 2,
        description = "Active Projects"
    ),
    Satisfied(
        icon = Res.Icon.happy,
        number = 2,
        description = "Satisfied Clients"
    )
}