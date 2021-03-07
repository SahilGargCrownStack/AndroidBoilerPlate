package com.sahilgarg90.androidboilerplate.di.network

import com.google.gson.Gson
import com.sahilgarg90.androidboilerplate.BuildConfig
import com.sahilgarg90.androidboilerplate.network.JSONArrayAdapter
import com.sahilgarg90.androidboilerplate.network.JSONObjectAdapter
import com.sahilgarg90.androidboilerplate.network.api.main.MainNetworkAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Sahil Garg on 07-03-2021.
 *
 * This class is dagger module and is used to get Reference of the 'Main' screens related network
 * call apis interface.
 */

@Module
class MainModule {

    @Provides
    @Singleton
    fun provideMainNetworkAPI(client: OkHttpClient, gson: Gson): MainNetworkAPI {
        val updatedGson = gson.newBuilder().setLenient()
            .registerTypeAdapter(JSONObject::class.java, JSONObjectAdapter.sInstance)
            .registerTypeAdapter(JSONArray::class.java, JSONArrayAdapter.sInstance)
            .create()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.URLS_MAP[BuildConfig.BASE_URL] ?: "")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(updatedGson))
            .build().create(MainNetworkAPI::class.java)
    }
}