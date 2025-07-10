package com.esa.interiordesigndecoration.screen.homepage

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.esa.interiordesigndecoration.R
import com.esa.interiordesigndecoration.component.Search
import com.esa.interiordesigndecoration.data.model.CardProductModel
import com.esa.interiordesigndecoration.data.model.RoomNameModel
import com.esa.interiordesigndecoration.data.viewmodel.AuthState
import com.esa.interiordesigndecoration.data.viewmodel.AuthViewModel
import com.esa.interiordesigndecoration.data.viewmodel.AuthWithGoogle
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@Composable
fun HomePageScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    ) {
    val context = LocalContext.current
    val authWithGoogle = remember { AuthWithGoogle(context) }
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(Modifier.height(60.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        authWithGoogle.signout()
                            .onEach {respone ->
                                if (respone is AuthState.Unauthenticated){
                                    navController.navigate("login")
                                }
                            }
                            .launchIn(coroutineScope)
                    }
            ){
                Column {
                    Text(
                        text = "Hi, Welcome Back",
                        color = Color(0xFFF4B5A4),
                        fontSize = 23.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Create spaces that bring joy"
                    )
                }
                Search()
            }
            BannerSlider()
            Spacer(Modifier.height(15.dp))
            Categories()
            Spacer(Modifier.height(15.dp))
            BestSeller()
            Spacer(Modifier.height(15.dp))
            NewCollection()
        }
    }
}

@Composable
fun BannerSlider(modifier: Modifier = Modifier) {
    val bannerImage = listOf(
        R.drawable.benner,
        R.drawable.benner,
        R.drawable.benner,
        R.drawable.benner
    )
    val pagerState = rememberPagerState(pageCount = {bannerImage.size})
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(pagerState) {
        while (true){
            delay(8000)
            val nextPage = (pagerState.currentPage + 1) % bannerImage.size
            pagerState.animateScrollToPage(nextPage)
        }
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ){
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clip(RoundedCornerShape(12.dp))
        ) {page ->
            Image(
                painter = painterResource(id = bannerImage[page]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ){
            //repeat sama aja dengan bannerImage.forEachIndexed{index, _ ->}
            repeat(bannerImage.size){
                val isSelected = it == pagerState.currentPage
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .width(if (isSelected) 30.dp else 15.dp)
                        .height(5.dp)
                        .clip(CircleShape)
                        .clickable {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(it)
                            }
                        }
                        .background(if (isSelected) Color.Black else Color(0xFFF4B5A4))
                )
            }
        }
    }
}

@Composable
fun Categories(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxWidth()
    ){
        Text(
            text = "Categories",
            style = MaterialTheme.typography.labelMedium,
            color = Color(0xFFB45A4A),
            fontSize = 14.sp
        )
        Spacer(Modifier.height(10.dp))
        val listCategories : List<RoomNameModel> = listOf(
            RoomNameModel(R.drawable.categorybedroom),
            RoomNameModel(R.drawable.categorydiningroom),
            RoomNameModel(R.drawable.categorykitcen),
            RoomNameModel(R.drawable.categorylivingroom),
            RoomNameModel(R.drawable.categoryoffice),
            RoomNameModel(R.drawable.categorybedroom),
            RoomNameModel(R.drawable.categorydiningroom),
            RoomNameModel(R.drawable.categorykitcen),
            RoomNameModel(R.drawable.categorylivingroom),
            RoomNameModel(R.drawable.categoryoffice)
        )
        var selected by remember { mutableStateOf(listCategories[0]) }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            items(listCategories){
                val isSelected = it == selected
                Box(
                    modifier = Modifier
                        .clickable { selected = it }
                        .size(60.dp)
                        .clip(RoundedCornerShape(17.dp))
                        .background(if (isSelected) Color(0xFFF4B5A4) else Color(0xFFCC7861))
                ) {
                    Image(
                        painter = painterResource(id = it.image),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun BestSeller(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Best Seller",
            style = MaterialTheme.typography.labelMedium,
            color = Color(0xFFB45A4A),
            fontSize = 14.sp
        )
        Spacer(Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .background(Color(0xFFF4B5A4), shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Kitchen Cart",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Row(
                            modifier = Modifier
                                .background(Color.White, shape = RoundedCornerShape(16.dp))
                                .padding(horizontal = 8.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = Color(0xFFFFC107),
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = "4.5")
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .background(Color.White, shape = RoundedCornerShape(16.dp))
                                .clickable { /* Handle click */ }
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Text(text = "Shop Now")
                        }
                    }
                }
                Image(
                    painter = painterResource(R.drawable.kitchen6),
                    contentDescription = "best seller",
                    modifier = Modifier
                        .size(140.dp) // Adjust based on your design
                        .clip(RoundedCornerShape(8.dp))
                )
            }
        }
    }
}

@Composable
fun NewCollection(modifier: Modifier = Modifier) {
    val cardProductList = listOf(
        CardProductModel(image = R.drawable.bedroom1, nameProduct = "Product 1", descriptionProduct = "Lorem ipsum dolor sit amet, consectetur adipiscing elit", price = 12000),
        CardProductModel(image = R.drawable.bedroom2, nameProduct = "Product 2", descriptionProduct = "Lorem ipsum dolor sit amet, consectetur adipiscing elit", price = 12000),
        CardProductModel(image = R.drawable.bedroom3, nameProduct = "Product 3", descriptionProduct = "Lorem ipsum dolor sit amet, consectetur adipiscing elit", price = 12000),
        CardProductModel(image = R.drawable.bedroom4, nameProduct = "Product 4", descriptionProduct = "Lorem ipsum dolor sit amet, consectetur adipiscing elit", price = 12000),
        CardProductModel(image = R.drawable.bedroom5, nameProduct = "Product 5", descriptionProduct = "Lorem ipsum dolor sit amet, consectetur adipiscing elit", price = 12000),
        CardProductModel(image = R.drawable.kitchen1, nameProduct = "Product 6", descriptionProduct = "Lorem ipsum dolor sit amet, consectetur adipiscing elit", price = 12000),
        CardProductModel(image = R.drawable.kitchen2, nameProduct = "Product 7", descriptionProduct = "Lorem ipsum dolor sit amet, consectetur adipiscing elit", price = 12000),
        CardProductModel(image = R.drawable.kitchen3, nameProduct = "Product 8", descriptionProduct = "Lorem ipsum dolor sit amet, consectetur adipiscing elit", price = 12000)
    )
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(285.dp)
    ) {
        Text(
            text = "New Collection",
            style = MaterialTheme.typography.labelMedium,
            color = Color(0xFFB45A4A),
            fontSize = 14.sp
        )
        Spacer(Modifier.height(10.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(cardProductList){
                Card(
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(Color(0xFFFAF0E6))
                    ){
                        Image(
                            painter = painterResource(it.image),
                            contentDescription = "product",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(110.dp)
                        )
                    }
                    Spacer(Modifier.height(7.dp))
                    Text(
                        text = it.nameProduct,
                        color = Color(0xFFF4B5A4),
                        fontSize = 16.sp
                    )
                    Text(
                        text = it.descriptionProduct,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W300
                    )
                    Spacer(Modifier.height(3.dp))
                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Gray,
                        thickness = 0.5.dp
                    )
                    Spacer(Modifier.height(3.dp))
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
                            fontSize = 14.sp
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
                }
            }
        }
    }
}
//
//@Preview
//@Composable
//private fun HomePagePrev() {
//    HomePageScreen()
//}