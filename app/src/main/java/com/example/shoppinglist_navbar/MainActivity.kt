package com.example.shoppinglist_navbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var addItemFragment = AddItemFragment()
    private var listItemFragment = ListItemFragment()
    private var homeFragment = HomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.nav_add -> replaceFragment(addItemFragment)
                R.id.nav_home -> replaceFragment(homeFragment)
                R.id.nav_list -> replaceFragment(listItemFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment, fragment)
            transaction.commit()
        }
    }
}