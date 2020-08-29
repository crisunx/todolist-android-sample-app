package br.com.crisun.sample.todo.data.di

import androidx.room.Room
import br.com.crisun.sample.todo.data.BuildConfig
import br.com.crisun.sample.todo.data.local.TaskDatabase
import br.com.crisun.sample.todo.data.remote.Api
import br.com.crisun.sample.todo.data.remote.base.DateAdapter
import br.com.crisun.sample.todo.data.repository.LoginRepositoryImpl
import br.com.crisun.sample.todo.domain.repository.TaskRepository
import br.com.crisun.sample.todo.data.repository.TaskRepositoryImpl
import br.com.crisun.sample.todo.domain.repository.LoginRepository
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { provideMoshi() }
    single { provideApi(get()) }
    single { provideOkHttpClient() }
    single { provideRetrofit(get(), get()) }
}

val databaseModule = module {
    single { get<TaskDatabase>().taskDao() }
    single { Room.databaseBuilder(get(), TaskDatabase::class.java, "todo-list.db").build() }
}

val repositoryModule = module {
    factory<TaskRepository> { TaskRepositoryImpl(get()) }
    factory<LoginRepository> { LoginRepositoryImpl(get()) }
}

fun provideMoshi(): Moshi {
    return Moshi.Builder()
        .add(DateAdapter)
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().apply {
        readTimeout(60L, TimeUnit.SECONDS)
        connectTimeout(60L, TimeUnit.SECONDS)
        addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
    }.build()
}

fun provideApi(retrofit: Retrofit): Api {
    return retrofit.create(Api::class.java)
}

fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
    return Retrofit.Builder().apply {
        baseUrl(BuildConfig.SERVER_BASE_URL)
        client(okHttpClient)
        addConverterFactory(MoshiConverterFactory.create(moshi))
    }.build()
}
