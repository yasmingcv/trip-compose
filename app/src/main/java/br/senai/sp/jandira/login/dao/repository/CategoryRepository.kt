package br.senai.sp.jandira.login.dao.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.login.R
import br.senai.sp.jandira.login.model.Category

class CategoryRepository {
    companion object {

        @Composable
        fun getCategoriesList(): List<Category>{

            return listOf<Category>(
                Category(
                    id = 1,
                    name = "Mountain",
                    image = painterResource(id = R.drawable.mountain)
                ),
                Category(
                    id = 2,
                    name = "Mountain",
                    image = painterResource(id = R.drawable.snow)
                ),
                Category(
                    id = 3,
                    name = "Mountain",
                    image = painterResource(id = R.drawable.beach)
                )

            )
        }

    }
}