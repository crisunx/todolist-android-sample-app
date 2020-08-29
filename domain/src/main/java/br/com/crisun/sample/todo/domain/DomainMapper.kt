package br.com.crisun.sample.todo.domain

interface DomainMapper<T : Any> {
    fun mapToDomain(): T
}
