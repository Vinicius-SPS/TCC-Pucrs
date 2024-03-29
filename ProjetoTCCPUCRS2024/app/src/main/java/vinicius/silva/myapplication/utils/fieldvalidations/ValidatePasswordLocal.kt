package com.example.projet_tcc_pucrs_2024.utils.fieldvalidations

import android.text.Editable
import android.util.Patterns

class ValidatePasswordLocal {
    private var errorMessage: String = ""
    private var isValid: Boolean = false

    fun verifyIsPasswordEmpty(field: Editable?): Boolean {
        if(field.isNullOrEmpty()){
            errorMessage = "Campo Obrigatório."
            isValid = false
            return true
        }
        else{
            isValid = true
        }


        return false
    }



    fun verifyIsPasswordValid(field: Editable?): Boolean{
        if(field.toString().length < 6){
            errorMessage = "Senha Inválida"
            isValid = false
            return true
        }
        errorMessage = ""
        isValid = true
        return false
    }


    fun getErrorMessage():String {
        return errorMessage
    }

    fun getIsPasswordValid():Boolean{
        return isValid
    }
}