# Interior Design App

**Interior Design App** adalah aplikasi mobile katalog furnitur yang dibangun dengan **Kotlin** dan **Jetpack Compose**. Aplikasi ini memungkinkan pengguna untuk mengeksplorasi berbagai produk furnitur, menyimpan furnitur ke dalam wishlist, dan menyimpan ke dalam cart.

## Fitur

- Google Sign-In
- Katalog furnitur yang dipisahkan peruangan
- Wishlist
- Cart

## Arsitektur
Aplikasi ini menerapkan arsitektur **MVVM (Model-View-ViewModel)** yang dipadukan dengan prinsip Clean Architecture.

## Tech Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose
- **State Management**: ViewModel + StateFlow
- **Dependency Injection**: Hilt
- **Database**: Room
- **Networking**: Retrofit + Gson
- **Authentication**: Firebase Auth
- **Architecture**: MVVM + Repository Pattern

## 📸 Screenshots

| Launch                                  | Login (With Google Sign-In)                          |
|-----------------------------------------|------------------------------------------------------|
| ![Lauch](screenshoot/launch_screen.jpg) | ![Login](screenshoot/login_screen_with_firebase.jpg) |

| Home                                 | Category                                           | 
|--------------------------------------|----------------------------------------------------|
| ![Home](screenshoot/home_screen.jpg) | ![Category](screenshoot/detail_product_screen.jpg) |

| Detail Product                                           | Cart                                 | 
|----------------------------------------------------------|--------------------------------------|
| ![Detail Product](screenshoot/detail_product_screen.jpg) | ![Cart](screenshoot/cart_screen.jpg) |

| Wishlist                                     | Profile                                    | 
|----------------------------------------------|--------------------------------------------|
| ![Wishlist](screenshoot/wishlist_screen.jpg) | ![Profile](screenshoot/profile_screen.jpg) |

## Etc
- Design from Figma Community : https://www.figma.com/design/MLmoaUmK87cyXxfHUeFwT8/Home-Decor-App-Mobile-UI-Kit-%7C-Interior-Design-Decoration-Mobile-App--Community-?node-id=5001-2284&p=f&t=UiUxe2SCTM2mAypX-0
- Dummy API : https://www.postman.com/sevenstrong/aps-net-core-apis/collection/vdgiz95/