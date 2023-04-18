package br.senai.sp.jandira.login.repository

import android.content.Context
import br.senai.sp.jandira.login.dao.TripDb
import br.senai.sp.jandira.login.model.User

class UserRepository(context: Context) {

    private val db = TripDb.getDataBase(context)

    fun save(user: User): Long {
        return db.userDao().save(user)
    }

    fun findUserByEmail(email: String): User {
        return  db.userDao().findUserByEmail(email)
    }

    fun authenticate(email: String, password: String): User {
        return db.userDao().authenticate(email, password)
    }
}