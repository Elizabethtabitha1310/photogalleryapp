package com.example.photogalleryapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.photogalleryapp.daos.AlbumDao
import com.example.photogalleryapp.daos.PhotoDao
import com.example.photogalleryapp.entities.Album
import com.example.photogalleryapp.entities.Photo
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Photo::class, Album::class], version = 1, exportSchema = false)
abstract class PhotoGalleryDatabase : RoomDatabase() {

    abstract fun photoDao(): PhotoDao
    abstract fun albumDao(): AlbumDao

    companion object {
        @Volatile
        private var INSTANCE: PhotoGalleryDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): PhotoGalleryDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PhotoGalleryDatabase::class.java,
                    "photo_gallery_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}
