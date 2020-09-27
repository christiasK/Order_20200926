package com.example.order_20200926

import android.os.Bundle
import com.example.order_20200926.adapter.ViewPageAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
    }

    override fun setEvents() {
    }

    override fun setValues() {
        mainViewPager.adapter = ViewPageAdapter(supportFragmentManager)
        mainTabLayout.setupWithViewPager(mainViewPager)
    }
}