package com.example.projet_tcc_pucrs_2024.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projet_tcc_pucrs_2024.R
import com.example.projet_tcc_pucrs_2024.databinding.ActivityForgotPasswordBinding
import com.example.projet_tcc_pucrs_2024.databinding.ActivityLoginBinding
import com.example.projet_tcc_pucrs_2024.viewmodel.ForgotPasswordViewModel
import com.example.projet_tcc_pucrs_2024.viewmodel.LoginViewModel

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgotPasswordBinding
    private lateinit var viewModel: ForgotPasswordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ForgotPasswordViewModel()
        setButtons()
    }

    private fun setButtons() {
        binding.btnSend.setOnClickListener {
            if (viewModel.doSendPasswordRecovery(binding.textInputEmail.text)) {
                startActivity(Intent(this@ForgotPasswordActivity, WelcomeActivity::class.java))
                finish()
            }
            else{
                if(!viewModel.getIsEmailValid()) {
                    binding.fieldTextInputEmail.error = viewModel.getEmailError()
                }
                else{
                    binding.fieldTextInputEmail.error = null
                }
            }
        }

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this@ForgotPasswordActivity, LoginActivity::class.java))
            finish()
        }



    }
}