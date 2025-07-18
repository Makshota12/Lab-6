package com.example.lab6.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab6.data.PersonDao
import com.example.lab6.data.PersonRepository
import com.example.lab6.model.PersonEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(
    private val repository: PersonRepository
) : ViewModel() {
    val allPersons: Flow<List<PersonEntity>> = repository.getAllPersons()

    suspend fun getPersonById(id: Int): PersonEntity? = repository.getPersonById(id)

    fun addPerson(person: PersonEntity) = viewModelScope.launch {
        repository.addPerson(person)
    }

    fun updatePerson(person: PersonEntity) = viewModelScope.launch {
        repository.updatePerson(person)
    }

    fun deletePerson(person: PersonEntity) = viewModelScope.launch {
        repository.deletePerson(person)
    }
}