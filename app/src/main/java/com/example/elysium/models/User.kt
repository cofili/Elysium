package com.example.elysium.models

data class UserResponse(
    val count: Int,
    val data: ArrayList<User>,
    val error: Boolean
)

data class User(
    //val __v: Int? = null,
    val _id: String? = null,
    val createdAt: String? = null,
    val email: String? = null,
    val landlordEmail: String? = null,
    val name: String? = null,
    val password: String? = null,
    val type: String? = null
)