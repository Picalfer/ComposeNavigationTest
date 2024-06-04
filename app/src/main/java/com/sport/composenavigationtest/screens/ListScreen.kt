package com.sport.composenavigationtest.screens

import android.os.Parcelable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.parcelize.Parcelize

@Parcelize
data class Word(
    val value: String
) : Parcelable

@Composable
fun ListScreen(
    onItemClick: (String) -> Unit
) {
    val testList = listOf(
        Word("John"),
        Word("David"),
        Word("Symon"),
        Word("John"),
        Word("David"),
        Word("Manman"),
        Word("Symon"),
        Word("Manman"),
        Word("John"),
        Word("David"),
        Word("Symon"),
        Word("Manman"),
        Word("John"),
        Word("David"),
        Word("Symon"),
        Word("Manman"),
    )

    LazyColumn(modifier = Modifier.padding(5.dp)) {
        testList.map {
            item {
                Text(
                    text = it.value,
                    modifier = Modifier
                        .background(Color.Green)
                        .fillMaxWidth()
                        .padding(24.dp)
                        .clickable {
                            onItemClick(it.value)
                        },
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}