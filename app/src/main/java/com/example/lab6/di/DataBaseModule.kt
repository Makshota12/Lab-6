package com.example.lab6.di

import android.content.Context
import com.example.lab6.data.AppDatabase
import com.example.lab6.data.PersonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.create(context)
    }

    @Provides
    fun providePersonDao(database: AppDatabase): PersonDao {
        return database.personDao()
    }
}