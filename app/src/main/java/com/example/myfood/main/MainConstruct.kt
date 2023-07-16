package com.example.myfood.main

import com.example.myfood.base.BaseView
import com.example.myfood.model.DataItem
import com.example.myfood.model.ResponseGetFood

interface MainConstruct {
    interface view : BaseView {
        fun showDataFood(dataFood: List<DataItem?>?)
    }

    interface  Presenter{
        fun getAllFood()
        fun tambahDataMakanan(namaMakanan: String, hargaMakanan: String, gambarMakanan: String)
    }

}