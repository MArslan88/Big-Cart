package com.mhdarslan.bigcart.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.mhdarslan.bigcart.DBUtils.DbHandler
import com.mhdarslan.bigcart.Fragments.HomeFragment
import com.mhdarslan.bigcart.R

class MainActivity : AppCompatActivity() {
//    private lateinit var navController: NavController
    private lateinit var home_btn : ImageView
    private lateinit var user_btn : ImageView
    private lateinit var like_btn : ImageView
    private lateinit var cart_btn : ImageView
    private lateinit var homeFragment: HomeFragment
    private lateinit var dbHandler: DbHandler

    private var currentFragmentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        navController = findNavController(this, R.id.nav_host_fragment_content_home_page)
//        navController.navigate(R.id.homeFragment)

        dbHandler = DbHandler(this)
        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, homeFragment).commit()

        home_btn = findViewById<ImageView>(R.id.home_btn)
        user_btn = findViewById<ImageView>(R.id.user_btn)
        like_btn = findViewById<ImageView>(R.id.like_btn)
        cart_btn = findViewById<ImageView>(R.id.cart_btn)

        dbHandler.deleteCart()

        navClickListeners();


    }

    private fun navClickListeners() {

        home_btn.setOnClickListener {
//            navController.navigate(R.id.homeFragment)
            supportFragmentManager.beginTransaction().replace(R.id.container, homeFragment).commit()

            currentFragmentIndex = 0
            home_btn.setImageResource(R.drawable.nav_home_active)
            user_btn.setImageResource(R.drawable.nav_user)
            like_btn.setImageResource(R.drawable.nav_like)
            cart_btn.setImageResource(R.drawable.nav_cart)
        }

        user_btn.setOnClickListener {
//            navController.navigate(R.id.homeFragment)

            currentFragmentIndex = 1
            home_btn.setImageResource(R.drawable.nav_home)
            user_btn.setImageResource(R.drawable.nav_user_active)
            like_btn.setImageResource(R.drawable.nav_like)
            cart_btn.setImageResource(R.drawable.nav_cart)
        }

        like_btn.setOnClickListener {
//            navController.navigate(R.id.homeFragment)

            currentFragmentIndex = 2
            home_btn.setImageResource(R.drawable.nav_home)
            user_btn.setImageResource(R.drawable.nav_user)
            like_btn.setImageResource(R.drawable.nav_like_active)
            cart_btn.setImageResource(R.drawable.nav_cart)
        }

        cart_btn.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))

//            currentFragmentIndex = 3
//            home_btn.setImageResource(R.drawable.nav_home)
//            user_btn.setImageResource(R.drawable.nav_user)
//            like_btn.setImageResource(R.drawable.nav_like)
//            cart_btn.setImageResource(R.drawable.nav_cart_active)
        }
    }

    override fun onBackPressed() {
        if (currentFragmentIndex != 0) {
            // If we are on the second or third fragment, go back to the first fragment
//            navController.navigate(R.id.homeFragment)
            supportFragmentManager.beginTransaction().replace(R.id.container, homeFragment).commit()

            currentFragmentIndex = 0
            home_btn.setImageResource(R.drawable.nav_home_active)
            user_btn.setImageResource(R.drawable.nav_user)
            like_btn.setImageResource(R.drawable.nav_like)
            cart_btn.setImageResource(R.drawable.nav_cart)
        } else {
            // If we are on the first fragment or the app is already closing, close the app
            super.onBackPressed()
        }
    }
}