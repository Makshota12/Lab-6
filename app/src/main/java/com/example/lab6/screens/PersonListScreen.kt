package com.example.lab6.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.lab6.model.PersonEntity
import com.example.lab6.viewmodel.PersonViewModel

@Composable
fun PersonListScreen(
    navController: NavController,
    viewModel: PersonViewModel = hiltViewModel()
) {
    val persons by viewModel.allPersons.collectAsState(initial = emptyList())

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("edit/0") }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Person")
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(persons) { person ->
                PersonListItem(
                    person = person,
                    onDelete = { viewModel.deletePerson(person) },
                    onClick = { navController.navigate("detail/${person.id}") }
                )
            }
        }
    }
}

@Composable
fun PersonListItem(
    person: PersonEntity,
    onDelete: () -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = person.name, style = MaterialTheme.typography.titleMedium)
                Text(text = "Age: ${person.age}", style = MaterialTheme.typography.bodyMedium)
            }
            IconButton(onClick = onDelete) {
                Icon(Icons.Default.Delete, contentDescription = "Delete")
            }
        }
    }
}