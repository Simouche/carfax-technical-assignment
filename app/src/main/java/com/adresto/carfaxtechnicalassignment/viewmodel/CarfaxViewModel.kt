package com.adresto.carfaxtechnicalassignment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.adresto.carfaxtechnicalassignment.api.client.RetrofitClient
import com.adresto.carfaxtechnicalassignment.db.CarFaxDB
import com.adresto.carfaxtechnicalassignment.model.Listing
import com.adresto.carfaxtechnicalassignment.repository.CarfaxRepository
import com.adresto.carfaxtechnicalassignment.utils.Resource
import com.adresto.carfaxtechnicalassignment.utils.ResourceState
import com.adresto.carfaxtechnicalassignment.utils.setLoading
import com.adresto.carfaxtechnicalassignment.utils.setSuccess
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CarfaxViewModel(application: Application) : AndroidViewModel(application)
{

    var carfaxRepository: CarfaxRepository = CarfaxRepository(
        RetrofitClient.listingService,
        CarFaxDB.getDb(getApplication()).listingDao()
    )

    private val disposables: CompositeDisposable = CompositeDisposable()

    private val _listings: MutableLiveData<Resource<List<Listing>>> = MutableLiveData(
        Resource(
            ResourceState.LOADING
        )
    )
    val listings: LiveData<Resource<List<Listing>>> = _listings

    fun loadListings() {
        disposables.add(carfaxRepository.getAllListings()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _listings.setLoading() }
            .doOnError { it.printStackTrace() }
            .subscribe { _listings.setSuccess(it) })
    }

    override fun onCleared() {
        carfaxRepository.dispose()
        disposables.dispose()
        super.onCleared()
    }

}