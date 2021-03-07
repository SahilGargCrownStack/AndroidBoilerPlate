package com.sahilgarg90.androidboilerplate.ui.main.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sahilgarg90.androidboilerplate.ui.main.MainRepository
import com.sahilgarg90.androidboilerplate.ui.main.model.MainRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Sahil Garg on 06-03-2021.
 */

class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val context: Context
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    val someData by lazy { MutableLiveData<String>() }

    fun getSomeData() {
        val disposable = mainRepository.getSomeData(MainRequest("<Sample Id>"))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                // Use this space to play around with the response
                it.data
            }
            .subscribe({ data ->
                // Receives final response
                someData.postValue(data)
            }, {
                // Receives Error Exception
            })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}