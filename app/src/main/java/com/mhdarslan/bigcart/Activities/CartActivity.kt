package com.mhdarslan.bigcart.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mhdarslan.bigcart.Adapters.CartAdapter
import com.mhdarslan.bigcart.DBUtils.DbHandler
import com.mhdarslan.bigcart.Helper.CommonUtils
import com.mhdarslan.bigcart.Models.CartModel
import com.mhdarslan.bigcart.R

class CartActivity : AppCompatActivity() {
    private lateinit var rv_cart: RecyclerView
    private lateinit var tv_subtotal: TextView
    private lateinit var tv_shipping: TextView
    private lateinit var tv_total: TextView
    private lateinit var dbHandler: DbHandler
    private var subtotal : Double = 0.0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        dbHandler = DbHandler(this)

        rv_cart = findViewById(R.id.rv_cart)
        tv_subtotal = findViewById(R.id.tv_subtotal)
        tv_shipping = findViewById(R.id.tv_shipping)
        tv_total = findViewById(R.id.tv_total)
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

        cartModelList.forEach {
            subtotal += it.itemPrice
        }

        tv_subtotal.text = "$"+CommonUtils.formatDecimal(subtotal)
        val total = subtotal + 1.6
        tv_total.text = "$"+CommonUtils.formatDecimal(total)

    }
}