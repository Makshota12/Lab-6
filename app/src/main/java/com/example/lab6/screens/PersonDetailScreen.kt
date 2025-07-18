package com.example.lab6.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.lab6.viewmodel.PersonViewModel
import androidx.compose.material.icons.automirrored.filled.ArrowBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonDetailScreen(
    personId: Int,
    navController: NavController,
    viewModel: PersonViewModel = hiltViewModel()
) {
    // Добавляем пустой список как начальное значение
    val persons by viewModel.allPersons.collectAsState(initial = emptyList())
    val person = remember(persons) { persons.find { it.id == personId } }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(person?.name ?: "Person Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(
                        onClick = { person?.id?.let { navController.navigate("edit/$it") } }
                    ) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit")
                    }
                }
            )
        }
    ) { padding ->
        if (person != null) {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Name: ${person.name}", style = MaterialTheme.typography.headlineMedium)
                Spacer(Modifier.height(16.dp))
                Text("Age: ${person.age}", style = MaterialTheme.typography.titleLarge)
                Text("Profession: ${person.profession}", style = MaterialTheme.typography.titleMedium)
            }
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}