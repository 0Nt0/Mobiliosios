package com.example.projectnr2try.di


import com.example.projectnr2try.core.Constant.Recipe
import com.example.projectnr2try.data.repository.AuthenticationRepoImpl
import com.example.projectnr2try.data.repository.RecipeRepositoryImpl
import com.example.projectnr2try.domain.repository.AuthenticationRepo
import com.example.projectnr2try.domain.repository.RecipeRepository
import com.example.projectnr2try.domain.use_case.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesFirestore()= Firebase.firestore

    @Provides
    @Singleton
    fun RecipeReferance(
        data: FirebaseFirestore
    ) = data.collection(Recipe)

    @Provides
    @Singleton
    fun RecipeRepository(
        RecipesRef: CollectionReference
    ): RecipeRepository = RecipeRepositoryImpl(RecipesRef)

    @Provides
    @Singleton
    fun UseCases(
        repository: RecipeRepository
    ) : RecipeUseCases{
        return RecipeUseCases( GetRecipesUseCase= GetRecipes(repository),
            DeleteRecipesUseCase= DeleteRecipes(repository),
            EditRecipesUseCase= EditRecipe(repository),
            AddRecipeUseCase= AddRecipe(repository))
    }
    @Provides
    fun firebaseAuthoprovide():FirebaseAuth= FirebaseAuth.getInstance()

    @Provides
    fun firebaseAuthRepoProvide(impl: AuthenticationRepoImpl): AuthenticationRepo=impl



}