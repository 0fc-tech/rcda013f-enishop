package com.example.enishop.ui.page.articles_list.widget

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CategoryFilters(modifier: Modifier = Modifier,
                    onCategorySelected : (category : String)-> Unit) {
    val categories = listOf(
        "electronics","jewelery",
        "men's clothing","women's clothing",)
    var categorySelected by remember {mutableStateOf("")}
    LazyRow {
        items(categories){categoryDisplayed->
            FilterChip(
                categorySelected == categoryDisplayed,
                {
                    if(categorySelected == categoryDisplayed){
                        categorySelected = ""
                    }else {
                        categorySelected = categoryDisplayed
                    }
                    onCategorySelected(categorySelected)
                },
                label = {
                    Text(categoryDisplayed)
                },
                modifier=Modifier.padding(start = 4.dp)
            )
        }
    }
}