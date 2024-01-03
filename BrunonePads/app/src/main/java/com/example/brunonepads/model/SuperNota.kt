package com.example.brunonepads.model

import androidx.annotation.DrawableRes

data class SuperNota(var notaName: String,
                     @DrawableRes var photo: Int,
                     var soundFilePath: String = "Pad_em_C.mp3"
)