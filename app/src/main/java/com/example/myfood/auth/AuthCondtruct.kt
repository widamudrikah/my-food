package com.example.myfood.auth

import com.example.myfood.base.BaseView

interface AuthCondtruct {
    interface View : BaseView {

    }

    interface  Presenter {
        fun loginUser(email :String, password : String)
    }
}