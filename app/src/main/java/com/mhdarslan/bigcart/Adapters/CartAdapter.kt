package com.mhdarslan.bigcart.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.mhdarslan.bigcart.Helper.CommonUtils
import com.mhdarslan.bigcart.Models.CartModel
import com.mhdarslan.bigcart.Models.ProductModel
import com.mhdarslan.bigcart.R

class CartAdapter(val context:Context, val cartModelList: List<CartModel>) :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_item, parent, false))
    }

    override fun onBindViewHolder(holder: CartAdapter.ViewHolder, position: Int) {
        val model: CartModel = cartModelList[position]
        holder.prod_name.text = model.itemName
        holder.img.setImageResource(model.itemImage)
        holder.prod_price.text = "$"+CommonUtils.formatDecimal(model.itemPrice)
        holder.prod_size.text = model.itemSize
    }

    override fun getItemCount(): Int = cartModelList.size

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val img = itemview.findViewById<ImageView>(R.id.img)

        val prod_price = itemview.findViewById<TextView>(R.id.prod_price)
        val prod_name = itemview.findViewById<TextView>(R.id.prod_name)
        val prod_size = itemview.findViewById<TextView>(R.id.prod_size)


    }
}