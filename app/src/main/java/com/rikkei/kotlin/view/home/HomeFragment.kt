package com.rikkei.kotlin.view.home

import android.os.Bundle
import android.view.View
import com.rikkei.kotlin.R
import com.rikkei.kotlin.adapter.PagerAdapter
import com.rikkei.kotlin.base.BaseFragment
import com.rikkei.kotlin.view.home.events.NewsFragment
import com.rikkei.kotlin.view.home.news.EventsFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(){

    override fun getLayoutId(): Int {
        return R.layout.fragment_home;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PagerAdapter(fragmentManager!!)
        adapter.addFragment(NewsFragment(), "news")
        adapter.addFragment(EventsFragment(), "popular")
        pagerHome.adapter = adapter;
        tabLayout.setupWithViewPager(pagerHome)
    }
}
