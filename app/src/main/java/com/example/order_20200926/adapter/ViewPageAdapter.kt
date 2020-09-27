package com.example.order_20200926.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.order_20200926.fragments.MyInfoFragment
import com.example.order_20200926.fragments.QRCodeFragment
import com.example.order_20200926.fragments.StoreListFragment
import com.example.order_20200926.fragments.WebViewFragment

class ViewPageAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> {
                "피자주문"
            }
            1 -> {
                "내 정보 설정"
            }
            2 -> {
                "QR CODE"
            }
            else -> {
                "네이버"
            }
        }
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                StoreListFragment()
            }
            1 -> {
                MyInfoFragment()
            }
            2 -> {
                QRCodeFragment()
            }
            else -> {
                WebViewFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 4
    }
}