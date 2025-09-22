package com.example.enishop.ui.page.articles_list

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.enishop.articles
import com.example.enishop.ui.page.articles_list.widget.ItemArticle

@Composable
fun ArticlesListScreen(modifier: Modifier = Modifier.Companion) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2)
    ) {
        items(articles) {
            ItemArticle(article=it)
        }
    }
}