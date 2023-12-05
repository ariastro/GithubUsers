package io.astronout.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.astronout.core.data.source.local.room.GithubDatabase
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    @Singleton
    fun provideGithubDatabase(@ApplicationContext context: Context): GithubDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("astronout".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context.applicationContext,
            GithubDatabase::class.java,
            "github_database"
        ).fallbackToDestructiveMigration()
//            .openHelperFactory(factory)
            .build()
    }
}