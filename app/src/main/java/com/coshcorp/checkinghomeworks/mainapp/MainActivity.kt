package com.coshcorp.checkinghomeworks.mainapp

import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.coshcorp.checkinghomeworks.R
import com.coshcorp.checkinghomeworks.mainapp.adapter.HomeViewAdapter
import com.coshcorp.checkinghomeworks.mainapp.entities.enumType.FragmentActivo
import com.coshcorp.checkinghomeworks.mainapp.fragment.ChartsFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.ConfigurationFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.HomeFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.ProfileAndGroupsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.miItem1 -> Toast.makeText(applicationContext, "ITEM 1", Toast.LENGTH_SHORT)
                R.id.miItem2 -> Toast.makeText(applicationContext, "ITEM 2", Toast.LENGTH_SHORT)
                R.id.miItem3 -> Toast.makeText(applicationContext, "ITEM 3", Toast.LENGTH_SHORT)
            }
            true
        }
        */

    }
/*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    */

}