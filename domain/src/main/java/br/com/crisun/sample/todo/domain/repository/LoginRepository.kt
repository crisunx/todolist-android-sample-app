package br.com.crisun.sample.todo.domain.repository

import br.com.crisun.sample.todo.domain.Result
import br.com.crisun.sample.todo.domain.model.User

interface LoginRepository {
    suspend fun login(username: String, password: String): Result<User>
}
