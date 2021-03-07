package com.sahilgarg90.androidboilerplate.network.api.main

import com.sahilgarg90.androidboilerplate.ui.main.model.MainRequest
import com.sahilgarg90.androidboilerplate.ui.main.model.MainResponse
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Sahil Garg on 07-03-2021.
 *
 * This interface will contain all the methods definitions used to get data from the api and will
 * pass the processed information back to repositories.
 */

class MainApiImpl @Inject constructor(private val mainNetworkAPI: MainNetworkAPI) : MainApi {

    override fun getSomeData(mainRequest: MainRequest): Single<MainResponse> {
        return Single.just(mainRequest).flatMap { request ->
            mainNetworkAPI.getSomeData(request.id)
        }.map { response ->
            // Here we can process the response received from the api before returning it.
            response.body()
        }
    }

}