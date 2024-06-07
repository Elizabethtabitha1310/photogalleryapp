package com.example.photogalleryapp.viewModel

import androidx.lifecycle.*
import com.example.photogalleryapp.entities.Photo
import com.example.photogalleryapp.repository.PhotoRepository
import kotlinx.coroutines.launch

class PhotoViewModel(private val repository: PhotoRepository) : ViewModel() {
    val allPhotos: LiveData<List<Photo>> = repository.allPhotos

    fun insert(photo: Photo) = viewModelScope.launch {
        repository.insert(photo)
    }

    fun update(photo: Photo) = viewModelScope.launch {
        repository.update(photo)
    }

    fun delete(photo: Photo) = viewModelScope.launch {
        repository.delete(photo)
    }
}


