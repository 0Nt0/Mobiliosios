package com.example.projectnr2try.domain.use_case.APIUse_case

import com.example.projectnr2try.domain.model.Responce
import com.example.projectnr2try.domain.repository.API_Repo
import javax.inject.Inject
import com.example.projectnr2try.data.remote.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException


class API_Get_Use_Case @Inject constructor(
    private val repo: API_Repo
) {
    operator fun invoke(): Flow<Responce<List<Result>>> = flow{
        while(true){
            try {
                val recipes=repo.getApiRecipes()
                emit(recipes)
            }
            catch (e: IOException)
            {
                emit(Responce.Failure(e))
            }
        }
    }


}