package com.mhdarslan.bigcart.Adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mhdarslan.bigcart.Activities.CategoriesActivity
import com.mhdarslan.bigcart.Models.CategoryModel
import com.mhdarslan.bigcart.R

class ProductCatAdapter(private val context: Context, private val categoryList: List<CategoryModel> ) :
    RecyclerView.Adapter<ProductCatAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductCatAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.department_cat_item, parent, false))
    }

    override fun onBindViewHolder(holder: ProductCatAdapter.ViewHolder, position: Int) {
        val model: CategoryModel = categoryList[position]

        holder.title.text = model.title
        holder.rv_product.layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)

        val productAdapter = ProductAdapter(context, model.productList)
        holder.rv_product.adapter = productAdapter


        holder.btn_forward.setOnClickListener{
            for (product in model.productList) {
                Log.d("Product Info", "Title: ${product.product_title}, Price: ${product.product_price}, Size: ${product.product_size}")
            }
//            context.startActivity(Intent(context, CategoriesActivity::class.java).putExtra("categoryList", ArrayList(categoryList)))
        }
    }

    override fun getItemCount(): Int = categoryList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val btn_forward = itemView.findViewById<ImageButton>(R.id.btn_forward)
        val title = itemView.findViewById<TextView>(R.id.title)
        val rv_product = itemView.findViewById<RecyclerView>(R.id.rv_product)

    }
}