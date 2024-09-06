package com.mhdarslan.bigcart.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.mhdarslan.bigcart.Helper.CommonUtils
import com.mhdarslan.bigcart.Models.ProductModel
import com.mhdarslan.bigcart.R

class ProductAdapter(private val context: Context, private val productList: List<ProductModel>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.product_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        val model: ProductModel = productList[position]
        holder.prod_name.text = model.product_title
        holder.prod_img.setImageResource(model.image_id)
        holder.prod_price.text = CommonUtils.formatDecimal(model.product_price)
        holder.prod_size.text = model.product_size

        holder.itemView.setOnClickListener{
//            Toast.makeText(context, "Item Clicked!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = productList.size

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        val prod_img = itemview.findViewById<ImageView>(R.id.prod_img)
        val btn_like = itemview.findViewById<ImageButton>(R.id.btn_like)

        val prod_price = itemview.findViewById<TextView>(R.id.prod_price)
        val prod_name = itemview.findViewById<TextView>(R.id.prod_name)
        val prod_size = itemview.findViewById<TextView>(R.id.prod_size)

        val cns_add_cart = itemview.findViewById<ConstraintLayout>(R.id.cns_add_cart)

    }
}