package com.coshcorp.checkinghomeworks.mainapp.service.obtenerData

interface ManipularData {

    fun <T> getData(id : Int) : T

    fun <T> updateData(data :  T)

    fun deleteData(index : Int)

    fun <T> getAllData() :ArrayList<T>
}