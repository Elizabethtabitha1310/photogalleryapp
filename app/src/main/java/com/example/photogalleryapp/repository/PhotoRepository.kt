package com.example.photogalleryapp.repository

import androidx.lifecycle.LiveData
import com.example.photogalleryapp.daos.PhotoDao
import com.example.photogalleryapp.entities.Photo

class PhotoRepository(private val photoDao: PhotoDao) {
    val allPhotos: LiveData<List<Photo>> = photoDao.getAllPhotos()

    suspend fun insert(photo: Photo) {
        photoDao.insert(photo)
    }

    suspend fun update(photo: Photo) {
        photoDao.update(photo)
    }

    suspend fun delete(photo: Photo) {
        photoDao.delete(photo)
    }
}
