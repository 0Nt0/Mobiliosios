@file:OptIn(ExperimentalPagerApi::class)

package com.example.projectnr2try.presentation.Recipes.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projectnr2try.R
import com.example.projectnr2try.presentation.Recipes.RecipeAddScreen
import com.google.accompanist.pager.ExperimentalPagerApi

//BottomNavigation(backgroundColor = Color.Black,
//modifier = Modifier
//.height(76.dp)
//.padding(15.dp)){
//    BottomNavigationItem(
//        Icon(imageVector = Icons.Outlined.Home,
//            contentDescription = "Home",
//            modifier=Modifier.size(90.dp),
//            tint =Color.Yellow,
//        )
//
//    ){
//
//    }
@Composable
fun BottomBar(navController: NavController) {
    BottomAppBar(backgroundColor = Color.Black,
                 modifier = Modifier
                     .height(76.dp)
                     .padding(15.dp)
                 ){
        IconButton(onClick = { navController.navigate("MainScreen") }) {
              Icon(imageVector = Icons.Outlined.Home,
                   contentDescription = "Home",
                   modifier=Modifier.size(90.dp),
                   tint =Color.Yellow,

                    )
            }
        IconButton(onClick = { navController.navigate("AddScreen") }) {
            Icon(imageVector = Icons.Outlined.Add,
                contentDescription = "Add",
                modifier=Modifier.size(90.dp),
                tint =Color.Yellow)
        }
        IconButton(onClick = { navController.navigate("DeleteScreen") }) {
            Icon(imageVector = Icons.Outlined.Delete,
                contentDescription = "Delete",
                modifier=Modifier.size(90.dp),
                tint =Color.Yellow)
        }
        IconButton(onClick = { navController.navigate("ProfileScreen") }) {
            Icon(imageVector = Icons.Outlined.Person,
                contentDescription = "Profile",
                modifier=Modifier.size(90.dp),
                tint =Color.Yellow)
        }

    }
}