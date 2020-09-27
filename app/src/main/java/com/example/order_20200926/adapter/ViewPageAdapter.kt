package com.example.order_20200926.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.order_20200926.fragments.MyInfoFragment
import com.example.order_20200926.fragments.StoreListFragment

class ViewPageAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> {
                "피자주문"
            }
            else -> {
                "내 정보 설정"
            }
        }
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                StoreListFragment()
            }
            else -> {
                MyInfoFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }
}