package com.imasha.infotap.presentation.onboarding

import androidx.annotation.DrawableRes
import com.imasha.infotap.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.ic_logo
    ),
    Page(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.ic_logo
    ),
    Page(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.ic_logo
    )
)