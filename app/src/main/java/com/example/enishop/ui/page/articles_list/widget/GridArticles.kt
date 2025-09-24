package com.example.enishop.ui.page.articles_list.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.enishop.Article

@Composable
fun GridArticles(
    modifier: Modifier = Modifier,
    articles : List<Article>,
    onClickArticle : (article: Article)->Unit
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2)
    ) {
        items(articles) {
            ItemArticle(article=it,
                modifier = Modifier.clickable{onClickArticle(it)}
            )
        }
    }
}