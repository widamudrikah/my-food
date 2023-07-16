package com.example.myfood.updatedelete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.myfood.R
import com.example.myfood.databinding.ActivityUpdateDeleteBinding
import com.example.myfood.model.DataItem

class UpdateDeleteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateDeleteBinding
    var updateDeletePresenter: UpdateDeletePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val terimaData = intent.getParcelableExtra<DataItem>("DTL")

        Glide.with(this)
            .load(terimaData?.menuGambar.toString())
            .error(R.drawable.ic_launcher_background)
            .into(binding.imgUpdate)

        binding.edtUpdateMakanan.setText(terimaData?.menuNama.toString())
        binding.edtUpdateHarga.setText(terimaData?.menuHarga.toString())
        binding.edtUpdateUrlGambar.setText(terimaData?.menuGambar.toString())

        binding.btnUpdate.setOnClickListener {
//            val id = terimaData?.menuId.toString()
//            val nameFood = binding.edtUpdateMakanan.text.toString()
//            val priceFood = binding.edtUpdateHarga.text.toString()
//            val urlFood = binding.edtUpdateUrlGambar.text.toString()
            updateDeletePresenter?.updateData(terimaData?.menuId.toString(),
                                                binding.edtUpdateMakanan.text.toString(),
                                                binding.edtUpdateHarga.text.toString(),
                                                binding.edtUpdateUrlGambar.text.toString()
            )
        }
        binding.btnDelete.setOnClickListener {
            val updateDeletePresenter = UpdateDeletePresenter(this)
            updateDeletePresenter.deleteDataFood(terimaData?.menuId.toString())
        }


    }

    fun showMessage(msg : String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    fun taskEnd() {
        finish()
    }
}