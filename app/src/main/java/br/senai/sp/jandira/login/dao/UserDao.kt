package br.senai.sp.jandira.login.dao

import androidx.room.*
import br.senai.sp.jandira.login.model.User

@Dao
interface UserDao {

    @Insert
    fun save(user: User): Long //return the id

    @Update
    fun update(user: User): Int // return how much users were updated

    @Delete
    fun delete(user: User): Int // return how much users were found

    @Query("SELECT * FROM tbl_user WHERE email = :email")
    fun findUserByEmail(email: String): User // return the user found

    @Query("SELECT * FROM tbl_user WHERE email = :email AND password = :password")
    fun authenticate(email: String, password: String): User // return the user found
}