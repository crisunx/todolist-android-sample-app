package br.com.crisun.sample.todo.data.remote

import br.com.crisun.sample.todo.data.remote.model.LoginRequest
import br.com.crisun.sample.todo.data.remote.model.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api {
    @GET("/todos")
    suspend fun todos(): Response<List<String>>

    @POST("/auth/login")
    suspend fun login(@Body body: LoginRequest): Response<TokenResponse>

}
