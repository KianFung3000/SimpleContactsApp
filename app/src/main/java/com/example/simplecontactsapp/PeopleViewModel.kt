package com.example.simplecontactsapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PeopleViewModel : ViewModel() {
    private val _people = MutableLiveData<List<Person>>(emptyList())
    val people: LiveData<List<Person>> = _people

    fun add(person: Person) {
        _people.value = _people.value.orEmpty() + person
    }
}