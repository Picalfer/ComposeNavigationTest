package com.sport.composenavigationtest.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun DetailsScreen(
    word: String,
    age: Int,
    onClick: () -> Unit
) {
    Toast.makeText(LocalContext.current, "hello", Toast.LENGTH_SHORT).show()
    Log.d("MAN", word)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "List Screen -> $word, $age", modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .clickable {
                    onClick()
                }
                .padding(24.dp),
            color = Color.Black
        )
    }
}