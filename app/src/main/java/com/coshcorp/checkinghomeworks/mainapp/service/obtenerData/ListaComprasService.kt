package com.coshcorp.checkinghomeworks.mainapp.service.obtenerData

import com.coshcorp.checkinghomeworks.mainapp.entities.enumType.ImageAlmacen
import com.coshcorp.checkinghomeworks.mainapp.entities.enumType.ImageListaCompra
import com.coshcorp.checkinghomeworks.mainapp.entities.model.Almacen
import com.coshcorp.checkinghomeworks.mainapp.entities.model.Item
import com.coshcorp.checkinghomeworks.mainapp.entities.model.ListaCompra
import com.coshcorp.checkinghomeworks.mainapp.entities.model.PedidoAComprar

object ListaComprasService {
    fun getData(id: Int): ListaCompra {
        TODO("Not yet implemented")
    }

    fun updateData(data: ListaCompra) {
        TODO("Not yet implemented")
    }

    fun deleteData(index: Int) {
        TODO("Not yet implemented")
    }

    fun getAllData(): ArrayList<ListaCompra> {
        return init()
    }

    private fun init() : ArrayList<ListaCompra>{
        var array : ArrayList<ListaCompra> = ArrayList<ListaCompra>()

        array.add(ListaCompra("Semanal", "Comida ordinaria", ArrayList<PedidoAComprar>(), ImageListaCompra.Comida))
        array.add(ListaCompra("Semanal", "Comida ordinaria", ArrayList<PedidoAComprar>(), ImageListaCompra.Comida))
        array.add(ListaCompra("Semanal", "Comida ordinaria", ArrayList<PedidoAComprar>(), ImageListaCompra.Comida))
        array.add(ListaCompra("Semanal", "Comida ordinaria", ArrayList<PedidoAComprar>(), ImageListaCompra.Comida))
        array.add(ListaCompra("Semanal", "Comida ordinaria", ArrayList<PedidoAComprar>(), ImageListaCompra.Comida))
        array.add(ListaCompra("Semanal", "Comida ordinaria", ArrayList<PedidoAComprar>(), ImageListaCompra.Comida))
        array.add(ListaCompra("Semanal", "Comida ordinaria", ArrayList<PedidoAComprar>(), ImageListaCompra.Comida))
        array.add(ListaCompra("Semanal", "Comida ordinaria", ArrayList<PedidoAComprar>(), ImageListaCompra.Comida))

        return array
    }
}