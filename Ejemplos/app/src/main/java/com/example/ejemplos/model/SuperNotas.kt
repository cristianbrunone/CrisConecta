package com.example.ejemplos.model

import androidx.annotation.DrawableRes

data class SuperNotas(
    var superNotasName: String,
    var realName: String,
    var publisher: String,
    @DrawableRes var photo: Int
)
