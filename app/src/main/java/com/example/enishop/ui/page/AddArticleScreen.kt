package com.example.enishop.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun AddArticlePage(modifier: Modifier = Modifier) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    Column(modifier,verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Spacer(Modifier.padding(top=16.dp))
        TextField(
            title,
            { title = it },
            label = {Text("Titre")},
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp))
        TextField(description,
            { description = it },
            label = {Text("Description")},
            modifier = Modifier.fillMaxWidth().padding(16.dp))
        TextField(
            price,
            { price = it },
            label = {Text("Prix")},
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
        )
        MyExposedDropdownMenu()
        OutlinedButton({},
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
            Text("Valider")
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyExposedDropdownMenu() {
    // Liste des éléments à afficher dans le menu
    val options = listOf("electronics","jewelery","men's clothing","women's clothing"
    )
    // État pour l'élément sélectionné
    var selectedOption by remember { mutableStateOf(options[0]) }
    // État pour l'ouverture/fermeture du menu
    var expanded by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier =  Modifier.fillMaxWidth().padding(16.dp)
    ) {
        // Champ de texte exposé (read-only)
        TextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            label = { Text("Choisissez une option") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier
                .menuAnchor() // Nécessaire pour l'ancrage du menu
                .fillMaxWidth()
        )
        // Le menu déroulant
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        selectedOption = selectionOption
                        expanded = false
                    }
                )
            }
        }
    }
}