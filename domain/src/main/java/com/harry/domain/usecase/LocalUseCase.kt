package com.harry.domain.usecase

import com.harry.domain.model.LocalModel

interface LocalUseCase {

    suspend operator fun invoke() : LocalModel
}