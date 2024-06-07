package com.example.photogalleryapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photogalleryapp.adapters.AlbumAdapter
import com.example.photogalleryapp.adapters.PhotoAdapter
import com.example.photogalleryapp.viewModel.AlbumViewModel
import com.example.photogalleryapp.viewModel.AlbumViewModelFactory
import com.example.photogalleryapp.viewModel.PhotoViewModel
import com.example.photogalleryapp.viewModel.PhotoViewModelFactory

class MainActivity : AppCompatActivity() {

    private val photoViewModel: PhotoViewModel by viewModels {
        PhotoViewModelFactory((application as PhotoGalleryApplication).photoRepository)
    }

    private val albumViewModel: AlbumViewModel by viewModels {
        AlbumViewModelFactory((application as PhotoGalleryApplication).albumRepository)
    }
    private lateinit var photoRecyclerView: RecyclerView
    private lateinit var albumRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        photoRecyclerView = findViewById(R.id.photoRecyclerView)
        albumRecyclerView = findViewById(R.id.albumRecyclerView)

        val photoAdapter = PhotoAdapter(emptyList()) { photo ->
            // Handle photo click
        }

        val albumAdapter = AlbumAdapter(emptyList()) { album ->
            // Handle album click
        }

        photoRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = photoAdapter
        }

        albumRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = albumAdapter
        }

        photoViewModel.allPhotos.observe(this) { photos ->
            photos?.let { photoAdapter.updateData(it) }
        }

        albumViewModel.allAlbums.observe(this) { albums ->
            albums?.let { albumAdapter.updateData(it) }
        }
    }
}
