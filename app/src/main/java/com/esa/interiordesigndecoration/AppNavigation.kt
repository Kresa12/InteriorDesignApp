package com.esa.interiordesigndecoration

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.esa.interiordesigndecoration.screen.DetailProductScrenn
import com.esa.interiordesigndecoration.screen.bathroom.BathRoom
import com.esa.interiordesigndecoration.screen.bedroom.BedRoomScreen
import com.esa.interiordesigndecoration.screen.cart.CartScreen
import com.esa.interiordesigndecoration.screen.forgotpassword.ForgotPasswordScreen
import com.esa.interiordesigndecoration.screen.homepage.HomePageScreen
import com.esa.interiordesigndecoration.screen.kitchenroom.Kitchen
import com.esa.interiordesigndecoration.screen.launch.LaunchScreenAndLoginSigUp
import com.esa.interiordesigndecoration.screen.livingroom.LivingRoomScreen
import com.esa.interiordesigndecoration.screen.login.LoginScreen
import com.esa.interiordesigndecoration.screen.myprofilescreen.MyProfileScreen
import com.esa.interiordesigndecoration.screen.onboarding.OnBoardingScreen
import com.esa.interiordesigndecoration.screen.sIgnup.SignupScreen
import com.esa.interiordesigndecoration.screen.specialoffer.SpecialOfferScreen
import com.esa.interiordesigndecoration.screen.splash.SplashScreen
import com.esa.interiordesigndecoration.screen.wishlist.WishListScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    selectedRoomIndex: MutableState<Int>
) {
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable("launch") {
            LaunchScreenAndLoginSigUp(
                navController = navController,
                modifier = modifier
            )
        }
        composable("login") {
            LoginScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable("signup") {
            SignupScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable("forgotPassword") {
            ForgotPasswordScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable("onBoarding") {
            OnBoardingScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable("homePage") {
            HomePageScreen(
                modifier = modifier,
                navController = navController,
                selectedRoomIndex = selectedRoomIndex,
                navigateToDetailProduct = { navController.navigate("productDetail/${it}") }
            )
        }
        composable("bedRoom") {
            BedRoomScreen(
                modifier = modifier,
                navigateToDetailProduct = { navController.navigate("productDetail/${it}") },
                onBackClicked = {navController.popBackStack()}
            )
        }
        composable("kitchen") {
            Kitchen(
                modifier = modifier,
                navigateToDetailProduct = { navController.navigate("productDetail/${it}") },
                onBackClicked = {navController.popBackStack()}
            )
        }
        composable("livingRoom") {
            LivingRoomScreen(
                modifier = modifier,
                navigateToDetailProduct = { navController.navigate("productDetail/${it}") },
                onBackClicked = {navController.popBackStack()}
            )
        }
        composable("bathRoom") {
            BathRoom(
                modifier = modifier,
                navigateToDetailProduct = { navController.navigate("productDetail/${it}") },
                onBackClicked = {navController.popBackStack()}
            )
        }
        composable("productDetail/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            DetailProductScrenn(
                modifier = modifier,
                productId = productId,
                onBackClicked = { navController.popBackStack() }
            )
        }
        composable("cart"){
            CartScreen(
                modifier = modifier
            )
        }
        composable("wishList"){
            WishListScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable("myProfile"){
            MyProfileScreen(
                modifier = modifier,
                navController = navController
            )
        }
        //        composable("product") {
//            SpecialOfferScreen(
//                onBackClicked = {},
//                navigateToDetailProduct = { navController.navigate("productDetail/${it}") }
//            )
//        }
    }
}