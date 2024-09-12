package com.mhdarslan.bigcart.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mhdarslan.bigcart.Adapters.DepartmentAdapter
import com.mhdarslan.bigcart.Adapters.DepartmentCatAdapter
import com.mhdarslan.bigcart.Models.CategoryModel
import com.mhdarslan.bigcart.R

class CategoriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        val btn_back = findViewById<ImageButton>(R.id.btn_back)
        val btn_option = findViewById<ImageButton>(R.id.btn_option)
        val rv_categories = findViewById<RecyclerView>(R.id.rv_categories)

        rv_categories.layoutManager = GridLayoutManager(this, 3, RecyclerView.VERTICAL, false)

        // get intent data
        val categoryList = intent.getSerializableExtra("categoryList") as? ArrayList<CategoryModel>

        // set intent data
        if (categoryList != null) {
            Log.d("List", categoryList[0].toString()) // problem

            val departmentAdapter = DepartmentAdapter(this, categoryList[0].productList)
            rv_categories.adapter = departmentAdapter



        }

        btn_back.setOnClickListener{
            finish()
        }
    }
}