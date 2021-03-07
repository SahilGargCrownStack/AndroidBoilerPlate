package com.sahilgarg90.androidboilerplate.ui.main

import com.sahilgarg90.androidboilerplate.network.api.main.MainApiImpl
import com.sahilgarg90.androidboilerplate.ui.main.model.MainRequest
import com.sahilgarg90.androidboilerplate.ui.main.model.MainResponse
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Sahil Garg on 07-03-2021.
 *
 * This is a repository class used to fetch information from api and return the response to viewModels.
 */

class MainRepository @Inject constructor(private val mainApi: MainApiImpl) {

    fun getSomeData(mainRequest: MainRequest): Single<MainResponse> {
        return mainApi.getSomeData(mainRequest)
    }

}