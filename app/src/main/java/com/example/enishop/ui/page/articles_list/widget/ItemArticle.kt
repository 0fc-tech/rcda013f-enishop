package com.example.enishop.ui.page.articles_list.widget

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.enishop.Article
import com.example.enishop.ui.theme.Typography

@Composable
fun ItemArticle(modifier: Modifier = Modifier, article: Article) {
    OutlinedCard(Modifier.padding(8.dp),) {
        Column(
            modifier= Modifier.fillMaxWidth().padding(8.dp)) {
            Box(Modifier.align(Alignment.CenterHorizontally)
                .border(1.dp, Color.Red, CircleShape)) {
                AsyncImage(
                    model = article.urlImage, contentDescription = article.name,
                    Modifier
                        .size(150.dp)
                        .padding(8.dp)
                        .clip(CircleShape)
                )
            }
            Text(article.name,
                style = Typography.titleLarge,
                maxLines = 2,
                minLines = 2,
                textAlign = TextAlign.Start)
            Text(article.price.toString() + "€",Modifier.align( Alignment.CenterHorizontally,))
        }
    }
}