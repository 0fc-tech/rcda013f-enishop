package com.example.enishop.ui.page.articles_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.enishop.Article
import com.example.enishop.ui.page.articles_list.widget.CategoryFilters
import com.example.enishop.ui.page.articles_list.widget.GridArticles
import com.example.enishop.ui.page.articles_list.widget.ItemArticle
import com.example.enishop.vm.ArticlesListVM

@Composable
fun ArticlesListScreen(modifier: Modifier = Modifier.Companion,
                       onClickArticle : (article : Article )->Unit,
                       vm: ArticlesListVM = viewModel()) {
    val articles by vm.articles.collectAsState()
    Column(modifier) {
        CategoryFilters(onCategorySelected = {
            vm.filterArticles(it)
        })
        GridArticles(articles =articles, onClickArticle = onClickArticle)
    }
}