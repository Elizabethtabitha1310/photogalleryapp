package com.example.photogalleryapp

import android.app.Application
import com.example.photogalleryapp.database.PhotoGalleryDatabase
import com.example.photogalleryapp.repository.AlbumRepository
import com.example.photogalleryapp.repository.PhotoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class PhotoGalleryApplication : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())

    private val database by lazy { PhotoGalleryDatabase.getDatabase(this, applicationScope) }
    val photoRepository by lazy { PhotoRepository(database.photoDao()) }
    val albumRepository by lazy { AlbumRepository(database.albumDao()) }
}
