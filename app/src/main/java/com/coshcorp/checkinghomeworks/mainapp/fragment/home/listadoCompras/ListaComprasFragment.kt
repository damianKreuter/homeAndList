package com.coshcorp.checkinghomeworks.mainapp.fragment.home.listadoCompras

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.coshcorp.checkinghomeworks.R
import com.coshcorp.checkinghomeworks.mainapp.entities.enumType.FragmentActivo
import com.coshcorp.checkinghomeworks.mainapp.entities.model.Almacen
import com.coshcorp.checkinghomeworks.mainapp.entities.model.ListaCompra
import com.coshcorp.checkinghomeworks.mainapp.fragment.ChartsFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.almacenamiento.AlmacenesFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.almacenamiento.adapter.StockAdapter
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.listadoCompras.adapter.ListaCompraAdapter
import com.coshcorp.checkinghomeworks.mainapp.service.obtenerData.ListaComprasService
import com.coshcorp.checkinghomeworks.mainapp.service.obtenerData.StockService
import kotlinx.android.synthetic.main.fragment_almacenes.*

class ListaComprasFragment : Fragment() {
    private lateinit var listaComprasArray : ArrayList<ListaCompra>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_almacenes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Setear adapter de los almacenes
        listaComprasArray = ArrayList()

        initRecyclerView()

        actualizarSharePreference()
    }

    private fun actualizarSharePreference(){
        val sharedPreferences : SharedPreferences = activity?.getSharedPreferences("navStatusToCreate", Context.MODE_PRIVATE)!!
        val sharePreferenceEditor : SharedPreferences.Editor = sharedPreferences.edit()

        sharePreferenceEditor.putString("navStatus", getString(R.string.liststatus))
        sharePreferenceEditor.apply()
    }

    private fun initRecyclerView(){
        obtenerTodoElStock()
        //    recyclerView.adapter = PedidosActivoAdapter(pedidosLista)
        list_recycler_view.adapter = ListaCompraAdapter(listaComprasArray)

        list_recycler_view.apply {
            list_recycler_view.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)
            //    recyclerView.layoutManager = GridLayoutManager(this.context,2)
        }

        obtenerTodoElStock()
    }

    private fun obtenerTodoElStock(){
        listaComprasArray = ListaComprasService.getAllData()
    }

    companion object {
        fun newInstance() =
                ListaComprasFragment().apply {
                }
    }

}