package br.senai.sp.jandira.login.model

import androidx.compose.ui.graphics.painter.Painter

data class Category (
    var id: Int = 0,
    var image: Painter? = null,
    var name: String = ""
        ){}