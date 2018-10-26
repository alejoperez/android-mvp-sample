package com.mvp.sample.data.photos

import android.content.Context
import com.mvp.sample.data.Photo
import io.realm.Realm

class PhotosLocalDataSource: IPhotosDataSource {

    override fun savePhotos(photos: List<Photo>) {
        Realm.getDefaultInstance().executeTransactionAsync {
            realm -> realm.insertOrUpdate(photos)
        }
    }

    override fun getPhotos(context: Context, listener: PhotosRepository.IPhotosListener) {
        listener.onPhotosSuccess(Realm.getDefaultInstance().where(Photo::class.java).findAll())
    }

}