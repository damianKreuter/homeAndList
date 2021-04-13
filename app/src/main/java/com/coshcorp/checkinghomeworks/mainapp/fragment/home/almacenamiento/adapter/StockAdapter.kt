package com.coshcorp.checkinghomeworks.mainapp.fragment.home.almacenamiento.adapter

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
import com.coshcorp.checkinghomeworks.mainapp.imageSwitch.ImagenPedidoSegunTipo
import kotlinx.android.synthetic.main.cardboxprincipal.view.*

class StockAdapter (val itemsLista:ArrayList<Almacen>): RecyclerView.Adapter<StockAdapter.StockVM>() {

    private lateinit var dialogDetallePedido: Dialog

    class StockVM(itemView: View, parent: ViewGroup) : RecyclerView.ViewHolder(itemView) {
        val ic_imagen: ImageView = itemView.ic_stock_card
        val ic_titulo: TextView = itemView.card_titutlo
        val ic_estado: TextView = itemView.card_estado

        //    val ic_fecha: TextView = itemView.card_fecha
        //    val ic_nroPedido: TextView = itemView.card_nroPedido
        //    val layout_expandible : LinearLayout = itemView.findViewById(R.id.constraintLayoutExpandible)
        //    val layout_total_carta : LinearLayout = itemView.findViewById(R.id.cartaChicaExpandible)
        //    val todo_layout: LinearLayout = itemView.findViewById(R.id.cartaChicaExpandible)
        //    val buttonVerDetalles : Button = itemView.findViewById(R.id.buttonVerDetalles)
        val parentContext: Context = parent.context
        val viewGroup: ViewGroup = parent
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): StockVM {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.cardboxprincipal, parent, false)
        return StockVM(view, parent)
    }

    override fun getItemCount(): Int {
        return itemsLista.size
    }

    override fun onBindViewHolder(holder: StockAdapter.StockVM, position: Int) {
        val almacenEspecifico : Almacen = itemsLista[position]

        holder.ic_imagen.setImageResource(
                ImagenPedidoSegunTipo().obtenerIcono(almacenEspecifico.tipo)
        )

        holder.ic_estado.text = almacenEspecifico.estado
        //    holder.ic_fecha.text = pedidoEspecifico.fecha
        //    holder.ic_nroPedido.text = pedidoEspecifico.id_pedido
        holder.ic_titulo.text = almacenEspecifico.nombre
        //    holder.ic_nroPedido.text = pedidoEspecifico.id_pedido
        //    holder.ic_nroPedido.text = pedidoEspecifico.id_pedido

        //    val estaExandido: Boolean = itemsLista[position].expandible

        //    holder.layout_expandible.visibility = if (estaExandido) View.VISIBLE else View.GONE
/*
        holder.layout_total_carta.setOnClickListener {
            val personaCamber = itemsLista[position]
            personaCamber.expandible = !personaCamber.expandible
            notifyItemChanged(position)
        }

        holder.buttonVerDetalles.setOnClickListener {
            val pedidoLista: Pedido = itemsLista[position]
            PedidoDetalleFullDialogFragment.display(pedidoLista.context, pedidoLista)
        }
 */
    }


}
