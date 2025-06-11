package com.esa.interiordesigndecoration.screen.launch

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.esa.interiordesigndecoration.R
import com.esa.interiordesigndecoration.component.LauchButtonLoginSigUp

@Composable
fun LaunchScreenAndLoginSigUp(
    modifier: Modifier = Modifier,
    navController: NavController
    ) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        Column(
            modifier = Modifier
                .offset(x = 73.dp, y = 300.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.lauchicon),
                contentDescription = "lauch icon",
                modifier = modifier
                    .size(150.dp)
            )

            Text(
                text = stringResource(R.string.lauch_text1),
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF4B5A4),
                fontSize = 50.sp
            )

            Text(
                text = stringResource(R.string.lauch_text2),
                color = Color(0xFFF4B5A4),
                fontSize = 30.sp,
                letterSpacing = 11.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(R.string.lorem),
                textAlign = TextAlign.Center,
                color = Color(0xFFF4B5A4),
                modifier = Modifier
                    .width(250.dp)
            )
            Spacer(Modifier.height(25.dp))

            LauchButtonLoginSigUp(
                navController = navController,
                modifier = Modifier
                    .width(180.dp)
            )
        }
    }
}



//@Preview
//@Composable
//fun PrevLauchAndLoginSigUp(modifier: Modifier = Modifier) {
//    LaunchScreenAndLoginSigUp()
//}