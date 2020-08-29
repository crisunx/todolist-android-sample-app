package br.com.crisun.sample.todo.data.remote.model

import br.com.crisun.sample.todo.data.remote.base.DomainMapper
import br.com.crisun.sample.todo.domain.model.Token

data class TokenResponse(val token: String) : DomainMapper<Token> {
    override fun mapToDomain() = Token(
        token = token
    )
}
