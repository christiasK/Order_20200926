package com.example.order_20200926.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.order_20200926.ChangeNickNameActivity
import com.example.order_20200926.R
import kotlinx.android.synthetic.main.fragment_my_info.*

class MyInfoFragment : Fragment() {

    val REQ_FOR_NICKNAME = 100

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_info, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        changeNickNameBtn.setOnClickListener {
            val intent = Intent(context, ChangeNickNameActivity::class.java)
            startActivityForResult(intent, REQ_FOR_NICKNAME)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_FOR_NICKNAME) {
            if (resultCode == Activity.RESULT_OK) {
                nickName.text = data!!.getCharSequenceExtra("nickName")
            }
        }
    }
}