package com.esa.interiordesigndecoration.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.esa.interiordesigndecoration.data.viewmodel.CategoryViewModel

@Composable
fun Category(
    modifier: Modifier = Modifier,
    onCategorySelected: (String) -> Unit = {},
    viewModel: CategoryViewModel = viewModel()
) {
    val category = viewModel.category.collectAsState()
    val categoryList = category.value
    var selected by remember { mutableStateOf("") }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        LaunchedEffect(categoryList) {
            if (categoryList.isNotEmpty() && selected.isEmpty()) {
                selected = categoryList[0].name
                onCategorySelected(selected)
            }
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            items(categoryList.size) { index ->
                val item = categoryList[index]
                val isSelected = item.name == selected
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item.name,
                        color = if (isSelected) Color(0xFFCC7861) else Color(0xFFF4B5A4),
                        fontSize = 22.sp,
                        modifier = Modifier
                            .clickable {
                                selected = item.name
                                onCategorySelected(item.name)
                            }
                    )
                    if (index != categoryList.lastIndex) {
                        Text(
                            text = " | ",
                            fontSize = 22.sp,
                            color = Color(0xFFE0AFA0),
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }
                }
            }
        }
    }
}