package com.coshcorp.checkinghomeworks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.adapter.HomeViewAdapter
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.almacenamiento.AlmacenesFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.listadoCompras.ListaComprasFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home_view_pager.*


class homeViewPagerFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homeViewAdapter : HomeViewAdapter?= activity?.let { HomeViewAdapter(it) }
        homeViewAdapter?.addFragment(AlmacenesFragment(), "Stock")
        homeViewAdapter?.addFragment(ListaComprasFragment(), "Lista de compras")
        viewPagerRecyclerView.adapter = homeViewAdapter


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
                TabLayoutMediator(tabViewpager2, viewPagerRecyclerView, TabLayoutMediator.TabConfigurationStrategy {
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

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                homeViewPagerFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}