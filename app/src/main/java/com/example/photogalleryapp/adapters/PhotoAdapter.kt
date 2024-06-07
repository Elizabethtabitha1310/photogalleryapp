package com.example.photogalleryapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.photogalleryapp.R
import com.example.photogalleryapp.entities.Photo

class PhotoAdapter(
    private var photos: List<Photo>,
    private val onPhotoClick: (Photo) -> Unit
) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    override fun getItemCount(): Int = photos.size

    fun updateData(newPhotos: List<Photo>) {
        photos = newPhotos
        notifyDataSetChanged()
    }
    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val photoImageView: ImageView = itemView.findViewById(R.id.photoImageView)
        private val photoTitle: TextView = itemView.findViewById(R.id.photoTitle)
        private val photoDescription: TextView = itemView.findViewById(R.id.photoDescription)

        fun bind(photo: Photo) {
            photoTitle.text = photo.title
            photoDescription.text = photo.description
            Glide.with(itemView.context).load(photo.imagePath).into(photoImageView)
            itemView.setOnClickListener { onPhotoClick(photo) }
        }
    }
}
