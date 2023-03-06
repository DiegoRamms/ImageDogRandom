package com.dbappgame.myapplicationchallenge.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dbappgame.myapplicationchallenge.di.IODispatcher
import com.dbappgame.myapplicationchallenge.domain.model.Dog
import com.dbappgame.myapplicationchallenge.domain.model.Resource
import com.dbappgame.myapplicationchallenge.domain.repository.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DogViewModel @Inject constructor(
    private val repository: DogRepository,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _dog = MutableLiveData<Dog>()
    val dog: LiveData<Dog> get() = _dog

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading


    fun getDog() {
        viewModelScope.launch(ioDispatcher) {
            _isLoading.postValue( true )
            when(val resource =repository.getDog()){
                is Resource.Success -> {resource.data.let { _dog.postValue(it) }}
                is Resource.Error -> {_error.postValue(resource.message)}
            }
            _isLoading.postValue(false)
        }
    }

}