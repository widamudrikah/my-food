package com.example.myfood.main

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.GridLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myfood.R
import com.example.myfood.databinding.ActivityMainBinding
import com.example.myfood.model.DataItem

class MainActivity : AppCompatActivity() {
    var mainPresenter: MainPresenter? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainPresenter = MainPresenter(this)
        mainPresenter!!.getAllFood()

        binding.fabAdd.setOnClickListener {
            formTambahData()
        }
    }

    private fun formTambahData() {
        val alert = AlertDialog.Builder(this)
        val layout = layoutInflater.inflate(R.layout.add_data, null)
        alert.setView(layout)
        alert.setCancelable(false)
        alert.setTitle("Tambah Menu Baru")
        alert.setPositiveButton("Simpan", DialogInterface.OnClickListener { dialogInterface, i ->
            val namaMakanan = layout.findViewById<EditText>(R.id.edt_nama_makanan)
            val hargaMakanan = layout.findViewById<EditText>(R.id.edt_harga_makanan)
            val gambarMakanan = layout.findViewById<EditText>(R.id.edt_url_gambar)
            mainPresenter?.tambahDataMakanan(namaMakanan.text.toString(),hargaMakanan.text.toString(), gambarMakanan.text.toString())
            dialogInterface.dismiss()

        })
        alert.setNeutralButton("bATAL", DialogInterface.OnClickListener { dialogInterface, i ->
            Toast.makeText(this, "Ga jadi", Toast.LENGTH_SHORT).show()
        })
        alert.show()
    }

    fun showError(message: String?) {
        if (message != null){
            Log.d("Tes", message)
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun tampilDataMakanan(dataMakanan: List<DataItem?>?) {
        val adapterMakanan = FoodAdapter(dataMakanan, this)
        binding.rvMakanan.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            setHasFixedSize(true)
            adapter = adapterMakanan
        }
    }

    fun onSuccessInsert() {
        mainPresenter!!.getAllFood()
    }

    override fun onResume() {
        super.onResume()
        mainPresenter!!.getAllFood()
    }


}