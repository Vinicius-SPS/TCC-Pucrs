package com.example.projet_tcc_pucrs_2024.viewmodel

import android.text.Editable
import android.util.Log
import com.example.projet_tcc_pucrs_2024.utils.fieldvalidations.ValidateEmailLocal
import com.example.projet_tcc_pucrs_2024.utils.fieldvalidations.ValidatePasswordLocal

class ForgotPasswordViewModel {
    private var validateEmailLocal : ValidateEmailLocal = ValidateEmailLocal()

    fun doSendPasswordRecovery(email: Editable?): Boolean {
        verifyEmail(email)

        return validateEmailLocal.getIsEmailValid()
    }

    fun verifyEmail(email: Editable?): Boolean{
        if(validateEmailLocal.verifyIsEmailEmpty(email)) {
            Log.d("loginViewModel","email: " + validateEmailLocal.getErrorMessage())
            return false
        }
        if(validateEmailLocal.verifyIsEmailValid(email)){
            Log.d("loginViewModel","email: " + validateEmailLocal.getErrorMessage())
            return false
        }

        return true
    }


    fun getEmailError(): String{
        return validateEmailLocal.getErrorMessage()
    }

    fun getIsEmailValid(): Boolean{
        return validateEmailLocal.getIsEmailValid()
    }

}