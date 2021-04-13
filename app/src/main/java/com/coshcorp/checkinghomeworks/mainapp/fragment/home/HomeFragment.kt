package com.coshcorp.checkinghomeworks.mainapp.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.coshcorp.checkinghomeworks.R
import com.coshcorp.checkinghomeworks.mainapp.fragment.ChartsFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.ConfigurationFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.adapter.HomeViewAdapter
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.almacenamiento.AlmacenesFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.listadoCompras.ListaComprasFragment
import com.coshcorp.checkinghomeworks.mainapp.widget.NestedScrollableHost
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

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
        mainPage_viewPager.adapter = homeViewAdapter
        initTabLayout()
//        nested = nestedScrollableHostID
/*
        val homeViewAdapter : HomeViewAdapter?= activity?.let { HomeViewAdapter(it) }
        homeViewAdapter?.addFragment(ChartsFragment(), "Stock")
        homeViewAdapter?.addFragment(ConfigurationFragment(), "Lista de compras")
        homeViewAdapter?.addFragment(ChartsFragment(), "Lista de compras")

        mainPage_viewPager.adapter = homeViewAdapter
        initTabLayout()
*/
/*        nestedScrollableHostID.setOnTouchListener(OnTouchListener { v, event ->
            mainPage_viewPager.requestDisallowInterceptTouchEvent(true)
            false
        })
        */

/*
        mainPage_viewPager.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_MOVE -> mainPage_viewPager.requestDisallowInterceptTouchEvent(true)
                }

                return v?.onTouchEvent(event) ?: true
            }

        })

        view.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_SCROLL -> mainPage_viewPager.requestDisallowInterceptTouchEvent(true)
                }

                return v?.onTouchEvent(event) ?: true
            }
        })
        */
        /*
        view.setOnTouchListener({ view: View, e: MotionEvent ->
            if (e.action == MotionEvent.ACTION_DOWN) {
                initialX = e.x
                initialY = e.y
                parent.requestDisallowInterceptTouchEvent(true)
            } else if (e.action == MotionEvent.ACTION_MOVE) {
                val dx = e.x - initialX
                val dy = e.y - initialY
                val isVpHorizontal = orientation == ViewPager2.ORIENTATION_HORIZONTAL

                // assuming ViewPager2 touch-slop is 2x touch-slop of child
                val scaledDx = dx.absoluteValue * if (isVpHorizontal) .5f else 1f
                val scaledDy = dy.absoluteValue * if (isVpHorizontal) 1f else .5f

                if (scaledDx > touchSlop || scaledDy > touchSlop) {
                    if (isVpHorizontal == (scaledDy > scaledDx)) {
                        // Gesture is perpendicular, allow all parents to intercept
                        parent.requestDisallowInterceptTouchEvent(false)
                    } else {
                        // Gesture is parallel, query child if movement in that direction is possible
                        if (canChildScroll(orientation, if (isVpHorizontal) dx else dy)) {
                            // Child can scroll, disallow all parents to intercept
                            parent.requestDisallowInterceptTouchEvent(true)
                        } else {
                            // Child cannot scroll, allow all parents to intercept
                            parent.requestDisallowInterceptTouchEvent(false)
                        }
                    }
                }
            } else {
                parent.requestDisallowInterceptTouchEvent(false)
            }

        })
*/
    //    mainPage_viewPager.requestDisallowInterceptTouchEvent(false)

    //    mainPage_viewPager.setOnTouchListener(mainPage_viewPager.requestDisallowInterceptTouchEvent(true))
      //  mainPage_viewPager.onNestedScroll(this.view, id)
/*
        mainPage_viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> mainPage_viewPager.requestDisallowInterceptTouchEvent(true)
                    1 -> mainPage_viewPager.requestDisallowInterceptTouchEvent(false)
                }
                // bottomNavigationMenu!!.getMenu().getItem(position).setChecked(true)
            }

        })*/
        // tabLayout = view.findViewById(R.id.homeTabLayout)

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
                        tab.text = "Stock"
       //                 tab.setIcon(R.drawable.ic_flete_caudal)
                    }
                    1 -> {
                        tab.text = "Listado"
      //                  tab.setIcon(R.drawable.ic_cajas)
                    }
                    2 -> {
                        tab.text = "Detalle"
                        //                  tab.setIcon(R.drawable.ic_cajas)
                    }
                }
            })
        tabLayoutMediator.attach()
    }



}