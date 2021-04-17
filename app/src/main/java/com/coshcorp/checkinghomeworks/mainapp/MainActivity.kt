package com.coshcorp.checkinghomeworks.mainapp

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
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



    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}