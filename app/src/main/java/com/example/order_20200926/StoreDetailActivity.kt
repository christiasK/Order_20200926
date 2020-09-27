package com.example.order_20200926

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.order_20200926.data.PizzaStore
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_store_detail.*

class StoreDetailActivity : BaseActivity() {

    lateinit var pizzaStore: PizzaStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_detail)

        setup()
    }


    override fun setEvents() {
        detailPizzaStoreCalling.setOnClickListener {
            val pl = object : PermissionListener {
                override fun onPermissionGranted() {
                    val phoneNumber = pizzaStore.callNumber
                    val uri = Uri.parse("tel:$phoneNumber")
                    val intent = Intent(Intent.ACTION_CALL, uri)

                    startActivity(intent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(getContext(), "Permission Denied\n${deniedPermissions.toString()}", Toast.LENGTH_SHORT).show()
                }
            }

            TedPermission.with(this)
                .setPermissionListener(pl)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }

        detailPizzaStoreHomepageLinking.setOnClickListener {
            val pl = object : PermissionListener {
                override fun onPermissionGranted() {
                    val uri = Uri.parse(pizzaStore.homepage)
                    val intent = Intent(Intent.ACTION_VIEW, uri)

                    startActivity(intent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(getContext(), "Permission Denied\n${deniedPermissions.toString()}", Toast.LENGTH_SHORT).show()
                }
            }

            TedPermission.with(this)
                .setPermissionListener(pl)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.INTERNET)
                .check()
        }
    }

    override fun setValues() {
        pizzaStore = intent.getSerializableExtra("data") as PizzaStore

        Glide.with(getContext()).load(pizzaStore.logoSource).into(detailPizzaStoreLogo)
        detailPizzaStoreTitle.text = pizzaStore.title
        detailPizzaStoreCallNumber.text = pizzaStore.callNumber
        detailPizzaStoreHomepageUrl.text = pizzaStore.homepage

    }
}