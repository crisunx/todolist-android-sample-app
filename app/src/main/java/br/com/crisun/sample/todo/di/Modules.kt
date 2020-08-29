package br.com.crisun.sample.todo.di

import br.com.crisun.sample.todo.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { LoginViewModel(get()) }
}
