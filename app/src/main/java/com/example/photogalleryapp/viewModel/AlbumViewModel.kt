package com.example.photogalleryapp.viewModel

import androidx.lifecycle.*
import com.example.photogalleryapp.entities.Album
import com.example.photogalleryapp.repository.AlbumRepository
import kotlinx.coroutines.launch

class AlbumViewModel(private val repository: AlbumRepository) : ViewModel() {
    val allAlbums: LiveData<List<Album>> = repository.allAlbums

    fun insert(album: Album) = viewModelScope.launch {
        repository.insert(album)
    }

    fun update(album: Album) = viewModelScope.launch {
        repository.update(album)
    }

    fun delete(album: Album) = viewModelScope.launch {
        repository.delete(album)
    }
}


