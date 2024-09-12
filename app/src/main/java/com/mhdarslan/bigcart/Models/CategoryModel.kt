package com.mhdarslan.bigcart.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryModel(val title: String, val productList: List<ProductModel>) : Parcelable
