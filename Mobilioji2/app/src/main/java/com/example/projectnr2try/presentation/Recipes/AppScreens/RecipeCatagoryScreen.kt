package com.example.projectnr2try.presentation.Recipes.AppScreens

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
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectnr2try.presentation.Recipes.components.BottomBar
import com.example.projectnr2try.presentation.Recipes.components.Recipes
import com.example.projectnr2try.presentation.Recipes.components.TopBar

@Composable
fun RecipeCatagoryScreen(
    //viewmodel: LoginRegisterViewModel = hiltViewModel(),
    navController: NavController,
    ItemId: String?
) {
    Scaffold(
        topBar = { TopBar(navController)},
        bottomBar = { BottomBar(navController) },
        backgroundColor = Color.Black,
        )
    {
       padding ->  padding
        Column(modifier = Modifier.padding(15.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            )
            {
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
                            if(recipe.catagory==ItemId || recipe.name==ItemId) {
                                Card(
                                    shape = MaterialTheme.shapes.small,
                                    modifier = Modifier
                                        .padding(
                                            bottom = 8.dp
                                        )
                                        .border(3.dp, color = Color.Yellow)
                                        .fillMaxWidth()
                                        .clickable { navController.navigate(Screens.RecipeInfoScreen.route + "/${recipe.id}") },


                                    elevation = 3.dp,
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth()
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
    }

}
