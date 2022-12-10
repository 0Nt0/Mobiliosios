package com.example.projectnr2try.presentation.Recipes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.projectnr2try.presentation.Recipes.components.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RecipeScreen(
    viwmodel: RecipesViewModel= hiltViewModel()
)
{
    Scaffold(
        bottomBar = { BottomBar() },
        backgroundColor = Color.Black,
        topBar = { TopBar() }
    )
    {
        Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    text = "Your note",
                    color= Color.White,
                    style = MaterialTheme.typography.h4
                )

            }
        }

    }
    Account()
    AddNewRecipe()
    DeleteARecipe()

}