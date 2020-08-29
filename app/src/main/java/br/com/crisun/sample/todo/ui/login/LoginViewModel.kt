package br.com.crisun.sample.todo.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.crisun.sample.todo.domain.model.User
import br.com.crisun.sample.todo.domain.usecase.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {
    private val _state = MutableLiveData<ViewState<User>>()

    val state: LiveData<ViewState<User>>
        get() = _state

    fun login(username: String, password: String) {
        viewModelScope.launch {
            loginUseCase.login(username, password)
        }
    }
}