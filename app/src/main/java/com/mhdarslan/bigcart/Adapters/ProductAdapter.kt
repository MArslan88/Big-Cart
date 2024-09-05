package com.mhdarslan.bigcart.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mhdarslan.bigcart.Models.ProductModel
import com.mhdarslan.bigcart.R

class ProductAdapter(private val context: Context, private val productList: List<ProductModel>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.department_prod_item, parent, false))
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {

        val model: ProductModel = productList[position]
        holder.img.setImageResource(model.image_id)
        holder.title.text = model.product_title

        holder.itemView.setOnClickListener{
//            Toast.makeText(context, "Item Clicked!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = productList.size

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        val img = itemview.findViewById<ImageView>(R.id.img)
        val title = itemview.findViewById<TextView>(R.id.title)

    }
}