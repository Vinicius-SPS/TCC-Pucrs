package com.example.projet_tcc_pucrs_2024.model

class User {
    private var uuid: String = ""
    private var email: String = ""
    private var password: String = ""
    private var cellphone: String = ""

    fun setUuid(uuid: String){
        this.uuid = uuid
    }

    fun setEmail(email: String){
        this.email = email
    }


    fun setPassword(password: String){
        this.password = password
    }

    fun setCellphone(cellphone: String){
        this.cellphone = cellphone
    }

    fun getUuid(uuid: String): String{
        return uuid
    }

    fun getEmail(): String{
        return email
    }

    fun getPassword(): String{
        return password
    }

    fun getCellphone(): String{
        return cellphone
    }
}