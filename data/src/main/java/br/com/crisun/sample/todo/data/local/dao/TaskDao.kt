package br.com.crisun.sample.todo.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import br.com.crisun.sample.todo.data.local.model.TaskEntity

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    suspend fun select(): List<TaskEntity>
}
