package com.example.enishop.ui.page.detail_article

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.enishop.Article
import com.example.enishop.ui.theme.Typography
import java.util.Date

@Composable
fun DetailArticleScreen(idArticle : Int,modifier: Modifier = Modifier) {
    var isFavorite = false;
    val article =  Article(
        id = 3,
        name = "Mens Cotton Jacket",
        description = "great outerwear jackets for Spring/Autumn/Winter, suitablefor many occasions, such as working, hiking, camping, mountain/rock climbing, cycling, traveling or other outdoors. Good gift choice for you or your family member. A warm hearted love to Father, husband or son in this thanksgiving or Christmas Day.",
        price = 55.99f,
        urlImage = "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_t.png",
        category = "men's clothing", date = Date()
    )
    val context = LocalContext.current
    Column(modifier
        .padding(16.dp)) {
        Text("${idArticle}${article.name}",
            style = Typography.headlineMedium,
            modifier=Modifier.clickable {
                Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://google.com/search?q=${article.name}")).also {
                        context.startActivity(it)
                }
            })
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            model=article.urlImage,
            contentDescription = article.name)
        Text(article.description)
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Prix: ${article.price}€")
            Text("Date de sortie : ${article.date.date}/${article.date.month+1}")
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