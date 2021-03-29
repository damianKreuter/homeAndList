package com.coshcorp.checkinghomeworks.mainapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeViewAdapter (fr : FragmentActivity) : FragmentStateAdapter(fr) {

    private var listFragmnet: MutableList<Fragment> = ArrayList<Fragment>()
    private var fragmentTitle: MutableList<String> = ArrayList<String>()

    override fun getItemCount(): Int {
        return listFragmnet.size
    }

    fun addFragment(fragment: Fragment, title : String) {
        listFragmnet.add(fragment)
        fragmentTitle.add(title)
    }

    override fun createFragment(position: Int): Fragment {
        return listFragmnet.get(position)
    }

    fun getPageTitle(position: Int): String {
        return fragmentTitle.get(position)
    }
}
