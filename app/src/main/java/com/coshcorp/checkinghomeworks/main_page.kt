package com.coshcorp.checkinghomeworks

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.navigation.Navigation
import androidx.preference.PreferenceManager
import androidx.viewpager2.widget.ViewPager2
import com.coshcorp.checkinghomeworks.mainapp.adapter.HomeViewAdapter
import com.coshcorp.checkinghomeworks.mainapp.entities.enumType.FragmentActivo
import com.coshcorp.checkinghomeworks.mainapp.fragment.ChartsFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.ProfileAndGroupsFragment
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.bottomNavigationMenu
import kotlinx.android.synthetic.main.fragment_main.floating_action_button
import kotlinx.android.synthetic.main.fragment_main.viewPagerPrincipal
import kotlinx.android.synthetic.main.fragment_main_page.*

class main_page : Fragment() {
    lateinit var viewPagerPrincipalS : ViewPager2
    lateinit var fragmentActivoEnum : FragmentActivo
    lateinit var appbar : Toolbar

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentActivoEnum = FragmentActivo.stock
        inicioMenu()
        actionACrearElemento()
    }

    private fun actionACrearElemento(){
        guardarDatosDePreferencias(fragmentActivoEnum)
        floating_action_button.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(R.id.action_main_page_to_crearElementoFragment)
        }
    }

    private fun guardarDatosDePreferencias(value : FragmentActivo) {
        sharedPreferences = activity?.getSharedPreferences("navStatusToCreate", Context.MODE_PRIVATE)!!
        val sharePreferenceEditor : SharedPreferences.Editor = sharedPreferences.edit()
        when(value){
            FragmentActivo.stock -> {
                sharePreferenceEditor.putString("navStatus", getString(R.string.stockstatus))
                sharePreferenceEditor.apply()
            }
            FragmentActivo.finanzas -> {
                sharePreferenceEditor.putString("navStatus", getString(R.string.finanzastatus))
                sharePreferenceEditor.apply()
            }
            FragmentActivo.notas -> {
                sharePreferenceEditor.putString("navStatus", getString(R.string.notastatus))
                sharePreferenceEditor.apply()
            }
            FragmentActivo.listas -> {
                sharePreferenceEditor.putString("navStatus", getString(R.string.liststatus))
                sharePreferenceEditor.apply()
            }
            FragmentActivo.itemComprado -> {
                sharePreferenceEditor.putString("navStatus", getString(R.string.itemsstatus))
                sharePreferenceEditor.apply()
            }
            FragmentActivo.grupos -> {
                sharePreferenceEditor.putString("navStatus", getString(R.string.grupostatus))
                sharePreferenceEditor.apply()
            }
        }
    }

    private fun inicioMenu() {
        bottomNavigationMenu.background=null


        establecerPaginasDeNavegacion()
        //    Observer que permite que a partir de los deslizaminetos laterales del ViewPager2
        //    se actualiza la posición actual del BottomNavBar lo cual es muy conveniente.

        navegacionEnPantalla()
    }

    private fun crearNuevoElementoDeAlgo(){

    }

    private fun establecerPaginasDeNavegacion(){
        val homeViewAdapter : HomeViewAdapter?= activity?.let { HomeViewAdapter(it) } // caso como activity
        //activity.let { HomeViewAdapter(it) }          CASO en que esté como fragment

        val homeViewPagerFragment : homeViewPagerFragment = homeViewPagerFragment()
        homeViewAdapter?.addFragment(homeViewPagerFragment, "Home")
        homeViewAdapter?.addFragment(ProfileAndGroupsFragment(), "Perfil")
        homeViewAdapter?.addFragment(ChartsFragment(), "Graficos")
        homeViewAdapter?.addFragment(homeViewPagerFragment(), "Configuración")
        viewPagerPrincipal.adapter = homeViewAdapter
    }

    private fun navegacionEnPantalla(){
        viewPagerPrincipal.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        bottomNavigationMenu.menu.findItem(R.id.menu_home).isChecked = true
                        fragmentActivoEnum = FragmentActivo.stock
                    }
                    1 -> {
                        bottomNavigationMenu.menu.findItem(R.id.menu_personalData).isChecked = true
                        fragmentActivoEnum = FragmentActivo.notas
                    }
                    2 -> {
                        bottomNavigationMenu.menu.findItem(R.id.menu_verGraficos).isChecked = true
                        fragmentActivoEnum = FragmentActivo.finanzas
                    }
                    3 -> bottomNavigationMenu.menu.findItem(R.id.menu_configuracion).isChecked = true
                }
            }

        })

        //   Es un observer que a partir de un boton del bottomNavbar sea tocado, se transporta
        //   al fragment corespondiente del PageView2

        bottomNavigationMenu.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    viewPagerPrincipal.currentItem = 0
                    fragmentActivoEnum = FragmentActivo.stock
                }
                R.id.menu_personalData -> {
                    viewPagerPrincipal.currentItem = 1
                    fragmentActivoEnum = FragmentActivo.notas
                }
                R.id.menu_verGraficos -> {
                    viewPagerPrincipal.currentItem = 2
                    fragmentActivoEnum = FragmentActivo.finanzas
                }
                R.id.menu_configuracion -> {
                    viewPagerPrincipal.currentItem = 3
                }
            }
            true
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                main_page().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}