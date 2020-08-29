package br.com.crisun.sample.todo.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.com.crisun.sample.todo.R
import br.com.crisun.sample.todo.domain.model.User
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel.state.observe(this, Observer { handleState(it) })

        login_button.setOnClickListener {
            viewModel.login(username_text.text.toString(), password_text.text.toString())
        }
    }

    private fun handleState(state: ViewState<User>) {
        when (state) {
            is Loading -> print("----------------progress.showLoading()")
            is Success -> print("----------------handleSuccess(viewState.data)")
            is Failure -> print("----------------handleError(viewState.error)")
        }
    }
}
