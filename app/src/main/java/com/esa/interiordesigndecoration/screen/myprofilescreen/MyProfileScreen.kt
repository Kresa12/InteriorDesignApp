package com.esa.interiordesigndecoration.screen.myprofilescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.esa.interiordesigndecoration.R
import com.esa.interiordesigndecoration.component.TopBar
import com.esa.interiordesigndecoration.data.viewmodel.AuthState
import com.esa.interiordesigndecoration.data.viewmodel.AuthWithGoogle
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun MyProfileScreen(
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
        TopBar(
            onBackClicked = {
                navController.popBackStack()
            },
            topBarTitle = stringResource(R.string.topbar_myprofile_title),
            modifier = Modifier
                .width(255.dp)
                .padding(start = 20.dp)
        )
        Spacer(Modifier.height(40.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.profileimage),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .clip(shape = CircleShape)
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = "Maria Marline",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(Modifier.height(5.dp))
            Text(
                text = "ID : 23090075"
            )
        }
        Spacer(Modifier.height(30.dp))
        Column(
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp)
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color(0xFFF4B5A4))
                        .padding(7.dp)
                ){
                    Icon(
                        painter = painterResource(R.drawable.help_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(25.dp)
                    )
                }
                Spacer(Modifier.width(10.dp))
                Text(
                    text = "Help",
                    fontWeight = FontWeight.W400,
                    fontSize = 25.sp
                )
            }
            Spacer(Modifier.height(15.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color(0xFFF4B5A4))
                        .padding(7.dp)
                ){
                    Icon(
                        painter = painterResource(R.drawable.settings_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(25.dp)
                    )
                }
                Spacer(Modifier.width(10.dp))
                Text(
                    text = "Settings",
                    fontWeight = FontWeight.W400,
                    fontSize = 25.sp
                )
            }
            Spacer(Modifier.height(15.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        authWithGoogle.signout()
                            .onEach {response ->
                                if (response is AuthState.Unauthenticated){
                                    navController.navigate("login")
                                }
                            }
                            .launchIn(coroutineScope)
                    }
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color(0xFFF4B5A4))
                        .padding(7.dp)
                ){
                    Icon(
                        painter = painterResource(R.drawable.logout_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(25.dp)
                    )
                }
                Spacer(Modifier.width(10.dp))
                Text(
                    text = "Logout",
                    fontWeight = FontWeight.W400,
                    fontSize = 25.sp
                )
            }
        }
    }
}