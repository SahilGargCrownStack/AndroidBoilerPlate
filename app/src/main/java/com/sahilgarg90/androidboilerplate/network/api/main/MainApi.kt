package com.sahilgarg90.androidboilerplate.network.api.main

import com.sahilgarg90.androidboilerplate.ui.main.model.MainRequest
import com.sahilgarg90.androidboilerplate.ui.main.model.MainResponse
import io.reactivex.Single

/**
 * Created by Sahil Garg on 07-03-2021.
 *
 * This interface will contain all the methods declaration used to get data from the api and will
 * pass the information back to repositories.
 */

interface MainApi {
    fun getSomeData(mainRequest: MainRequest): Single<MainResponse>
}