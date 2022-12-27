package com.example.projectnr2try.domain.model.auth


sealed class Resource<out R> {
    data class Success<out R>(val result:R): Resource<R>()
    data class Failure (val expectation: Exception): Resource<Nothing>()
    object Loading: Resource<Nothing>()
}