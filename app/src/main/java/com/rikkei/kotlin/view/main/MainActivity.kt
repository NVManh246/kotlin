package com.rikkei.kotlin.view.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.rikkei.kotlin.R
import com.rikkei.kotlin.base.BaseActivity
import com.rikkei.kotlin.view.browser.BrowserFragment
import com.rikkei.kotlin.view.home.HomeFragment
import com.rikkei.kotlin.view.mypage.MyPageFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val homeFragment = HomeFragment()
    private val browserFragment = BrowserFragment()
    private val myPageFragment = MyPageFragment()
    private var currentFragment = Fragment()

    override fun getLayoutId(): Int {
        return R.layout.activity_main;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, homeFragment)
            .add(R.id.container, browserFragment)
            .add(R.id.container, myPageFragment)
            .hide(browserFragment)
            .hide(myPageFragment)
            .show(homeFragment)
            .commit()
        currentFragment = homeFragment
        bottomView.setOnNavigationItemSelectedListener { menuItem -> onItemSelected(menuItem.itemId) }
    }

    private fun onItemSelected(itemId: Int): Boolean {
        when (itemId) {
            R.id.menu_home -> {
                show(homeFragment)
            }
            R.id.menu_browser -> {
                show(browserFragment)
            }
            R.id.menu_my_page -> {
                show(myPageFragment)
            }
        }
        return true;
    }

    fun show(fShow: Fragment) {
        supportFragmentManager.beginTransaction()
            .hide(currentFragment)
            .show(fShow)
            .commit()
        currentFragment = fShow
    }
}
