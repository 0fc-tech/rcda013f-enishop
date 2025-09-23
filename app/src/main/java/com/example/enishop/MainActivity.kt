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
import com.example.enishop.ui.page.AddArticlePage
import com.example.enishop.ui.page.articles_list.ArticlesListScreen
import com.example.enishop.ui.theme.EniShopTheme
import com.example.enishop.ui.theme.Typography
import java.time.LocalDateTime
import java.util.Date
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
                            Text("ENI SHOP")
                        }
                    )
                },) { innerPadding ->
                    ArticlesListScreen(Modifier.padding(innerPadding))
                //AddArticlePage(Modifier.padding(innerPadding))
                }
            }
        }
    }

}

@Composable
fun DetailProduit(modifier: Modifier = Modifier) {
    //var isFavorite = false;
//
    //Column(modifier
    //    .padding(16.dp)) {
    //    Text(articles[0].name,
    //        style = Typography.headlineMedium)
    //    AsyncImage(
    //        modifier = Modifier
    //            .fillMaxWidth()
    //            .height(250.dp),
    //        model=articles[0].urlImage,
    //        contentDescription = articles[0].name)
    //    Text(articles[0].description)
    //    Row(modifier = Modifier.fillMaxWidth(),
    //        horizontalArrangement = Arrangement.SpaceBetween) {
    //        Text("Prix: ${articles[0].price}€")
    //        Text("Date de sortie : ${articles[0].date.date}/${articles[0].date.month+1}")
    //    }
    //    Row(
    //        modifier = Modifier.fillMaxWidth(),
    //        verticalAlignment = Alignment.CenterVertically,
    //        horizontalArrangement = Arrangement.Center) {
    //        Checkbox(
    //            isFavorite,
    //            onCheckedChange = { checked -> isFavorite = checked },
    //        )
    //        Text("Favoris?  ")
    //    }
//
//
    //}
}
