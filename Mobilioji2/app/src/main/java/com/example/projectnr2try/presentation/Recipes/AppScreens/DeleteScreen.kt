package com.example.projectnr2try .presentation.Recipes

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.projectnr2try.presentation.Recipes.components.BottomBar
import com.example.projectnr2try.presentation.Recipes.components.Recipes
import com.example.projectnr2try.presentation.Recipes.components.TopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DeleteScreen(
    viewmodel: RecipesViewModel= hiltViewModel(),
    navController: NavController,
    UserviewModel: LoginRegisterViewModel= hiltViewModel(),
) {
    Scaffold(
        bottomBar = { BottomBar(navController) },
        backgroundColor = Color.Black,
        topBar = { TopBar(navController) },
        content = { padding->
              Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            ){
                    Recipes(recipeContent = {recipes ->
                        LazyColumn(modifier= Modifier
                            .fillMaxSize()
                            .padding(padding)
                            .border(5.dp, color = Color.Black)
                        )

                        {
                            items(items=recipes)
                            {
                                    recipe->
                                if(UserviewModel.currentUser?.uid ==recipe.userId) {
                                    Card(
                                        shape = MaterialTheme.shapes.small,
                                        modifier = Modifier
                                            .padding(
                                                bottom = 8.dp
                                            )
                                            .border(3.dp, color = Color.Yellow)
                                            .fillMaxWidth()
                                        .clickable {
                                            viewmodel.DeleteRecipesUseCase(recipe.id) },
                                        elevation = 3.dp,
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(3.dp)
                                                .background(Color.Black),
                                            verticalAlignment = Alignment.CenterVertically,
                                        ) {
                                            Column(modifier = Modifier.padding(20.dp)) {
                                                Text(
                                                    text = recipe.name ?: "",
                                                    color = Color.White,
                                                    fontSize = 20.sp
                                                )
                                                Text(
                                                    text = recipe.catagory ?: "",
                                                    color = Color.White,
                                                    fontSize = 15.sp
                                                )
                                            }
                                            Spacer(
                                                modifier = Modifier.weight(1f)
                                            )

                                        }
                                    }
                                }
                            }
                        }
                    }
                    )
            }
        }

    )


}