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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.projectnr2try.presentation.Recipes.RecipesViewModel
import com.example.projectnr2try.presentation.Recipes.components.BottomBar
import com.example.projectnr2try.presentation.Recipes.components.Recipes
import com.example.projectnr2try.presentation.Recipes.components.TopBar

@Composable
fun RecipeInfoScreen(
    viewmodel: RecipesViewModel = hiltViewModel(),
    navController: NavController,
    ItemId: String?
) {

    Scaffold(
        topBar = { TopBar(navController) },
        bottomBar = { BottomBar(navController) },
        backgroundColor = Color.Black,
    )
    { padding ->  padding
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
                            if(recipe.id==ItemId ) {

                                        Column(
                                            modifier = Modifier
                                                .height(100.dp)
                                                .width(400.dp)
                                                .padding(10.dp)
                                        ) {

                                            Text(
                                                text = recipe.name ?: "",
                                                color = Color.White,
                                                fontSize = 25.sp
                                            )
                                            Text(
                                                text = recipe.catagory ?: "",
                                                color = Color.White,
                                                fontSize = 15.sp
                                            )
                                        }
                                Column(
                                    modifier = Modifier
                                        .height(400.dp)
                                        .width(300.dp)
                                        .padding(10.dp)
                                )
                                {

                                            Spacer(
                                                modifier = Modifier.weight(1f)
                                            )
                                            Text(
                                                text = recipe.ingredients ?: "",
                                                color = Color.White,
                                                fontSize = 20.sp
                                            )
                                            Spacer(
                                                modifier = Modifier.weight(1f)
                                            )

                                }
                                Column(
                                    modifier = Modifier
                                        .height(400.dp)
                                        .width(400.dp)
                                        .padding(10.dp)
                                ){
                                    Text(
                                        text = recipe.steps?: "",
                                        color = Color.White,
                                        fontSize = 20.sp
                                    )
                                    Spacer(
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                                        Spacer(
                                            modifier = Modifier.weight(1f)
                                        )
                            }
                        }
                    }
                }
                )
            }


        }
    }
}