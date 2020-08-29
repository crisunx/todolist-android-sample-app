package br.com.crisun.sample.todo.ui.login

sealed class ViewState<out T : Any>
class Loading<out T : Any> : ViewState<T>()
class Success<out T : Any>(val data: T) : ViewState<T>()
class Failure<out T : Any>(val error: Throwable) : ViewState<T>()
