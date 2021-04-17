package com.coshcorp.checkinghomeworks.mainapp.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.coshcorp.checkinghomeworks.R
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.adapter.HomeViewAdapter
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.almacenamiento.AlmacenesFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.listadoCompras.ListaComprasFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var tab : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homeViewAdapter : HomeViewAdapter?= activity?.let { HomeViewAdapter(it) }
        homeViewAdapter?.addFragment(AlmacenesFragment(), "Stock")
        homeViewAdapter?.addFragment(ListaComprasFragment(), "Lista de compras")
        val viewPager2 : ViewPager2 = view.findViewById(R.id.mainPage_viewPager)
        viewPager2.adapter = homeViewAdapter

        initTabLayout()

    //    mainPage_viewPager.requestDisallowInterceptTouchEvent(false)

    //    mainPage_viewPager.setOnTouchListener(mainPage_viewPager.requestDisallowInterceptTouchEvent(true))
      //  mainPage_viewPager.onNestedScroll(this.view, id)

        // tabLayout = view.findViewById(R.id.homeTabLayout)

    }



    private fun initnavBar() {

    }

    //LAYOUT que se muestra arriba de todo, los iconos se muestran siempre arriba
    private fun initTabLayout() {

        val tabLayoutMediator =
            TabLayoutMediator(tab, mainPage_viewPager, TabLayoutMediator.TabConfigurationStrategy {
                    tab: TabLayout.Tab, i: Int ->
                when(i) {
                    0 -> {
                        tab.text = "Stock"
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