package com.esa.interiordesigndecoration.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Search(modifier: Modifier = Modifier) {
    Surface(
        color = Color(0xFFF4B5A4),
        shape = CircleShape,
            modifier = modifier
                .size(40.dp)
    ) {
        Icon(
            modifier = Modifier
                .padding(5.dp),
            imageVector = Icons.Outlined.Search,
            contentDescription = "search"
        )
    }
}