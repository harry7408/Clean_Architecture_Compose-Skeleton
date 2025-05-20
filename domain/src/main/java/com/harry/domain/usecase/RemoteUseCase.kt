package com.harry.domain.usecase

import com.harry.domain.model.RemoteModel

interface RemoteUseCase {

    suspend operator fun invoke() : RemoteModel
}