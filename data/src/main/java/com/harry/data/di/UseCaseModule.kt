package com.harry.data.di

import com.harry.data.usecase.LocalUseCaseImpl
import com.harry.data.usecase.RemoteUseCaseImpl
import com.harry.domain.usecase.LocalUseCase
import com.harry.domain.usecase.RemoteUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindLocalUseCase(localUseCaseImpl: LocalUseCaseImpl) : LocalUseCase


    @Binds
    abstract fun bindRemoteUseCase(remoteUseCaseImpl: RemoteUseCaseImpl) : RemoteUseCase
}