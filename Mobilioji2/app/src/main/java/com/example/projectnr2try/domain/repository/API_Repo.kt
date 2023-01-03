package com.example.projectnr2try.domain.repository

import com.example.projectnr2try.domain.model.Responce
import com.example.projectnr2try.data.remote.Result

interface API_Repo {
    suspend fun getApiRecipes(): Responce<List<Result>>
}