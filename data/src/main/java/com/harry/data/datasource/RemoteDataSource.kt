package com.harry.data.datasource

import com.harry.data.model.ExampleRemoteModel
import com.harry.data.model.toDomain
import com.harry.domain.model.RemoteModel
import javax.inject.Inject

class RemoteDataSource @Inject constructor() {

    fun getId() : RemoteModel {
        return ExampleRemoteModel(1234).toDomain()
    }
}