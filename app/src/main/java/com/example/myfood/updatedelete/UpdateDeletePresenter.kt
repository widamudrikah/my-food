package com.example.myfood.updatedelete

import com.example.myfood.api.ApiConfig
import com.example.myfood.base.BasePresenter
import com.example.myfood.model.ResponseGetFood
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateDeletePresenter(var updateDeleteView: UpdateDeleteActivity) : BasePresenter<UpdateDeleteConstruct.View>, UpdateDeleteConstruct.Presenter {

    override fun deleteDataFood(id: String) {
        ApiConfig.service.deleteFood(id).enqueue(object  : Callback<ResponseGetFood>{
            override fun onResponse(call: Call<ResponseGetFood>, response: Response<ResponseGetFood>) {
                if (response.isSuccessful){
                    val msg = response.body()?.pesan
                    val success = response.body()?.sukses
                    if (success == true){
                        updateDeleteView.showMessage(msg.toString())
                        updateDeleteView.taskEnd()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseGetFood>, t: Throwable) {
                updateDeleteView.showMessage(t.localizedMessage.toString())
            }

        })
    }

    override fun updateData(id: String, nameFood: String, priceFood: String, urlFood: String) {
        ApiConfig.service.updateMakanan(id, nameFood, priceFood,urlFood).enqueue(object : Callback<ResponseGetFood>{
            override fun onResponse(call: Call<ResponseGetFood>, response: Response<ResponseGetFood>) {
                if (response.isSuccessful){
                    val msg = response.body()?.pesan
                    val success = response.body()?.sukses
                    if (success == true){
                        updateDeleteView.showMessage(msg.toString())
                        updateDeleteView.taskEnd()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseGetFood>, t: Throwable) {
                updateDeleteView.showMessage(t.localizedMessage.toString())
            }

        })


    }

}