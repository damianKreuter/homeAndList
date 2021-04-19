package com.coshcorp.checkinghomeworks.mainapp.fragment.home.almacenamiento

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.coshcorp.checkinghomeworks.R
import com.coshcorp.checkinghomeworks.mainapp.entities.model.Almacen
import com.coshcorp.checkinghomeworks.mainapp.fragment.ChartsFragment
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.almacenamiento.adapter.StockAdapter
import com.coshcorp.checkinghomeworks.mainapp.service.obtenerData.StockService
import kotlinx.android.synthetic.main.fragment_almacenes.*
import java.sql.Timestamp

class AlmacenesFragment : Fragment() {
    private lateinit var stockArray : ArrayList<Almacen>


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
        stockArray = ArrayList()

        initRecyclerView()
        actualizarSharePreference()

    }

    private fun actualizarSharePreference(){
        val sharedPreferences : SharedPreferences = activity?.getSharedPreferences("navStatusToCreate", Context.MODE_PRIVATE)!!
        val sharePreferenceEditor : SharedPreferences.Editor = sharedPreferences.edit()

        sharePreferenceEditor.putString("navStatus", getString(R.string.stockstatus))
        sharePreferenceEditor.apply()
    }

    private fun initRecyclerView(){
        obtenerTodoElStock()

        //    recyclerView.adapter = PedidosActivoAdapter(pedidosLista)
        list_recycler_view.adapter = StockAdapter(stockArray)

        list_recycler_view.apply {
            list_recycler_view.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            //    recyclerView.layoutManager = GridLayoutManager(this.context,2)
        }
        
        obtenerTodoElStock()
    }

    private fun obtenerTodoElStock(){
        stockArray = StockService.getAllData()
    }

    companion object {
        fun newInstance() =
                AlmacenesFragment().apply {
                }
    }
}

