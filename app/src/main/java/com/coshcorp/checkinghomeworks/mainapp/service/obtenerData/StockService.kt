package com.coshcorp.checkinghomeworks.mainapp.service.obtenerData

import com.coshcorp.checkinghomeworks.mainapp.entities.enumType.ImageAlmacen
import com.coshcorp.checkinghomeworks.mainapp.entities.model.Almacen
import com.coshcorp.checkinghomeworks.mainapp.entities.model.Item

object StockService
    //: ManipularData
    {
    fun getData(id: Int): Almacen {
        TODO("Not yet implemented")

        //TEMPORARL
    }

    fun updateData(data: Almacen) {
        TODO("Not yet implemented")
    }

    fun deleteData(index: Int) {
        TODO("Not yet implemented")
    }

    fun getAllData(): ArrayList<Almacen> {
        return init()
    }

    private fun init() : ArrayList<Almacen>{
        var array : ArrayList<Almacen> = ArrayList<Almacen>()

        array.add(Almacen(1, "Stock 1", "Actualizado", ImageAlmacen.Heladera, ArrayList<Item>()))
        array.add(Almacen(2, "Stock 2", "Actualizado", ImageAlmacen.Minibar, ArrayList<Item>()))
        array.add(Almacen(3, "Stock 3", "Actualizado", ImageAlmacen.Freezer, ArrayList<Item>()))
        array.add(Almacen(4, "Stock 4", "Actualizado", ImageAlmacen.Armario, ArrayList<Item>()))
        array.add(Almacen(5, "Stock 5", "Actualizado", ImageAlmacen.Minibar, ArrayList<Item>()))
        array.add(Almacen(6, "Stock 6", "Actualizado", ImageAlmacen.Caja, ArrayList<Item>()))
        array.add(Almacen(7, "Stock 7", "Actualizado", ImageAlmacen.Freezer, ArrayList<Item>()))
        return array
    }
}