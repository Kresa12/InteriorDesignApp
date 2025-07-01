package com.esa.interiordesigndecoration.screen.specialoffer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.esa.interiordesigndecoration.R
import com.esa.interiordesigndecoration.component.Search
import com.esa.interiordesigndecoration.data.viewmodel.CategoryViewModel
import com.esa.interiordesigndecoration.data.viewmodel.ProductViewModel

@Composable
fun SpecialOfferScreen(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit = {},
    navController: NavController
) {
    var selectedCategory by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(Modifier.height(60.dp))
        TopBarSpecialOffer(onBackClicked = onBackClicked)
        Spacer(Modifier.height(25.dp))
        Category(onCategorySelected = {selectedCategory = it})
        Spacer(Modifier.height(35.dp))
        CardProduct(navController = navController, selectedCategory = selectedCategory)
    }
}

@Composable
fun TopBarSpecialOffer(
    modifier: Modifier = Modifier,
    onBackClicked : () -> Unit = {}
) {
    Row(
        modifier = modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Icon(
            imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
            contentDescription = "",
            modifier = Modifier
                .size(35.dp)
                .clickable {
                    onBackClicked()
                }
        )

        Text(
            text = stringResource(R.string.special_offer),
            color = Color(0xFFF4B5A4),
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold
        )

        Search()
    }
}

@Composable
fun Category(
    modifier: Modifier = Modifier,
    onCategorySelected: (String) -> Unit,
    viewModel: CategoryViewModel = viewModel()
) {
    val category = viewModel.category.collectAsState()
    val categoryList = category.value
    var selected by remember { mutableStateOf("") }
    LaunchedEffect(categoryList) {
        if (categoryList.isNotEmpty() && selected.isEmpty()) {
            selected = categoryList[0].name
            onCategorySelected(selected)
        }
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
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

@Composable
fun CardProduct(
    modifier: Modifier = Modifier,
    viewModel: ProductViewModel = viewModel(),
    navController: NavController,
    selectedCategory : String
) {
    val product = viewModel.product.collectAsState()
    val productList = product.value
    val isLoading = viewModel.isLoading.collectAsState()
    val loadingValue = isLoading.value
    val onFetch = viewModel.fetchProduct()
    val productFilter = productList.filter { it.categoryName == selectedCategory }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(750.dp)
            .padding(horizontal = 18.dp)
    ) {
        if (loadingValue){
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxSize()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.width(64.dp),
                    color = Color.White,
                    trackColor = Color(0xFFFAF0E6),
                )

                Text(
                    text = "Loading..."
                )
            }
        }
        LaunchedEffect(Unit) {
            return@LaunchedEffect onFetch
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(productFilter){
                Card(
                    colors = CardDefaults.cardColors(Color.White),
                    modifier = Modifier
                        .clickable { navController.navigate("productDetail/${it.id}") }
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(Color(0xFFFAF0E6))
                    ){
                        AsyncImage(
                            model = it.pictureUrl,
                            contentDescription = "product",
                            contentScale = ContentScale.FillBounds
                        )
                    }

                    Spacer(Modifier.height(7.dp))

                    Text(
                        text = it.name,
                        color = Color(0xFFF4B5A4),
                        fontSize = 16.sp
                    )

                    Text(
                        text = it.description,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W300
                    )

                    Spacer(Modifier.height(8.dp))

                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(),
                        thickness = 0.5.dp,
                        color = Color.Gray
                    )

                    Spacer(Modifier.height(8.dp))

                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 3.dp, end = 3.dp, bottom = 5.dp)
                    ){
                        Text(
                            text = "$"+ it.price.toString(),
                            style = MaterialTheme.typography.labelMedium,
                            color = Color(0xFFCC7861),
                            fontSize = 17.sp
                        )

                        Row {
                            IconButton(
                                onClick = {},
                                colors = IconButtonDefaults.iconButtonColors(Color((0xFFF4B5A4))),
                                modifier = Modifier
                                    .size(20.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(3.dp)
                                )
                            }
                            Spacer(modifier.width(5.dp))
                            IconButton(
                                onClick = {},
                                colors = IconButtonDefaults.iconButtonColors(Color((0xFFF4B5A4))),
                                modifier = Modifier
                                    .size(20.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(3.dp)
                                )
                            }
                        }

                    }

                    Text(
                        text = it.categoryName
                    )

                }
            }
        }

    }
}