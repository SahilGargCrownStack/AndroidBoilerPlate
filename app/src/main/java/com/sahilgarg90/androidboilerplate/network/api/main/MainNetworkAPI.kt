package com.sahilgarg90.androidboilerplate.network.api.main

import com.sahilgarg90.androidboilerplate.ui.main.model.MainResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Sahil Garg on 07-03-2021.
 */

interface MainNetworkAPI {

    @GET("<API Endpoint>")
    fun getSomeData(@Query("id") id: String): Single<Response<MainResponse>>
}