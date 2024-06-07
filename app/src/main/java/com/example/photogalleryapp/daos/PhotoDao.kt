package com.example.photogalleryapp.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.photogalleryapp.entities.Photo

@Dao
interface PhotoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(photo: Photo)

    @Update
    suspend fun update(photo: Photo)

    @Delete
    suspend fun delete(photo: Photo)

    @Query("SELECT * FROM photos")
    fun getAllPhotos(): LiveData<List<Photo>>
}
