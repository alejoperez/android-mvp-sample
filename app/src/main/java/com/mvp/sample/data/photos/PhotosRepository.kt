package com.mvp.sample.data.photos

import android.content.Context
import com.mvp.sample.data.IBaseSourceListener
import com.mvp.sample.data.Photo

class PhotosRepository private constructor(
        private val localDataSource: IPhotosDataSource = PhotosLocalDataSource(),
        private val remoteDataSource: IPhotosDataSource = PhotosRemoteDataSource()) : IPhotosDataSource {


    private var hasCache = false

    companion object {
        @Volatile
        private var INSTANCE: PhotosRepository? = null

        fun getInstance(): PhotosRepository = INSTANCE ?: synchronized(this) {
            INSTANCE ?: PhotosRepository().also { INSTANCE = it }
        }
    }

    override fun getPhotos(context: Context, listener: IPhotosListener) {
        if (hasCache) {
            localDataSource.getPhotos(context, listener)
        } else {
            remoteDataSource.getPhotos(context, object : IPhotosListener{

                override fun onPhotosSuccess(photos: List<Photo>?) {
                    if (photos != null) {
                        savePhotos(photos)
                        listener.onPhotosSuccess(photos)
                    } else {
                        listener.onPhotosFailure()
                    }
                    listener.onPhotosSuccess(photos)
                }

                override fun onPhotosFailure() = listener.onPhotosFailure()

                override fun onNetworkError() = listener.onNetworkError()
            })
        }
    }

    override fun savePhotos(photos: List<Photo>) {
        localDataSource.savePhotos(photos)
    }

    fun invalidateCache() {
        hasCache = false
    }


    interface IPhotosListener : IBaseSourceListener {
        fun onPhotosSuccess(photos: List<Photo>?)
        fun onPhotosFailure()
    }
}