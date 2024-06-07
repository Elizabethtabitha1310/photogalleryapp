package com.example.photogalleryapp.repository

import androidx.lifecycle.LiveData
import com.example.photogalleryapp.daos.AlbumDao
import com.example.photogalleryapp.entities.Album

class AlbumRepository(private val albumDao: AlbumDao) {
    val allAlbums: LiveData<List<Album>> = albumDao.getAllAlbums()

    suspend fun insert(album: Album) {
        albumDao.insert(album)
    }

    suspend fun update(album: Album) {
        albumDao.update(album)
    }

    suspend fun delete(album: Album) {
        albumDao.delete(album)
    }
}
