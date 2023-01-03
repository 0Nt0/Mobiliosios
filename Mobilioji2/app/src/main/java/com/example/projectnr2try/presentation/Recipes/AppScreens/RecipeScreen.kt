package com.example.projectnr2try.presentation.Recipes

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.projectnr2try.R
import com.example.projectnr2try.presentation.Recipes.AppScreens.Screens
import com.example.projectnr2try.presentation.Recipes.components.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RecipeScreen(
    viewmodel: RecipesViewModel= hiltViewModel(),
    navController: NavController
)
{
    val Catagories= stringArrayResource(id = R.array.Dishes)
    Scaffold(
        bottomBar = { BottomBar(navController) },
        backgroundColor = Color.Black,
        content = {
            padding->
            Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            ){
            LazyColumn(state = rememberLazyListState())
            {
                item(){
                    LazyRow(state= rememberLazyListState())
                    {
                        items(AllFoods()){item ->
                            for (catag in Catagories)
                            {if("$item"==catag) {
                                Row(modifier = Modifier
                                    .height(170.dp)
                                    .width(170.dp)
                                    .padding(10.dp)
                                    .border(3.dp, Color.White)
                                    .clickable {
                                        navController.navigate(Screens.RecipeCatagoryScreen.route + "/${item}")
                                    }
                                ) {


                                    Text(
                                        //text = "${item.ch}",
                                        text = catag,
                                        color = Color.White,
                                        fontSize = 25.sp,
                                        modifier = Modifier.padding(25.dp, 45.dp),
                                    )


                                }

                            }}


                        }
                    }
                }
            }
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
                                         modifier = Modifier
                                             .fillMaxWidth()
                                             .padding(3.dp)
                                             .background(Color.Black),
                                         verticalAlignment = Alignment.CenterVertically,
                                     ) {
                                         Column (modifier = Modifier.padding(20.dp)){
                                             Text(
                                                 text = recipe.name?: "",
                                                 color = Color.White,
                                                 fontSize = 20.sp
                                             )
                                             Text(
                                                 text = recipe.catagory?: "",
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
                        )
            }
        }
        },
        topBar = { TopBar(navController) },
    )
    }
   /* Account()
    AddNewRecipe()
    DeleteARecipe()*/


