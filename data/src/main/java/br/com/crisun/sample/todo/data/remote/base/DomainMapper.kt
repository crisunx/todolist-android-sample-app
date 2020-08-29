package br.com.crisun.sample.todo.data.remote.base

interface DomainMapper<T : Any> {
    fun mapToDomain(): T
}
