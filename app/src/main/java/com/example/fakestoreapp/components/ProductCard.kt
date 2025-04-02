package com.example.fakestoreapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.fakestoreapp.models.Product
import com.example.fakestoreapp.models.Rating
import com.example.fakestoreapp.ui.theme.FakeStoreAppTheme

@Composable
fun ProductCard(
    product: Product,
    unAClick : (Product) -> Unit
    ){
    Card (modifier = Modifier.fillMaxWidth()
        .height(200.dp)
        .padding(5.dp)
        .clickable {
            unAClick(product)
        }
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().weight(3f),
                contentScale = ContentScale.Crop
            )
            Text(text = product.title, modifier = Modifier.fillMaxWidth().weight(1f))
        }
    }

}

@Preview
@Composable
fun ProductCardPreview(){
    val testProduct = Product(
        id = 1,
        title = "IPhone 13",
        description = "Buen telefono",
        price = 17_000.0,
        category = "Telefonia",
        image = "",
        rating = Rating(count = 5, 5.0)
    )
    FakeStoreAppTheme {
        ProductCard(product = testProduct, unAClick = { println("_")})
    }
}