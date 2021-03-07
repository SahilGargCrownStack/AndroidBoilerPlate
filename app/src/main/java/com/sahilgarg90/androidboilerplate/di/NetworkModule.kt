package com.sahilgarg90.androidboilerplate.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import com.sahilgarg90.androidboilerplate.network.CommonHeadersInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Sahil Garg on 06-03-2021.
 *
 * This class is dagger module and is used to get Reference of the all the instances related to
 * network api calls.
 */

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun providesChuckInterceptor(context: Context): ChuckInterceptor {
        return ChuckInterceptor(context)
    }

    @Provides
    @Singleton
    fun provideOkHttpsClient(
        commonHeadersInterceptor: CommonHeadersInterceptor,
        chuckInterceptor: ChuckInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder().apply {
            addInterceptor(commonHeadersInterceptor)
            addInterceptor(chuckInterceptor)
            readTimeout(30L, TimeUnit.SECONDS)
            connectTimeout(30L, TimeUnit.SECONDS)
            writeTimeout(30L, TimeUnit.SECONDS)
        }
        return builder.build()
    }

}