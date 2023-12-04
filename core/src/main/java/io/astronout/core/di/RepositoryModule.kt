package io.astronout.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.astronout.core.data.source.local.LocalDataSource
import io.astronout.core.data.source.local.LocalDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource
//
//    @Binds
//    @Singleton
//    abstract fun bindRepository(gamesDataStore: GamesDataStore): GamesRepository
//
//    @Binds
//    @Singleton
//    abstract fun bindGameUsecase(gameInteractor: GameInteractor): GameUsecase

}