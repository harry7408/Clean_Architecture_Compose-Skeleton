package com.harry.data.usecase

import com.harry.data.datasource.RemoteDataSource
import com.harry.domain.model.RemoteModel
import com.harry.domain.usecase.RemoteUseCase
import javax.inject.Inject

class RemoteUseCaseImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : RemoteUseCase {
    override suspend fun invoke(): RemoteModel {
        return remoteDataSource.getId()
    }
}