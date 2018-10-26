package com.mvp.sample.data.places

import android.content.Context
import com.mvp.sample.data.Place
import com.mvp.sample.webservice.IApi
import com.mvp.sample.extensions.enqueue
import com.mvp.sample.webservice.WebService
import java.lang.UnsupportedOperationException

class PlacesRemoteDataSource : IPlacesDataSource {

    override fun savePlaces(places: List<Place>) = throw UnsupportedOperationException()

    override fun getPlaces(context: Context, listener: PlacesRepository.IPlacesListener) {
        val service = WebService.createService(context, IApi::class.java)
        val call = service.getPlaces()
        call.enqueue(
                { response ->
                    if (response.isSuccessful) {
                        listener.onPlacesSuccess(response.body())

                    } else {
                        listener.onPlacesFailure()
                    }
                },
                {
                    listener.onNetworkError()
                }
        )
    }

}