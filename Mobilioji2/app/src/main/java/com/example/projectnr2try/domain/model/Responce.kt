package com.example.projectnr2try.domain.model

sealed class Responce<out T> {
    object Loading: Responce<Nothing>()

    data class Success<out T>(
        val data: T
    ): Responce<T>()

    data class Failure(
        val e: Exception?
    ): Responce<Nothing>()
}
