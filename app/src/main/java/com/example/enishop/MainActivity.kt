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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
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

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EniShopTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),topBar = {
                    TopAppBar(
                        title = {
                            Text("Small Top App Bar")
                        }
                    )
                },) { innerPadding ->
                    Column(Modifier.padding(innerPadding).padding(16.dp)) {
                        Text("Mens Casual Premium Slim Fit T-Shirts",
                            fontWeight = FontWeight.Bold, fontSize = 32.sp)
                        AsyncImage(
                            modifier = Modifier.fillMaxWidth().height(250.dp),
                            model="https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_t.png",
                            contentDescription = "Image T-Shirt")
                        Text("Slim-fitting")
                        Row(modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween) {
                            Text("Prix: 22,30€")
                            Text("Date de sortie : 03/04/2024")
                        }
                        Checkbox(true,onCheckedChange = null)


                    }
                }
            }
        }
    }
}

