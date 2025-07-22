package com.esa.interiordesigndecoration.ui.screen.wishlist

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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RestoreFromTrash
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.esa.interiordesigndecoration.R
import com.esa.interiordesigndecoration.ui.component.TopBar
import com.esa.interiordesigndecoration.viewmodel.WishlistViewModel

@Composable
fun WishListScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val viewModelProductWishList: WishlistViewModel = hiltViewModel()
    val wishlist by viewModelProductWishList.productWishlist.collectAsState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(Modifier.height(10.dp))
        TopBar(
            topBarTitle = "Wishlist",
            onBackClicked = { navController.popBackStack() },
            modifier = Modifier
                .width(250.dp)
                .padding(start = 20.dp)
        )
        Spacer(Modifier.height(25.dp))
        if (wishlist.isEmpty()){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(R.drawable.wishlisticon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                )
                Text(
                    text = "Yor Wishlist Is Empty",
                    fontWeight = FontWeight.W400,
                    fontSize = 23.sp
                )
            }
        }else{
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(700.dp)
            ) {
                items(wishlist) {
                    if (it != null) {
                        Row(
                            modifier = Modifier
                                .padding(10.dp)
                                .heightIn(max = 90.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(90.dp)
                                    .clip(shape = RoundedCornerShape(10.dp))
                            ) {
                                AsyncImage(
                                    model = it.pictureUrl,
                                    contentDescription = null,
                                    contentScale = ContentScale.FillBounds
                                )
                            }
                            Spacer(Modifier.width(8.dp))
                            Column(
                                modifier = Modifier
                                    .weight(4f)
                                    .padding(top = 5.dp)
                            ) {
                                Text(
                                    text = it.name,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 17.sp,
                                    color = Color(0xFFCC7861)
                                )
                                Text(
                                    text = it.description,
                                    fontSize = 14.sp
                                )
                            }
                            Icon(
                                imageVector = Icons.Default.RestoreFromTrash,
                                contentDescription = null,
                                modifier = Modifier
                                    .clickable {
                                        viewModelProductWishList.delete(it)
                                    }
                                    .weight(1f)
                                    .padding(top = 5.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}