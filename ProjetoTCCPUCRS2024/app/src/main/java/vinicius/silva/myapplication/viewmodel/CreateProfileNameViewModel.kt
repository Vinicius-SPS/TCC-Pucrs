package com.example.projet_tcc_pucrs_2024.viewmodel

import android.text.Editable
import android.util.Log
import com.example.projet_tcc_pucrs_2024.utils.fieldvalidations.ValidateNameLocal

class CreateProfileNameViewModel {
    private var validateNameLocal : ValidateNameLocal = ValidateNameLocal()

    fun doVerifyName(name: Editable?): Boolean {
        verifyName(name)

        return validateNameLocal.getIsNameValid()
    }

    fun verifyName(email: Editable?): Boolean{
        if(validateNameLocal.verifyIsNameEmpty(email)) {
            Log.d("CreateProfileViewModel","name: " + validateNameLocal.getErrorMessage())
            return false
        }
        if(validateNameLocal.verifyIsNameValid(email)){
            Log.d("CreateProfileViewModel","name: " + validateNameLocal.getErrorMessage())
            return false
        }

        return true
    }


    fun getNameError(): String{
        return validateNameLocal.getErrorMessage()
    }

    fun getIsNameValid(): Boolean{
        return validateNameLocal.getIsNameValid()
    }

}