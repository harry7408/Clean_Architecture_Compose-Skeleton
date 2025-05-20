package com.harry.data.model

import com.harry.domain.model.RemoteModel

data class ExampleRemoteModel(
    val value: Int,
)

// Mapping
fun ExampleRemoteModel.toDomain() : RemoteModel {
    return RemoteModel(
        score = value
    )
}
