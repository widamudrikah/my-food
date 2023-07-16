package com.example.myfood.model.auth

import com.google.gson.annotations.SerializedName

data class ResponseAuth(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("sukses")
	val sukses: Boolean? = null
)