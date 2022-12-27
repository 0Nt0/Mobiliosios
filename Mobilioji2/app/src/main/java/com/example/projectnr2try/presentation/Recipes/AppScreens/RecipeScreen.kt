package com.example.projectnr2try.presentation.Recipes

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.projectnr2try.presentation.Recipes.components.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RecipeScreen(
    viewmodel: RecipesViewModel= hiltViewModel(),
    navController: NavController
)
{
    Scaffold(
        bottomBar = { BottomBar(navController) },
        backgroundColor = Color.Black,
        topBar = { TopBar() }
    )
    {
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
                            Column(modifier = Modifier
                                .height(160.dp)
                                .width(160.dp)
                                .padding(10.dp)
                                .border(3.dp, Color.White)) {
                                Text(text = "$item",
                                    color=Color.White,
                                    fontSize = 25.sp,
                                    modifier = Modifier.padding(25.dp,45.dp),
                                )
                            }
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


            }
        }

    }
   /* Account()
    AddNewRecipe()
    DeleteARecipe()*/

}