package com.example.fakestoreapp.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.fakestoreapp.models.Product
import com.example.fakestoreapp.models.Rating
import com.example.fakestoreapp.services.ProductService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun ProductDetailScreen(innerPadding: PaddingValues,
                        productID :Int
){
    val scope = rememberCoroutineScope()
    val BASE_URL = "https://fakestoreapi.com/"
    var product by remember {
        mutableStateOf(
            Product(
                id = 0,
                description = "",
                title = "",
                image = "",
                price = 0.0,
                category = "",
                rating = Rating(rate = 0.0, count = 0)
            )
        )
    }
    var isLoading by remember {
        mutableStateOf(
            true
        )
    }

    LaunchedEffect(key1 = true){
        scope.launch{
            try {
                val retroBuilder = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val productService = retroBuilder.create(ProductService::class.java)

                val response = productService.getProductById(productID)
                product = response
                Log.i("ProductDetail", response.toString())

            }
            catch (e:Exception){

            }

        }



    }

    Column(modifier =  Modifier
        .fillMaxSize()
        .padding(innerPadding)
        .padding(10.dp)
    ){
        AsyncImage(
            model = product.image,
            contentDescription = null,
            modifier = Modifier.size(300.dp)
        )

        Text(text = product.title,
            fontSize = 36.sp
        )
        Text(
            text = product.description
        )
        Text(
            text = product.price.toString()
        )
    }
}