package com.mhdarslan.bigcart.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mhdarslan.bigcart.Adapters.CartAdapter
import com.mhdarslan.bigcart.DBUtils.DbHandler
import com.mhdarslan.bigcart.Models.CartModel
import com.mhdarslan.bigcart.R

class CartActivity : AppCompatActivity() {
    private lateinit var rv_cart: RecyclerView
    private lateinit var dbHandler: DbHandler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        dbHandler = DbHandler(this)

        rv_cart = findViewById(R.id.rv_cart)
        val btn_back: ImageButton = findViewById(R.id.btn_back)

        btn_back.setOnClickListener {
            finish()
        }

        rv_cart.layoutManager = LinearLayoutManager(this)

        cartItems()
    }

    private fun cartItems() {
        val cartModelList: List<CartModel> =  dbHandler.cartItems
        val cartAdapter = CartAdapter(this, cartModelList)
        rv_cart.adapter = cartAdapter

    }
}