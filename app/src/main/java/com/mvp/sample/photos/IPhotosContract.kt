package com.mvp.sample.photos

import com.mvp.sample.base.IBaseView
import com.mvp.sample.data.Photo

interface IPhotosContract {

    interface View: IBaseView {
        fun onPhotosSuccess(photos: List<Photo>?)
        fun onPhotosFailure()
        fun showProgress()
        fun hideProgress()
    }

    interface Presenter {
        fun getPhotos()
    }
}