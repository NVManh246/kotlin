package com.rikkei.kotlin.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class PagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val fragments : ArrayList<Fragment> = ArrayList()
    private val titles : ArrayList<String> = ArrayList()

    override fun getItem(p0: Int): Fragment {
        return fragments.get(p0)
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles.get(position)
    }

    fun addFragment(fragment: Fragment, title : String) {
        fragments.add(fragment)
        titles.add(title)
    }
}
