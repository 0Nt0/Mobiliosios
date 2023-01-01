package com.example.projectnr2try.data.repository



import android.net.Uri
import com.example.projectnr2try.core.Constant.name
import com.example.projectnr2try.domain.model.Recipe
import com.example.projectnr2try.domain.model.Responce
import com.example.projectnr2try.domain.repository.AddRecipesResponce
import com.example.projectnr2try.domain.repository.ChangeRecipeResponce
import com.example.projectnr2try.domain.repository.DeleteRecipeResponce
import com.example.projectnr2try.domain.repository.RecipeRepository
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class RecipeRepositoryImpl (
    private val recipeRef: CollectionReference,
        ): RecipeRepository {
    override fun GetRecipesFromFirestore()= callbackFlow {
        val snapshotListener= recipeRef.orderBy(name).addSnapshotListener{snapshot, e->
            val recipesResponce= if(snapshot!= null){
                val recipes= snapshot.toObjects(Recipe::class.java)
                Responce.Success(recipes)
            }
            else{
                Responce.Failure(e)
            }
            trySend(recipesResponce)
        }
        awaitClose{snapshotListener.remove()}

    }

    override suspend fun AddRecipeToFirestore(
        userId: String,
        name: String,
        catagory: String,
        steps: String,
        ingredients: String
    ): AddRecipesResponce {
        try {
            val RecId =recipeRef.document().id

            val recipe= Recipe(
                id = RecId,
                userId =userId,
                name = name,
                catagory = catagory,
                steps = steps,
                ingredients = ingredients
            )
            recipeRef.document(RecId).set(recipe).await()
          return  Responce.Success(true)
        }
        catch (e:Exception)
        {
            return Responce.Failure(e)
        }
    }


    override suspend fun DeleteRecipeFromFirestore(id: Int): DeleteRecipeResponce {
        try {
            recipeRef.document(id.toString()).delete().await()
            return Responce.Success(true)
        }
        catch (e: Exception)
        {
            return Responce.Failure(e)
        }
    }

    override suspend fun ChangeRecipeInFirestore(
        id: Int,
        name: String,
        catagory: String,
        steps: String,
        ingredients: String
    ): ChangeRecipeResponce {

        try{
            if(id== recipeRef.document().id.toInt())
            { val recipeUpdate=Recipe(
                name = name,
                catagory = catagory,
                steps = steps,
                ingredients = ingredients
            )
                recipeRef.document(id.toString()).set(recipeUpdate).await()
            }
            return Responce.Success(true)
        }
        catch (e:Exception)
        {
            return Responce.Failure(e)
        }
    }
}