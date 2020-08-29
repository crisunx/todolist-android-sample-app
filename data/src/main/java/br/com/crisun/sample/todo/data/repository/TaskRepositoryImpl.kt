package br.com.crisun.sample.todo.data.repository

import br.com.crisun.sample.todo.data.remote.Api
import br.com.crisun.sample.todo.domain.repository.TaskRepository

class TaskRepositoryImpl(private val api: Api): TaskRepository