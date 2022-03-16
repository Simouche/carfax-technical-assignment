package com.adresto.carfaxtechnicalassignment.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2022 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class Dealer(

    @ColumnInfo() @SerializedName("address") val address: String?,
    @ColumnInfo(name = "d_backfill") @SerializedName("backfill") val backfill: Boolean?,
    @ColumnInfo(name="d_carfaxId") @SerializedName("carfaxId") val carfaxId: String?,
    @ColumnInfo(name="d_cfxMicrositeUrl") @SerializedName("cfxMicrositeUrl") val cfxMicrositeUrl: String?,
    @ColumnInfo(name="d_city") @SerializedName("city") val city: String?,
    @ColumnInfo(name="d_dealerAverageRating") @SerializedName("dealerAverageRating") val dealerAverageRating: Double?,
    @ColumnInfo(name="d_dealerInventoryUrl") @SerializedName("dealerInventoryUrl") val dealerInventoryUrl: String?,
    @ColumnInfo(name="d_dealerLeadType") @SerializedName("dealerLeadType") val dealerLeadType: String?,
    @ColumnInfo(name="d_dealerReviewComments") @SerializedName("dealerReviewComments") val dealerReviewComments: String?,
    @ColumnInfo(name="d_dealerReviewCount") @SerializedName("dealerReviewCount") val dealerReviewCount: Int?,
    @ColumnInfo(name="d_dealerReviewDate") @SerializedName("dealerReviewDate") val dealerReviewDate: String?,
    @ColumnInfo(name="d_dealerReviewRating") @SerializedName("dealerReviewRating") val dealerReviewRating: Int?,
    @ColumnInfo(name="d_dealerReviewReviewer") @SerializedName("dealerReviewReviewer") val dealerReviewReviewer: String?,
    @ColumnInfo(name="d_dealerReviewTitle") @SerializedName("dealerReviewTitle") val dealerReviewTitle: String?,
    @ColumnInfo(name="d_latitude") @SerializedName("latitude") val latitude: Double?,
    @ColumnInfo(name="d_longitude") @SerializedName("longitude") val longitude: Double?,
    @ColumnInfo(name="d_name") @SerializedName("name") val name: String?,
    @ColumnInfo(name="d_onlineOnly") @SerializedName("onlineOnly") val onlineOnly: Boolean?,
    @ColumnInfo(name="d_phone") @SerializedName("phone") val phone: String?,
    @ColumnInfo(name="d_state") @SerializedName("state") val state: String?,
    @ColumnInfo(name="d_zip") @SerializedName("zip") val zip: String?
)