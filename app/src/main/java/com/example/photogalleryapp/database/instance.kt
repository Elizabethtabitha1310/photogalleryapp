package com.example.photogalleryapp.database

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {
    @Volatile
    private var INSTANCE: PhotoGalleryDatabase? = null

    fun getInstance(context: Context): PhotoGalleryDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                PhotoGalleryDatabase::class.java,
                "photo_gallery_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}
