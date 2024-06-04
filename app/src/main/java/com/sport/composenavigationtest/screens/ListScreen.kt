package com.sport.composenavigationtest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sport.composenavigationtest.DetailsScreen

@Composable
fun ListScreen(
    onItemClick: (DetailsScreen) -> Unit
) {
    val testList = listOf(
        DetailsScreen("John", 7),
        DetailsScreen("David", 5),
        DetailsScreen("Symon", 2),
        DetailsScreen("John", 2),
        DetailsScreen("David", 73),
        DetailsScreen("Manman", 45),
        DetailsScreen("Symon", 12),
        DetailsScreen("Manman", 65),
        DetailsScreen("John", 23),
        DetailsScreen("David", 56),
        DetailsScreen("Symon", 67),
        DetailsScreen("Manman", 22),
        DetailsScreen("John", 12),
        DetailsScreen("David", 23),
        DetailsScreen("Symon", 37),
        DetailsScreen("Manman", 71),
    )

    LazyColumn(modifier = Modifier.padding(5.dp)) {
        testList.map {
            item {
                Row(
                    modifier = Modifier
                        .background(Color.Green)
                        .fillMaxWidth()
                        .padding(24.dp)
                        .clickable {
                            onItemClick(it)
                        },
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = it.name ?: "",
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = it.age.toString(),
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}