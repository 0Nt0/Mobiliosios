package com.example.projectnr2try.presentation.Recipes

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.projectnr2try.presentation.Recipes.components.BottomBar
import com.example.projectnr2try.presentation.Recipes.components.TopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RecipeAddScreen(
   // viewmodel: AddScreenViewModel= hiltViewModel(),
    navController: NavController
) {
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

            )
        {
            LazyColumn(state = rememberLazyListState())
            {item(){
                        Column(modifier = Modifier
                            .height(250.dp)
                            .width(200.dp)
                            .padding(10.dp)
                            .border(3.dp, Color.White)) {
                        }
                    }

            }
        }
    }

}