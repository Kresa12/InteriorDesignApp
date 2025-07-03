package com.esa.interiordesigndecoration.component

import androidx.compose.foundation.clickable
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
    val category by viewModel.category.collectAsState()
    var selected by remember { mutableStateOf("") }
    val fetch = viewModel.fetchCategory()
    LaunchedEffect(selected) {
        if (selected.isEmpty()){
            selected = "All"
            onCategorySelected("All")
        }
        return@LaunchedEffect fetch
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        val tos = selected == "All"
        LazyRow{
            items(category.size){index ->
                val item = category[index]
                val isSelected = item.name == selected
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (index == 0){
                        Text(
                            text = "All",
                            color = if (tos) Color(0xFFCC7861) else Color(0xFFF4B5A4),
                            fontSize = 22.sp,
                            modifier = Modifier
                                .clickable {
                                    selected = "All"
                                    onCategorySelected("All")
                                }
                        )
                    }
//                    Spacer(Modifier.width(10.dp))
                    if (index != category.lastIndex + 1) {
                        Text(
                            text = " | ",
                            fontSize = 22.sp,
                            color = Color(0xFFE0AFA0),
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }
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
                }
            }
        }
    }
}