package com.example.order_20200926.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.order_20200926.R
import com.example.order_20200926.data.PizzaStore

class PizzaStoreListAdapter(
    mContext: Context, // 어디서 사용되는지?
    resId: Int,
    mList: ArrayList<PizzaStore>
) : ArrayAdapter<PizzaStore>(mContext, resId, mList) {

    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if (convertView == null) {
            tempRow = inf.inflate(R.layout.pizza_list_item, null)
        }

        val row = tempRow!!

        val pizzaStore = this.getItem(position)!!

        row.findViewById<TextView>(R.id.storeName).text = pizzaStore.title
        val logoImageView = row.findViewById<ImageView>(R.id.pizzaStoreLogo)

        Glide.with(context)
            .load(pizzaStore.logoSource)
            .into(logoImageView)

        return row
    }


}