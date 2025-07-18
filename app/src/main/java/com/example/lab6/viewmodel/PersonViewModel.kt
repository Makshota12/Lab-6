package com.example.lab6.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab6.data.PersonDao
import com.example.lab6.model.PersonEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(
    private val personDao: PersonDao
) : ViewModel() {
    val allPersons: Flow<List<PersonEntity>> = personDao.getAll()

    fun addPerson(person: PersonEntity) = viewModelScope.launch {
        personDao.insert(person)
    }

    fun updatePerson(person: PersonEntity) = viewModelScope.launch {
        personDao.update(person)
    }

    fun deletePerson(person: PersonEntity) = viewModelScope.launch {
        personDao.delete(person)
    }
}