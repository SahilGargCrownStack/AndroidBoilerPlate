package com.sahilgarg90.androidboilerplate.network.api.main

import com.sahilgarg90.androidboilerplate.ui.main.model.MainRequest
import com.sahilgarg90.androidboilerplate.ui.main.model.MainResponse
import io.reactivex.Single

/**
 * Created by Sahil Garg on 07-03-2021.
 */

interface MainApi {
    fun getSomeData(mainRequest: MainRequest): Single<MainResponse>
}