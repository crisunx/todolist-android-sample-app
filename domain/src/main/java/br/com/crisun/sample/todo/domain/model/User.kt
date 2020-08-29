package br.com.crisun.sample.todo.domain.model

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val password: String,
    val roles: List<String>
)
