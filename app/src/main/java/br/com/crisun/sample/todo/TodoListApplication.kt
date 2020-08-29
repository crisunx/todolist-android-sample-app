package br.com.crisun.sample.todo

import android.app.Application
import br.com.crisun.sample.todo.data.di.databaseModule
import br.com.crisun.sample.todo.data.di.networkModule
import br.com.crisun.sample.todo.data.di.repositoryModule
import br.com.crisun.sample.todo.di.appModule
import br.com.crisun.sample.todo.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TodoListApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TodoListApplication)
            modules(
                listOf(
                    appModule,
                    domainModule,
                    networkModule,
                    databaseModule,
                    repositoryModule
                )
            )
        }
    }
}