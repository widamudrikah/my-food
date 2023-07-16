package com.example.myfood.main

import com.example.myfood.api.ApiConfig
import com.example.myfood.base.BasePresenter
import com.example.myfood.model.ResponseGetFood
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(var  mainView: MainActivity) : BasePresenter<MainConstruct.view>, MainConstruct.Presenter{

    override fun getAllFood() {
        ApiConfig.service.getFood().enqueue(object  : Callback<ResponseGetFood> {
            override fun onResponse(call: Call<ResponseGetFood>, response: Response<ResponseGetFood>) {
                if (response.isSuccessful){
                    val msg = response.body()?.pesan
                    val success = response.body()?.sukses
                    if (success == true){
                        val dataMakanan = response.body()?.data
                        mainView?.tampilDataMakanan(dataMakanan)
                        mainView.showError(msg)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseGetFood>, t: Throwable) {
                mainView.showError(t.localizedMessage)
            }

        })
    }

   override fun tambahDataMakanan(namaMakanan: String, hargaMakanan: String, gambarMakanan: String){
        ApiConfig.service.insertMakanan(namaMakanan, hargaMakanan, gambarMakanan).enqueue(object : Callback<ResponseGetFood>{
            override fun onResponse(call: Call<ResponseGetFood>, response: Response<ResponseGetFood>) {
                if (response.isSuccessful){
                    val msg = response.body()?.pesan
                    val success = response.body()?.sukses
                    if (success == true){
                        mainView?.onSuccessInsert()
                        mainView.showError(msg.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ResponseGetFood>, t: Throwable) {
                mainView.showError(t.localizedMessage)
            }
        })
    }
}