package com.mhdarslan.bigcart.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mhdarslan.bigcart.Adapters.DepartmentCatAdapter
import com.mhdarslan.bigcart.Models.CategoryModel
import com.mhdarslan.bigcart.Models.ProductModel
import com.mhdarslan.bigcart.R

class HomeFragment : Fragment() {
    private lateinit var rv_department: RecyclerView
    private lateinit var rv_featured: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        rv_department = view.findViewById(R.id.rv_department)
        rv_featured = view.findViewById(R.id.rv_featured)


        rv_department.layoutManager = LinearLayoutManager(requireContext())


        val departmentList: List<CategoryModel> = departmentData()
        val departmentCatAdapter = DepartmentCatAdapter(requireContext(), departmentList)
        rv_department.adapter = departmentCatAdapter



        return view
    }

    private fun departmentData(): List<CategoryModel> {
        val departCatList = mutableListOf<CategoryModel>()
        val departList = mutableListOf<ProductModel>()

        // product list
        departList.add(ProductModel("Vegetables", R.drawable.department_1))
        departList.add(ProductModel("Fruits", R.drawable.department_2))
        departList.add(ProductModel("Beverages", R.drawable.department_3))
        departList.add(ProductModel("Grocery", R.drawable.department_4))
        departList.add(ProductModel("Edible oil", R.drawable.department_5))
        departList.add(ProductModel("Household", R.drawable.department_6))
        departList.add(ProductModel("Babycare", R.drawable.department_7))

        // category list
        departCatList.add(CategoryModel("Category", departList))

        return departCatList
    }

}