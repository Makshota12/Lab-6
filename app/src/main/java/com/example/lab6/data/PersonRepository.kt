package com.example.lab6.data

import com.example.lab6.model.PersonEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PersonRepository @Inject constructor(
    private val personDao: PersonDao
) {
    // Все методы возвращают Flow для реактивного обновления UI
    fun getAllPersons(): Flow<List<PersonEntity>> = personDao.getAll()

    suspend fun addPerson(person: PersonEntity) = personDao.insert(person)

    suspend fun updatePerson(person: PersonEntity) = personDao.update(person)

    suspend fun deletePerson(person: PersonEntity) = personDao.delete(person)

    suspend fun getPersonById(id: Int): PersonEntity? =
        personDao.getById(id) // Добавьте этот метод в PersonDao
}