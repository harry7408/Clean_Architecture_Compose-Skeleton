package com.harry.data.datasource

import com.harry.data.model.ExampleLocalModel
import com.harry.data.model.toDomain
import com.harry.domain.model.LocalModel
import javax.inject.Inject

class LocalDataSource @Inject constructor() {

    fun getName(): LocalModel {
        return ExampleLocalModel("ABCD").toDomain()
    }
}