package com.example.projectnr2try.data.repository

import com.example.projectnr2try.domain.model.auth.Resource
import com.example.projectnr2try.domain.repository.AuthenticationRepo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthenticationRepoImpl @Inject constructor(
    private val firebaseAuth:FirebaseAuth
) : AuthenticationRepo {
    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun Login(email: String, password: String): Resource<FirebaseUser> {
       return try {
           val res= firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Resource.Success(res.user!!)
        }catch (e:Exception)
        {
            Resource.Failure(e)
        }

    }

    override suspend fun Register(
        email: String,
        password: String,
        username: String
    ): Resource<FirebaseUser> {
        return try {
            val res= firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            res?.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(username).build())?.await()
            Resource.Success(res.user!!)
        }catch (e:Exception)
        {
            Resource.Failure(e)
        }
    }

    override fun LogOut() {
        firebaseAuth.signOut()
    }
}