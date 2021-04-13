package com.coshcorp.checkinghomeworks.mainapp.entities.model

import com.coshcorp.checkinghomeworks.mainapp.entities.enumType.ImageAlmacen

class Almacen (
        var idAlmacen: Int,
        var nombre : String,
        var estado : String,
   //     var permisos : Permiso,
        var tipo : ImageAlmacen,
        var itemsQueTiene : ArrayList<Item>
)