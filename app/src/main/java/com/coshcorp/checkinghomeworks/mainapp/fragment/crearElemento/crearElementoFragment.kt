package com.coshcorp.checkinghomeworks.mainapp.fragment.crearElemento

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.doOnNextLayout
import androidx.core.widget.doOnTextChanged
import androidx.navigation.Navigation
import androidx.preference.PreferenceManager
import com.coshcorp.checkinghomeworks.R
import com.coshcorp.checkinghomeworks.mainapp.entities.enumType.*
import com.coshcorp.checkinghomeworks.mainapp.entities.model.ListaCompra
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_crear_elemento.*


class crearElementoFragment : Fragment() {

    lateinit var titleInput : TextInputEditText
    lateinit var titleLayout : TextInputLayout
    lateinit var combobox :TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crear_elemento, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    //    activity?.setTitle("Crear nueva lista")

        combobox = combobox_type
        titleInput = editlayout_title
        titleLayout = input_titulo

        toolbar.setTitle("Crear elemento")
        toolbar.setSubtitle("Paso 1 de 3")


        guardarElementos()
    }

    private fun guardarElementos(){
        val errorMessage: String = getString(R.string.esrequerido)
        val toastMessage : String = getString(R.string.completarrequeridos)


        //A partir del tipo de navegacion, vamos a llenar el combobox de una u otra forma

        obtenerListaComboBox()

        //Setea error en el caso de que no haya ningún campo
        titleInput.doOnTextChanged { text, start, before, count ->
            if(text!!.length == 0) {
                titleLayout.error = errorMessage
            } else {
                titleLayout.error = null
            }
        }

        //Se debe realizar la creación de un elemento a partir de los datos que están arriba
        floating_action_button_creation.setOnClickListener { view ->
            if(titleInput.length()==0){
                titleLayout.error = errorMessage
                //         titleLayout.boxStro = getResources().getColor(R.color.selecionado)
                //     titleLayout.isErrorEnabled = true
                Toast.makeText(context, toastMessage, Toast.LENGTH_LONG).show()
            } else {
                //Salió OK, entonces procedemos a realizar el servicio de alta de 1 objeto de estos

                /*
                TODO
                Craer un servicio del cual me permita dar de alta STOCK Y LISTA DE COMPRAS,
                en principio vacias.
                 */
                Navigation.findNavController(view).navigate(R.id.action_crearElementoFragment_to_main_page)
            }

        }
    }

    private fun obtenerListaComboBox() : ArrayList<String>{
        val valorObtenido = recuperarEstadoDeNavegacion()
        var nombresAComboBox : ArrayList<String> = ArrayList<String>()
        when(valorObtenido){
            FragmentActivo.stock.name-> nombresAComboBox =listaComboBoxStocck()
            FragmentActivo.listas.name-> nombresAComboBox =listaComboBoxLista()
            FragmentActivo.itemComprado.name-> nombresAComboBox =listaComboBoxItem()
            FragmentActivo.notas.name-> nombresAComboBox =listaComboBoxNotas()
            FragmentActivo.finanzas.name-> nombresAComboBox =listaComboBoxFinanzas()
        }
        val adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, nombresAComboBox)
        autoCompleteTextView.setAdapter(adapter)
        autoCompleteTextView.setText(nombresAComboBox.get(0),false)
        return nombresAComboBox
    }

    private fun listaComboBoxFinanzas() : ArrayList<String>{
        var list : ArrayList<String> = ArrayList<String>()
        val values = ImageFinanzas.values()
        for(unvalue : ImageFinanzas in values){
            list.add(unvalue.name)
        }
        return list
    }

    private fun listaComboBoxNotas() : ArrayList<String>{
        var list : ArrayList<String> = ArrayList<String>()
        val values = ImageToDoList.values()
        for(unvalue : ImageToDoList in values){
            list.add(unvalue.name)
        }
        return list
    }

    private fun listaComboBoxStocck() : ArrayList<String>{
        var list : ArrayList<String> = ArrayList<String>()
        val values = ImageAlmacen.values()
        for(unvalue : ImageAlmacen in values){
            list.add(unvalue.name)
        }
        return list
    }

    private fun listaComboBoxLista() : ArrayList<String>{
        var list : ArrayList<String> = ArrayList<String>()
        val values = ImageListaCompra.values()
        for(unvalue : ImageListaCompra in values){
            list.add(unvalue.name)
        }
        return list
    }

    private fun listaComboBoxItem() : ArrayList<String>{
        var list : ArrayList<String> = ArrayList<String>()
        val values = ImageTipoItem.values()
        for(unvalue : ImageTipoItem in values){
            list.add(unvalue.name)
        }
        return list
    }



    private fun recuperarEstadoDeNavegacion() : String? {
        val sharePreference = activity?.getSharedPreferences("navStatusToCreate", Context.MODE_PRIVATE)
        return sharePreference?.getString("navStatus", "no hay valor")
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                crearElementoFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}