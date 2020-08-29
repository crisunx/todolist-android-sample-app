package br.com.crisun.sample.todo.domain.usecase

import br.com.crisun.sample.todo.domain.Result
import br.com.crisun.sample.todo.domain.model.User

interface LoginUseCase {
    suspend fun login(username: String, password: String): Result<User>
}
