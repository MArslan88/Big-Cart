package com.mhdarslan.bigcart.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mhdarslan.bigcart.Adapters.DepartmentCatAdapter
import com.mhdarslan.bigcart.Adapters.ProductCatAdapter
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
        rv_featured.layoutManager = LinearLayoutManager(requireContext())

        departments()
        products()



        return view
    }

    private fun products() {
        val productCatList: List<CategoryModel> = productsData()
        val productCatAdapter = ProductCatAdapter(requireContext(), productCatList)
        rv_featured.adapter = productCatAdapter
    }

    private fun productsData(): List<CategoryModel> {
        val productCatList = mutableListOf<CategoryModel>()
        val productsList = mutableListOf<ProductModel>()

        // product list
        productsList.add(ProductModel("Fresh Peach", R.drawable.product_1, 8.00, "dozen"))
        productsList.add(ProductModel("Avacoda", R.drawable.product_2, 7.00, "2.0 lbs"))
        productsList.add(ProductModel("Pineapple", R.drawable.product_3, 9.90, "1.50 lbs"))
        productsList.add(ProductModel("Black Grapes", R.drawable.product_4, 7.50, "5.0 lbs"))
        productsList.add(ProductModel("Pomegranate", R.drawable.product_5, 2.09, "1.50 lbs"))
        productsList.add(ProductModel("Fresh B roccoli", R.drawable.product_6, 3.00, "1 kg"))

        // category list
        productCatList.add(CategoryModel("Featured products", productsList))

        return productCatList

    }

    private fun departments() {
        val departmentList: List<CategoryModel> = departmentData()
        val departmentCatAdapter = DepartmentCatAdapter(requireContext(), departmentList)
        rv_department.adapter = departmentCatAdapter
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