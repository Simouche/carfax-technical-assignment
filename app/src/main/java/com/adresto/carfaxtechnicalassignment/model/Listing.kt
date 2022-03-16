package com.adresto.carfaxtechnicalassignment.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class Listing(
    @SerializedName("id") @PrimaryKey @ColumnInfo() val id: String,
    @SerializedName("accidentHistory") @Embedded val accidentHistory: AccidentHistory?,
    @SerializedName("advantage") @ColumnInfo() val advantage: Boolean?,
    @SerializedName("atomOtherOptions") @ColumnInfo() val atomOtherOptions: List<String>?,
    @SerializedName("atomTopOptions") @ColumnInfo() val atomTopOptions: List<String>?,
    @SerializedName("backfill") @ColumnInfo() val backfill: Boolean?,
    @SerializedName("badge") @ColumnInfo() val badge: String??,
    @SerializedName("bedLength") @ColumnInfo() val bedLength: String?,
    @SerializedName("bodytype") @ColumnInfo() val bodytype: String?,
    @SerializedName("cabType") @ColumnInfo() val cabType: String?,
    @SerializedName("certified") @ColumnInfo() val certified: Boolean?,
    @SerializedName("currentPrice") @ColumnInfo() val currentPrice: Int?,
    @SerializedName("dealer") @Embedded val dealer: Dealer?,
    @SerializedName("dealerType") @ColumnInfo() val dealerType: String?,
    @SerializedName("displacement") @ColumnInfo() val displacement: String?,
    @SerializedName("distanceToDealer") @ColumnInfo() val distanceToDealer: Double?,
    @SerializedName("drivetype") @ColumnInfo() val drivetype: String?,
    @SerializedName("engine") @ColumnInfo() val engine: String?,
    @SerializedName("exteriorColor") @ColumnInfo() val exteriorColor: String?,
    @SerializedName("firstSeen") @ColumnInfo() val firstSeen: String?,
    @SerializedName("followCount") @ColumnInfo() val followCount: Int?,
    @SerializedName("followedAt") @ColumnInfo() val followedAt: Long?,
    @SerializedName("following") @ColumnInfo() val following: Boolean?,
    @SerializedName("fuel") @ColumnInfo() val fuel: String?,
    @SerializedName("hasViewed") @ColumnInfo() val hasViewed: Boolean?,
    @SerializedName("imageCount") @ColumnInfo() val imageCount: Int?,
    @SerializedName("images") @Embedded val images: Images?,
    @SerializedName("interiorColor") @ColumnInfo() val interiorColor: String?,
    @SerializedName("isEnriched") @ColumnInfo() val isEnriched: Boolean?,
    @SerializedName("isOemPromoted") @ColumnInfo() val isOemPromoted: Boolean?,
    @SerializedName("isOemRefundFlag") @ColumnInfo() val isOemRefundFlag: Boolean?,
    @SerializedName("listPrice") @ColumnInfo() val listPrice: Int?,
    @SerializedName("make") @ColumnInfo() val make: String?,
    @SerializedName("mileage") @ColumnInfo() val mileage: Int?,
    @SerializedName("model") @ColumnInfo() val model: String?,
    @SerializedName("monthlyPaymentEstimate") @Embedded val monthlyPaymentEstimate: MonthlyPaymentEstimate?,
    @SerializedName("mpgCity") @ColumnInfo() val mpgCity: Int?,
    @SerializedName("mpgHighway") @ColumnInfo() val mpgHighway: Int?,
    @SerializedName("noAccidents") @ColumnInfo() val noAccidents: Boolean?,
    @SerializedName("oneOwner") @ColumnInfo() val oneOwner: Boolean?,
    @SerializedName("onePrice") @ColumnInfo() val onePrice: Int?,
//    @SerializedName("onePriceArrows") @ColumnInfo() val onePriceArrows: List<OnePriceArrows>?,
    @SerializedName("onlineOnly") @ColumnInfo() val onlineOnly: Boolean?,
    @SerializedName("ownerHistory") @Embedded val ownerHistory: OwnerHistory?,
    @SerializedName("personalUse") @ColumnInfo() val personalUse: Boolean?,
    @SerializedName("placed") @ColumnInfo() val placed: Boolean?,
    @SerializedName("recordType") @ColumnInfo() val recordType: String?,
    @SerializedName("sentLead") @ColumnInfo() val sentLead: Boolean?,
    @SerializedName("serviceHistory") @Embedded val serviceHistory: ServiceHistory?,
    @SerializedName("serviceRecords") @ColumnInfo() val serviceRecords: Boolean?,
    @SerializedName("sortScore") @ColumnInfo() val sortScore: Double?,
    @SerializedName("stockNumber") @ColumnInfo() val stockNumber: String?,
    @SerializedName("subTrim") @ColumnInfo() val subTrim: String?,
    @SerializedName("topOptions") @ColumnInfo() val topOptions: List<String>?,
    @SerializedName("tpCostPerVdp") @ColumnInfo() val tpCostPerVdp: Double?,
    @SerializedName("tpEligible") @ColumnInfo() val tpEligible: Boolean?,
    @SerializedName("transmission") @ColumnInfo() val transmission: String?,
    @SerializedName("trim") @ColumnInfo() val trim: String?,
    @SerializedName("vdpUrl") @ColumnInfo() val vdpUrl: String?,
    @SerializedName("vehicleCondition") @ColumnInfo() val vehicleCondition: String?,
    @SerializedName("vehicleUseHistory") @Embedded val vehicleUseHistory: VehicleUseHistory?,
    @SerializedName("vin") @ColumnInfo() val vin: String?,
    @SerializedName("windowSticker") @ColumnInfo() val windowSticker: String?,
    @SerializedName("year") @ColumnInfo() val year: Int?
) : Serializable {
    fun getFullName(): String = "$year $make $model $trim"
}