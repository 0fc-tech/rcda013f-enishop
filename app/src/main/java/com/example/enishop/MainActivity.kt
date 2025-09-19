@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.enishop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.enishop.ui.theme.EniShopTheme
import com.example.enishop.ui.theme.Typography
import java.time.LocalDateTime
import java.util.Date
val articles = listOf(
    Article(
        id = 1,
        name = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
        description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
        price = 109.95f,
        urlImage = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_t.png",
        category = "men's clothing",
        date = Date(),
    ),
    Article(
        id = 2,
        name = "Mens Casual Premium Slim Fit T-Shirts",
        description = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.",
        price = 22.3f,
        urlImage = "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_t.png",
        category = "men's clothing",
        date = Date(),
    ),
    Article(
        id = 3,
        name = "Mens Cotton Jacket",
        description = "great outerwear jackets for Spring/Autumn/Winter, suitablefor many occasions, such as working, hiking, camping, mountain/rock climbing, cycling, traveling or other outdoors. Good gift choice for you or your family member. A warm hearted love to Father, husband or son in this thanksgiving or Christmas Day.",
        price = 55.99f,
        urlImage = "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_t.png",
        category = "men's clothing", date = Date()
    )
)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EniShopTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),topBar = {
                    TopAppBar(
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            titleContentColor = MaterialTheme.colorScheme.primary,
                        ),                        title = {
                            Text(articles[0].name)
                        }
                    )
                },) { innerPadding ->
                    DetailProduit(Modifier.padding(innerPadding))
                }
            }
        }
    }

}

@Composable
fun DetailProduit(modifier: Modifier = Modifier) {
    var isFavorite = false;

    Column(modifier
        .padding(16.dp)) {
        Text(articles[0].name,
            style = Typography.headlineMedium)
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            model=articles[0].urlImage,
            contentDescription = articles[0].name)
        Text(articles[0].description)
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Prix: ${articles[0].price}€")
            Text("Date de sortie : ${articles[0].date.date}/${articles[0].date.month+1}")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Checkbox(
                isFavorite,
                onCheckedChange = { checked -> isFavorite = checked },
            )
            Text("Favoris?  ")
        }


    }
}
