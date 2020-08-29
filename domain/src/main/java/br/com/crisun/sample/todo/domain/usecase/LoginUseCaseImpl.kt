package br.com.crisun.sample.todo.domain.usecase

import br.com.crisun.sample.todo.domain.Result
import br.com.crisun.sample.todo.domain.model.User
import br.com.crisun.sample.todo.domain.repository.LoginRepository

class LoginUseCaseImpl(private val repository: LoginRepository): LoginUseCase {
    override suspend fun login(username: String, password: String): Result<User> {
        return repository.login(username, password)
    }
}