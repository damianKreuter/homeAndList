package com.coshcorp.checkinghomeworks.mainapp.fragment.home.almacenamiento

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coshcorp.checkinghomeworks.R
import com.coshcorp.checkinghomeworks.mainapp.fragment.ChartsFragment

class AlmacenesFragment : Fragment() {


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

    companion object {
        fun newInstance() =
                AlmacenesFragment().apply {
                }
    }
}