package com.coshcorp.checkinghomeworks.mainapp.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coshcorp.checkinghomeworks.ProfileAndGroupsViewModel
import com.coshcorp.checkinghomeworks.R

class ProfileAndGroupsFragment : Fragment() {

    companion object {
        fun newInstance() =
            ProfileAndGroupsFragment()
    }

    private lateinit var viewModel: ProfileAndGroupsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_and_groups_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileAndGroupsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}