package com.mhdarslan.bigcart.Models

class ProductModel {
    var product_title: String = ""
    var image_id: Int = 0
    var product_price: Double = 0.00
    var product_size: String =""

    constructor(product_title: String, image_id: Int){
        this.product_title = product_title
        this.image_id = image_id
    }

    constructor(product_title: String, image_id: Int, product_price: Double, product_size: String){
        this.product_title = product_title
        this.image_id = image_id
        this.product_price = product_price
        this.product_size = product_size

    }
}