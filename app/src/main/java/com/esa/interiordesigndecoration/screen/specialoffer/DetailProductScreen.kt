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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.esa.interiordesigndecoration.component.Search

@Composable
fun DetailProductScrenn(
    modifier: Modifier = Modifier,
    productId: Int,
    onBackClicked: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(Modifier.height(60.dp))

        TopBarDetailProduct(onBackClicked = onBackClicked)

        Spacer(Modifier.height(10.dp))

        Category()

        DetailProductInformation(productId = productId)

        AddToCartButton()
    }
}

@Composable
fun TopBarDetailProduct(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit = {}
) {

    Row(
        modifier = modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
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
            text = "Kategori Barang",
            color = Color(0xFFF4B5A4),
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold
        )

        Search()
    }
}

@Composable
fun DetailProductInformation(
    modifier: Modifier = Modifier,
    viewModel: ProductViewModel = viewModel(),
    productId: Int
) {

    val product by viewModel.product.collectAsState()
    val productDetail = product.find { it.id == productId }

//    val isLoading = viewModel.isLoading.collectAsState()
//    val loadingValue = isLoading.value
//
//    val onFetch = viewModel.fetchProduct()

    //selanjutnya tinggak mikirin gimana caranya loadingnya bagus baik di detail screen maupun di prdudct screen

    productDetail?.let{

//        if (loadingValue){
//            CircularProgressIndicator(
//                modifier = Modifier.width(64.dp),
//                color = Color.White,
//                trackColor = Color(0xFFFAF0E6),
//            )
//        }
//
//        LaunchedEffect(Unit) {
//            return@LaunchedEffect onFetch
//        }

        Column(
            modifier = modifier
        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(horizontal = 20.dp)
                    .clip(shape = RoundedCornerShape(13.dp))
//                .aspectRatio(1f)
                    .background(Color(0xFFFAF0E6))
            ) {
                AsyncImage(
                    model = productDetail.pictureUrl,
                    contentDescription = "",
                    modifier = Modifier
                        .size(500.dp)
                )
            }

            Column {
                Text(
                    text = productDetail.name
                )

                Text(
                    text = "Lorem ipsum dolor sit amet consectetur. Odio neque commodo id aenean quis magna. Auctor neque id pharetra gravida. Libero scelerisque ut mauris volutpat risus nec facilisi adipiscing. Augue mollis amet."
                )

                Divider()

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 3.dp, end = 3.dp, bottom = 5.dp)
                ) {
                    Text(
                        text = "$ " + productDetail.price.toString(),
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

                Row {
                    Text(
                        text = "User Review"
                    )

                    Row {
                        for (i in 1..5) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = ""
                            )
                        }
                    }

                }
            }
        }
    }



}

@Composable
fun AddToCartButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp)
            .padding(horizontal = 85.dp)
    ) {
        Text(
            text = "Add TO Cart"
        )
    }
}


//@Preview
//@Composable
//private fun DetailProductScreenPrev() {
//    DetailProductScrenn()
//}