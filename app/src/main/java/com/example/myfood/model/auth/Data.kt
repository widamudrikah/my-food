package com.example.myfood.model.auth

import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("user_status")
	val userStatus: String? = null,

	@field:SerializedName("user_nama")
	val userNama: String? = null,

	@field:SerializedName("user_email")
	val userEmail: String? = null,

	@field:SerializedName("user_password")
	val userPassword: String? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("user_hp")
	val userHp: String? = null
)