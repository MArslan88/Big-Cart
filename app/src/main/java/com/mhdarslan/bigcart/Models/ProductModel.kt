package com.mhdarslan.bigcart.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class ProductModel(
    var product_title: String = "",
    var image_id: Int = 0,
    var product_price: Double = 0.00,
    var product_size: String = ""
) : Parcelable