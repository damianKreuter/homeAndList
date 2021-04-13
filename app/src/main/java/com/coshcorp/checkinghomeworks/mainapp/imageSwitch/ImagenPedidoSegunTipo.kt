package com.coshcorp.checkinghomeworks.mainapp.imageSwitch

import com.coshcorp.checkinghomeworks.R
import com.coshcorp.checkinghomeworks.mainapp.entities.enumType.ImageAlmacen
import com.coshcorp.checkinghomeworks.mainapp.entities.enumType.ImageListaCompra
import com.coshcorp.checkinghomeworks.mainapp.entities.enumType.ImageTipoItem
import com.coshcorp.checkinghomeworks.mainapp.entities.enumType.ImageToDoList
import kotlinx.android.synthetic.main.cardboxprincipal.view.*

/**
 * PARA HACER LUEGO, CUANDO TENGA LAS IMAGENES VECTORIALES AHÍ SE LAS ASIGNO
 */
class ImagenPedidoSegunTipo {

    fun obtenerIcono(tipo:ImageAlmacen):Int {
  /*      return when(tipo) {
            ImageAlmacen.ALACENA -> R.drawable.ic_camion
            ImageAlmacen.CAJA-> R.drawable.ic_rico
            ImageAlmacen.ARMARIO-> R.drawable.ic_shopping
            ImageAlmacen.FREEZER -> R.drawable.ic_mensajeria
            ImageAlmacen.HELADERA -> R.drawable.ic_perfil
            ImageAlmacen.MINIBAR -> R.drawable.ic_dinero
        }

   */
        return R.drawable.ic_grafico_basico
    }

    fun iconoAlmacen(tipo : ImageTipoItem):Int {
    /*    return when(tipo) {
            ImageTipoItem.ALCOHOL -> R.drawable.icon_freezer
            ImageTipoItem.BEBIDAS-> R.drawable.icon_alacena
            ImageTipoItem.CARNE-> R.drawable.icon_heladera
            ImageTipoItem.FRUTAS-> R.drawable.icon_minibar
            ImageTipoItem.LACTEOS -> R.drawable.ic_cajas
            ImageTipoItem.PESCADO-> R.drawable.icon_heladera
            ImageTipoItem.POLLO -> R.drawable.icon_minibar
            ImageTipoItem.VERDURA -> R.drawable.ic_cajas
        }
     */
        return R.drawable.ic_grafico_basico
    }

    fun iconoListadoCompra(tipo : ImageToDoList) : Int{
     /*   return when(tipo) {
            ImageToDoList.CITA -> R.drawable.ic__carne
            ImageToDoList.COMPRAR-> R.drawable.ic_shopping
            ImageToDoList.CUIDAR-> R.drawable.icon_pet_care
            ImageToDoList.DEVOLVER-> R.drawable.icon_medicina
            ImageToDoList.EVENTO-> R.drawable.icon_pet_care
            ImageToDoList.LAVAR-> R.drawable.icon_medicina
            ImageToDoList.LIMPIAR-> R.drawable.icon_medicina
            ImageToDoList.PASEARPERRO-> R.drawable.icon_medicina
            ImageToDoList.COBRAR-> R.drawable.icon_medicina
            ImageToDoList.PAGAR-> R.drawable.icon_medicina
        }

      */
        return R.drawable.ic_grafico_basico
    }

    fun iconoTipoListaCompra(tipo : ImageListaCompra) : Int{
        /*   return when(tipo) {
               ImageToDoList.CITA -> R.drawable.ic__carne
               ImageToDoList.COMPRAR-> R.drawable.ic_shopping
               ImageToDoList.CUIDAR-> R.drawable.icon_pet_care
               ImageToDoList.DEVOLVER-> R.drawable.icon_medicina
               ImageToDoList.EVENTO-> R.drawable.icon_pet_care
               ImageToDoList.LAVAR-> R.drawable.icon_medicina
               ImageToDoList.LIMPIAR-> R.drawable.icon_medicina
               ImageToDoList.PASEARPERRO-> R.drawable.icon_medicina
               ImageToDoList.COBRAR-> R.drawable.icon_medicina
               ImageToDoList.PAGAR-> R.drawable.icon_medicina
           }

         */
        return R.drawable.ic_grafico_basico
    }

}