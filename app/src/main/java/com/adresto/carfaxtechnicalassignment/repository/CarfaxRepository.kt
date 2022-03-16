package com.adresto.carfaxtechnicalassignment.repository

import com.adresto.carfaxtechnicalassignment.api.service.ListingService
import com.adresto.carfaxtechnicalassignment.db.dao.ListingDao
import com.adresto.carfaxtechnicalassignment.model.Listing
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CarfaxRepository(
    private val listingService: ListingService,
    private val listingDao: ListingDao
) {
    private val disposables: CompositeDisposable = CompositeDisposable()

    init {
        fetchAllListings()
    }

    fun getAllListings(): Flowable<List<Listing>> = listingDao.getAllListings()

    private fun fetchAllListings() {
        disposables.add(
            listingService
                .fetchListings()
                .retry()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe({ listingDao.insertListings(it.listings) }, { it.printStackTrace() })
        )
    }

    fun dispose() = disposables.dispose()

}