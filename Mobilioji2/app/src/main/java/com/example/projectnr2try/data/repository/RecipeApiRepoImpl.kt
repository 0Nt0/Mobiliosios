package com.example.projectnr2try.data.repository

import com.example.projectnr2try.data.remote.RecipeAPI
import com.example.projectnr2try.data.remote.RecipeAPIInfo
import com.example.projectnr2try.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class RecipeApiRepoImpl @Inject constructor(
    private val api: RecipeAPI
)
{
    suspend fun  GetRecipeList(): Resource<RecipeAPIInfo> {
        val responce =try{
            api.GetAllRecipes()
        }catch (e:Exception)
        {
            return  Resource.Error("smth happaned")
        }
        return Resource.Success(responce) }


}