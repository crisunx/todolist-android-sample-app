package br.com.crisun.sample.todo.data.repository

import br.com.crisun.sample.todo.data.remote.Api
import br.com.crisun.sample.todo.data.remote.model.LoginRequest
import br.com.crisun.sample.todo.domain.Result
import br.com.crisun.sample.todo.domain.model.User
import br.com.crisun.sample.todo.domain.repository.LoginRepository

class LoginRepositoryImpl(private val api: Api): LoginRepository {
    override suspend fun login(username: String, password: String): Result<User> {
        api.login(LoginRequest(username, password))
    }
}