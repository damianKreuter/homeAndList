package com.coshcorp.checkinghomeworks

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toolbar
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.coshcorp.checkinghomeworks.mainapp.adapter.HomeViewAdapter
import com.coshcorp.checkinghomeworks.mainapp.entities.enumType.FragmentActivo
import com.coshcorp.checkinghomeworks.mainapp.fragment.ChartsFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.ConfigurationFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.ProfileAndGroupsFragment
import kotlinx.android.synthetic.main.fragment_main.bottomNavigationMenu
import kotlinx.android.synthetic.main.fragment_main.floating_action_button
import kotlinx.android.synthetic.main.fragment_main.viewPagerPrincipal

class main_page : Fragment() {
    lateinit var fragmentActivoEnum : FragmentActivo
    lateinit var appbar : Toolbar
    lateinit var viewPager2: ViewPager2

    var indexViewPager2 : Int = 0

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
        fragmentActivoEnum = FragmentActivo.grupos
        viewPager2 = viewPagerPrincipal
        inicioMenu()
        actionACrearElemento()
        Toast.makeText(context, "view created", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        ponerPaginaSegunUltimoEstado()
        Toast.makeText(context, "START", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(context, "RESUME", Toast.LENGTH_SHORT).show()
        viewPager2.setCurrentItem(indexViewPager2, false)
    }

    private fun ponerPaginaSegunUltimoEstado(){
        var ultimoEstado : String? = recuperarEstadoDeNavegacion()
        when(ultimoEstado){
            FragmentActivo.stock.name-> {
                bottomNavigationMenu.menu.findItem(R.id.menu_home).isChecked = true
                indexViewPager2 = 0
                viewPager2.currentItem = 0
                fragmentActivoEnum = FragmentActivo.stock
            }
            FragmentActivo.listas.name-> {
                bottomNavigationMenu.menu.findItem(R.id.menu_home).isChecked = true
                indexViewPager2 = 0
                viewPager2.currentItem = 0
                fragmentActivoEnum = FragmentActivo.stock
            }
            FragmentActivo.grupos.name-> {
                bottomNavigationMenu.menu.findItem(R.id.menu_personalData).isChecked = true
                indexViewPager2 = 1
                viewPager2.currentItem = 1
                fragmentActivoEnum = FragmentActivo.grupos
            }
            FragmentActivo.finanzas.name-> {
                bottomNavigationMenu.menu.findItem(R.id.menu_verGraficos).isChecked = true
                indexViewPager2 = 2
                viewPager2.currentItem = 2
                fragmentActivoEnum = FragmentActivo.finanzas
            }
            FragmentActivo.notas.name-> {
                bottomNavigationMenu.menu.findItem(R.id.menu_configuracion).isChecked = true
                indexViewPager2 = 3
                viewPager2.currentItem = 3
                fragmentActivoEnum = FragmentActivo.notas
            }

            else -> {
                bottomNavigationMenu.menu.findItem(R.id.menu_home).isChecked = true
                indexViewPager2 = 0
                viewPager2.currentItem = 0
                fragmentActivoEnum = FragmentActivo.stock
            }
        }
     //   viewPager2.currentItem =indexViewPager2
    }

    private fun establecerPaginaActiva(fragmentStatus : FragmentActivo){

    }

    private fun recuperarEstadoDeNavegacion() : String? {
        val sharePreference = activity?.getSharedPreferences("navStatusToCreate", Context.MODE_PRIVATE)
        return sharePreference?.getString("navStatus", "no hay valor")
    }

    private fun actionACrearElemento(){
        /*
            Abre el FULLSCREEN DIALOG el cual dependiendo en que página o subpágina se ha activado la
            misma entonces tendrá diferentes tipo de navegación
            EJ: Algunos solo necesitan poner 1 solo (titulo, tipo y quizas descripcion)
            Otros en cambios además de eso deben poner nuevos elementos
         */


        floating_action_button.setOnClickListener { view ->
            //showCreateHeaderDialog()
            guardarDatosDePreferencias(fragmentActivoEnum)
            Navigation.findNavController(view).navigate(R.id.action_main_page_to_crearElementoFragment)
        }
    }

    /*
    private fun showCreateHeaderDialog(){
        val fragmentManager : FragmentManager? = activity?.supportFragmentManager
        val newFragmentDialog : headerFullScreenDialog = headerFullScreenDialog()

        /*
            Estp de arriba es aplicable para el cambiode  pantallas en donde la pantalla
            es muy grande para justificar que se ocupe toda la misma, por ejemplo Tablets
         */
       /* if(true && fragmentManager != null){
            newFragmentDialog.show(fragmentManager, "dialog")
        } else {
*/
            val transaction : FragmentTransaction? = fragmentManager?.beginTransaction()
            transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            transaction?.add(android.R.id.content, newFragmentDialog)
                    ?.addToBackStack(null)?.commit()
      //  }
    }
    */


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

        var homeViewPagerFragment : homeViewPagerFragment = homeViewPagerFragment()
        homeViewAdapter?.addFragment(homeViewPagerFragment, "Home")
        homeViewAdapter?.addFragment(ProfileAndGroupsFragment(), "Perfil")
        homeViewAdapter?.addFragment(ChartsFragment(), "Graficos")
        homeViewAdapter?.addFragment(ConfigurationFragment(), "Configuración")
        viewPager2.adapter = homeViewAdapter
    }

    private fun navegacionEnPantalla(){
        //   Es un observer que a partir de un boton del bottomNavbar sea tocado, se transporta
        //   al fragment corespondiente del PageView2
        bottomNavigationMenu.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
       //             indexViewPager2 = 0
                    viewPager2.currentItem = 0
                    fragmentActivoEnum = FragmentActivo.stock
                }
                R.id.menu_personalData -> {
         //           indexViewPager2 = 1
                    viewPager2.currentItem = 1
                    fragmentActivoEnum = FragmentActivo.grupos
                }
                R.id.menu_verGraficos -> {
        //            indexViewPager2 = 2
                    viewPager2.currentItem = 2
                    fragmentActivoEnum = FragmentActivo.finanzas
                }
                R.id.menu_configuracion -> {
        //            indexViewPager2 = 3
                    viewPager2.currentItem = 3
                    fragmentActivoEnum = FragmentActivo.notas
                }
            }
            true
        }

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            /*
            Observa cuando se realiza un cambio entre las paginas
             */
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        bottomNavigationMenu.menu.findItem(R.id.menu_home).isChecked = true
                        fragmentActivoEnum = FragmentActivo.stock
                    }
                    1 -> {
                        bottomNavigationMenu.menu.findItem(R.id.menu_personalData).isChecked = true
                        fragmentActivoEnum = FragmentActivo.grupos
                    }
                    2 -> {
                        bottomNavigationMenu.menu.findItem(R.id.menu_verGraficos).isChecked = true
                        fragmentActivoEnum = FragmentActivo.finanzas
                    }
                    3 -> {
                        bottomNavigationMenu.menu.findItem(R.id.menu_configuracion).isChecked = true
                        fragmentActivoEnum = FragmentActivo.notas
                    }
                }
            }
        })
    }
}