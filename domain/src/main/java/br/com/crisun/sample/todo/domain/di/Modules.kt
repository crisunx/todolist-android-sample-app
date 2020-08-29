package br.com.crisun.sample.todo.domain.di

import br.com.crisun.sample.todo.domain.usecase.LoginUseCase
import br.com.crisun.sample.todo.domain.usecase.LoginUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<LoginUseCase> { LoginUseCaseImpl(get()) }
}
