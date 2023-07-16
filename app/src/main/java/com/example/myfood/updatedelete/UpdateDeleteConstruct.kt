package com.example.myfood.updatedelete

import com.example.myfood.base.BaseView

interface UpdateDeleteConstruct {

    interface View : BaseView {

    }

    interface  Presenter {
        fun deleteDataFood(id :String)
        fun updateData(id: String, nameFood: String, priceFood: String, urlFood: String)
    }
}