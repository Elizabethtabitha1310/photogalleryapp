package com.example.photogalleryapp

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.photogalleryapp.entities.Photo
import com.example.photogalleryapp.viewModel.PhotoViewModel
import com.example.photogalleryapp.viewModel.PhotoViewModelFactory

class AddPhotoFragment : AppCompatActivity() {

    private val photoViewModel: PhotoViewModel by viewModels {
        PhotoViewModelFactory((application as PhotoGalleryApplication).photoRepository)
    }

    private var selectedImageUri: Uri? = null

    private val pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            selectedImageUri = it
            photoImageView.setImageURI(it)
        }
    }

    private lateinit var photoImageView: ImageView
    private lateinit var photoTitleEditText: EditText
    private lateinit var photoDescriptionEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_add_photo)

        photoImageView = findViewById(R.id.photoImageView)
        photoTitleEditText = findViewById(R.id.photoTitleEditText)
        photoDescriptionEditText = findViewById(R.id.photoDescriptionEditText)
        saveButton = findViewById(R.id.saveButton)

        photoImageView.setOnClickListener {
            pickImageLauncher.launch("image/*")
        }

        saveButton.setOnClickListener {
            val title = photoTitleEditText.text.toString()
            val description = photoDescriptionEditText.text.toString()
            val imagePath = selectedImageUri.toString()

            val photo = Photo(title = title, description = description, imagePath = imagePath)
            photoViewModel.insert(photo)
            finish()
        }
    }
}
