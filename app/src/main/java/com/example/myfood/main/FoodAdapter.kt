package com.example.myfood.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfood.R
import com.example.myfood.model.DataItem
import com.example.myfood.updatedelete.UpdateDeleteActivity
import java.text.NumberFormat
import java.util.*

class FoodAdapter(val  dataMakanan: List<DataItem?>?, val context: Context) :
    RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {

        class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val image = view.findViewById<ImageView>(R.id.item_img_makanan)
            val namaMakanan = view.findViewById<TextView>(R.id.item_nama_makanan)
            val hargaMakanan = view.findViewById<TextView>(R.id.item_harga_makanan)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row_makanan, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.namaMakanan.text = dataMakanan?.get(position)?.menuNama
//        holder.hargaMakanan.text = dataMakanan?.get(position)?.menuHarga
        val harga = dataMakanan?.get(position)?.menuHarga
        holder.hargaMakanan.text = NumberFormat.getCurrencyInstance(Locale("in", "ID")).format(Integer.valueOf(harga))

        Glide.with(context)
            .load(dataMakanan?.get(position)?.menuGambar)
            .error(R.drawable.ic_launcher_background)
            .into(holder.image)

        holder.itemView.setOnClickListener {
            val i = Intent(context, UpdateDeleteActivity::class.java)
            i.putExtra("DTL", dataMakanan?.get(position))
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return dataMakanan?.size!!
    }
}