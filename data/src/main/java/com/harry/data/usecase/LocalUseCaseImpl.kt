package com.harry.data.usecase

import com.harry.data.datasource.LocalDataSource
import com.harry.domain.model.LocalModel
import com.harry.domain.usecase.LocalUseCase
import javax.inject.Inject

class LocalUseCaseImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : LocalUseCase {

    override suspend fun invoke(): LocalModel {
        return localDataSource.getName()
    }
}