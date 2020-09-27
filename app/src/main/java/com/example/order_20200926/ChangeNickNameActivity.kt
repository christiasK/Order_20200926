package com.example.order_20200926

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_change_nick_name.*

class ChangeNickNameActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_nick_name)
        setup()
    }

    override fun setEvents() {
        changeBtn.setOnClickListener {
            if (editNickName.text.isEmpty()) {
                Toast.makeText(this, "입력된 글자가 없습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent()
            intent.putExtra("nickName", editNickName.text)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    override fun setValues() {

    }
}