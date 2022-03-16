package com.adresto.carfaxtechnicalassignment.api.service

import com.adresto.carfaxtechnicalassignment.api.response.Response
import io.reactivex.Single
import retrofit2.http.GET

interface ListingService {

    @GET("assignment.json")
    fun fetchListings(): Single<Response>
}