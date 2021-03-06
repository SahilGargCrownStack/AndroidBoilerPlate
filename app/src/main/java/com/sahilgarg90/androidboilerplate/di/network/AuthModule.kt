package com.sahilgarg90.androidboilerplate.di.network

import com.google.gson.Gson
import com.sahilgarg90.androidboilerplate.network.JSONArrayAdapter
import com.sahilgarg90.androidboilerplate.network.JSONObjectAdapter
import com.sahilgarg90.androidboilerplate.ui.auth.AuthNetworkAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Sahil Garg on 06-03-2021.
 */

@Module
class AuthModule {

    @Provides
    @Singleton
    fun provideAuthNetworkAPI(client: OkHttpClient, gson: Gson): AuthNetworkAPI {
        val updatedGson = gson.newBuilder().setLenient()
            .registerTypeAdapter(JSONObject::class.java, JSONObjectAdapter.sInstance)
            .registerTypeAdapter(JSONArray::class.java, JSONArrayAdapter.sInstance)
            .create()

        return Retrofit.Builder()
            .baseUrl("")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(updatedGson))
            .build().create(AuthNetworkAPI::class.java)
    }
}