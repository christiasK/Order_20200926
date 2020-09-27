package com.example.order_20200926.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.order_20200926.R
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import java.util.*

class QRCodeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_qrcode, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(context)
        val url = "http://www.google.com"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                Log.d("웹 호출", response)
            },
            Response.ErrorListener {
                Log.e("웹 호출", "에러 발생")
            })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)

        val barcodeEncoder = BarcodeEncoder()
        val bitmap = barcodeEncoder.encodeBitmap(
            UUID.randomUUID().toString(),
            BarcodeFormat.QR_CODE,
            400,
            400
        )

        val imageViewQrCode = view!!.findViewById<ImageView>(R.id.qrcode)
        imageViewQrCode.setImageBitmap(bitmap)
    }
}