package com.coshcorp.checkinghomeworks.mainapp.entities.model

import com.coshcorp.checkinghomeworks.mainapp.entities.enumType.ImageListaCompra

class ListaCompra (
        var nombre : String,
        var descripcion : String,
        var itemsAComprar : ArrayList<PedidoAComprar>,
        var tipo : ImageListaCompra
)