package com.coshcorp.checkinghomeworks.mainapp.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.coshcorp.checkinghomeworks.R
import com.coshcorp.checkinghomeworks.mainapp.fragment.ChartsFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.ConfigurationFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.adapter.HomeViewAdapter
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.almacenamiento.AlmacenesFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.listadoCompras.ListaComprasFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeViewAdapter : HomeViewAdapter?= activity?.let { HomeViewAdapter(it) }
        homeViewAdapter?.addFragment(ChartsFragment(), "Almacenamiento")
        homeViewAdapter?.addFragment(ConfigurationFragment(), "Lista de compras")

        mainPage_viewPager.adapter = homeViewAdapter

        mainPage_viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> mainPage_viewPager.requestDisallowInterceptTouchEvent(true)
                    1 -> mainPage_viewPager.requestDisallowInterceptTouchEvent(false)
                }
                // bottomNavigationMenu!!.getMenu().getItem(position).setChecked(true)
            }

        })
        // tabLayout = view.findViewById(R.id.homeTabLayout)
        initTabLayout()
    }

    private fun initnavBar() {

    }

    //LAYOUT que se muestra arriba de todo, los iconos se muestran siempre arriba
    private fun initTabLayout() {
        val tabLayoutMediator =
            TabLayoutMediator(homeTabLayout, mainPage_viewPager, TabLayoutMediator.TabConfigurationStrategy {
                    tab: TabLayout.Tab, i: Int ->
                when(i) {
                    0 -> {
                        tab.text = "Almacenamiento"
       //                 tab.setIcon(R.drawable.ic_flete_caudal)
                    }
                    1 -> {
                        tab.text = "Listado"
      //                  tab.setIcon(R.drawable.ic_cajas)
                    }

                }
            })
        tabLayoutMediator.attach()
    }



}