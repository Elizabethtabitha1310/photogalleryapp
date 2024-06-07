package com.example.photogalleryapp.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.photogalleryapp.entities.Album

@Dao
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(album: Album)

    @Update
    suspend fun update(album: Album)

    @Delete
    suspend fun delete(album: Album)

    @Query("SELECT * FROM albums")
    fun getAllAlbums(): LiveData<List<Album>>
}
