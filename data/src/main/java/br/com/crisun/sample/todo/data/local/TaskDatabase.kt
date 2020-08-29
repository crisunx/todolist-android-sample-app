package br.com.crisun.sample.todo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.crisun.sample.todo.data.local.dao.TaskDao
import br.com.crisun.sample.todo.data.local.model.TaskEntity

@TypeConverters(Converters::class)
@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
