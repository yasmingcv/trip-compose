package br.senai.sp.jandira.login.dao

import androidx.room.*
import br.senai.sp.jandira.login.model.User

@Dao
interface UserDao {

    @Insert
    fun save(user: User): Long //retorna o id

    @Update
    fun update(user: User): Int // retorna quantos usuários foram atualizados

    @Delete
    fun delete(user: User): Int // retorna quantos usuários foram deletados

    @Query("SELECT * FROM tbl_user WHERE email = :email")
    fun findUserByEmail(email: String): User // retorna o usuário encontrado

}