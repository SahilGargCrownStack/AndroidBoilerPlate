package com.sahilgarg90.androidboilerplate.network.api.main

import com.sahilgarg90.androidboilerplate.ui.main.model.MainRequest
import com.sahilgarg90.androidboilerplate.ui.main.model.MainResponse
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Sahil Garg on 07-03-2021.
 */

class MainApiImpl @Inject constructor(private val mainNetworkAPI: MainNetworkAPI) : MainApi {

    override fun getSomeData(mainRequest: MainRequest): Single<MainResponse> {
        return Single.just(mainRequest).flatMap { request ->
            mainNetworkAPI.getSomeData(request.id)
        }.map { response ->
            response.body()
        }
    }

}