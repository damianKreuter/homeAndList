package com.coshcorp.checkinghomeworks.mainapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.coshcorp.checkinghomeworks.R
import com.coshcorp.checkinghomeworks.mainapp.adapter.HomeViewAdapter
import com.coshcorp.checkinghomeworks.mainapp.fragment.ChartsFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.ConfigurationFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.HomeFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.ProfileAndGroupsFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.almacenamiento.AlmacenesFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.listadoCompras.ListaComprasFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        bottomNavigationMenu.background=null



        val homeViewAdapter : HomeViewAdapter?= this.let { HomeViewAdapter(it) } // caso como activity
            //activity.let { HomeViewAdapter(it) }          CASO en que esté como fragment
        homeViewAdapter?.addFragment(HomeFragment(), "Home")
        homeViewAdapter?.addFragment(ProfileAndGroupsFragment(), "Perfil")
        homeViewAdapter?.addFragment(ChartsFragment(), "Graficos")
        homeViewAdapter?.addFragment(ConfigurationFragment(), "Configuración")

        viewPagerPrincipal.adapter = homeViewAdapter



      //  viewPagerPrincipal.addOnLayoutChangeListener()


        //    Observer que permite que a partir de los deslizaminetos laterales del ViewPager2
        //    se actualiza la posición actual del BottomNavBar lo cual es muy conveniente.

        viewPagerPrincipal.registerOnPageChangeCallback(object : OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> bottomNavigationMenu.menu.findItem(R.id.menu_home).isChecked = true
                    1 -> bottomNavigationMenu.menu.findItem(R.id.menu_personalData).isChecked = true
                    2 -> bottomNavigationMenu.menu.findItem(R.id.menu_verGraficos).isChecked = true
                    3 -> bottomNavigationMenu.menu.findItem(R.id.menu_configuracion).isChecked = true
                }
                // bottomNavigationMenu!!.getMenu().getItem(position).setChecked(true)
            }

        })
        viewPagerPrincipal.requestDisallowInterceptTouchEvent(true)

         //   Es un observer que a partir de un boton del bottomNavbar sea tocado, se transporta
         //   al fragment corespondiente del PageView2

        bottomNavigationMenu.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> viewPagerPrincipal.currentItem = 0
                R.id.menu_personalData -> viewPagerPrincipal.currentItem = 1
                R.id.menu_verGraficos -> viewPagerPrincipal.currentItem = 2
                R.id.menu_configuracion -> viewPagerPrincipal.currentItem = 3
            }
            true
        }

    }
}