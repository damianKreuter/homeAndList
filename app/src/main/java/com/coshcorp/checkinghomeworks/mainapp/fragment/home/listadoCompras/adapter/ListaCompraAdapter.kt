package com.coshcorp.checkinghomeworks.mainapp.fragment.home.listadoCompras.adapter

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.coshcorp.checkinghomeworks.R
import com.coshcorp.checkinghomeworks.mainapp.entities.model.Almacen
import com.coshcorp.checkinghomeworks.mainapp.entities.model.ListaCompra
import com.coshcorp.checkinghomeworks.mainapp.fragment.home.almacenamiento.adapter.StockAdapter
import com.coshcorp.checkinghomeworks.mainapp.imageSwitch.ImagenPedidoSegunTipo
import kotlinx.android.synthetic.main.cardboxprincipal.view.*
import kotlinx.android.synthetic.main.shoppinglist.view.*
import org.w3c.dom.Text

class ListaCompraAdapter (val itemsLista:ArrayList<ListaCompra>): RecyclerView.Adapter<ListaCompraAdapter.ListaCompraVM>() {

    private lateinit var dialogDetallePedido: Dialog

    class ListaCompraVM(itemView: View, parent: ViewGroup) : RecyclerView.ViewHolder(itemView) {
        val ic_imagen: ImageView = itemView.imageView
        val ic_titulo: TextView = itemView.item_name
        val ic_estado: TextView = itemView.notaDescripcion
        val fechaCreacion : TextView = itemView.item_date_added
        
        val parentContext: Context = parent.context
        val viewGroup: ViewGroup = parent
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): ListaCompraVM {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.shoppinglist, parent, false)
        return ListaCompraVM(view, parent)
    }

    override fun getItemCount(): Int {
        return itemsLista.size
    }

    override fun onBindViewHolder(holder: ListaCompraVM, position: Int) {
        val listaEspecifica : ListaCompra = itemsLista[position]

        holder.ic_imagen.setImageResource(
                ImagenPedidoSegunTipo().iconoTipoListaCompra(listaEspecifica.tipo)
        )

        holder.ic_estado.text = listaEspecifica.descripcion

        holder.ic_titulo.text = listaEspecifica.nombre
    }

}
