package com.mvp.sample.places

import com.mvp.sample.base.IBaseView
import com.mvp.sample.data.Place

interface IPlacesContract {

    interface View: IBaseView {
        fun onPlacesSuccess(places: List<Place>?)
        fun onPlacesFailure()
    }

    interface Presenter {
        fun getPlaces()
    }
}