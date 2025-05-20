package com.harry.data.model

import com.harry.domain.model.LocalModel

data class ExampleLocalModel(
    val value: String,
)

// Mapping
fun ExampleLocalModel.toDomain(): LocalModel {
    return LocalModel(
        name = value
    )
}
