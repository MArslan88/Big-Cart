package com.mhdarslan.bigcart.Models

class CartModel {
    var id: String = ""
    var itemImage: Int = 0
    var itemName: String = ""
    var itemPrice: Double = 0.0
    var itemSize: String = ""

    constructor()

    constructor(id: String, itemImage: Int, itemName: String, itemPrice: Double, itemSize: String){
        this.id = id
        this.itemImage = itemImage
        this.itemName = itemName
        this.itemPrice = itemPrice
        this.itemSize = itemSize

    }

}