package com.example.projet_tcc_pucrs_2024.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projet_tcc_pucrs_2024.R
import com.example.projet_tcc_pucrs_2024.databinding.ActivityLoginBinding
import com.example.projet_tcc_pucrs_2024.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = LoginViewModel()
        setButtons()
    }

    private fun setButtons() {
        binding.btnLogin.setOnClickListener {
//            if (viewModel.doLogin(binding.textInputEmail.text, binding.textInputPassword.text)) {
            if (true) {
                startActivity(Intent(this@LoginActivity, AppActivity::class.java))
                finish()
            }
            else{
                if(!viewModel.getIsEmailValid()) {
                    binding.fieldTextInputEmail.error = viewModel.getEmailError()
                }
                else{
                    binding.fieldTextInputEmail.error = null
                }

                if (!viewModel.getIsPasswordValid()) {
                    binding.fieldTextInputPassword.error = viewModel.getPasswordError()
                }
                else{
                    binding.fieldTextInputPassword.error = null
                }
            }
        }

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this@LoginActivity, WelcomeActivity::class.java))
            finish()
        }

        binding.btnRegister.setOnClickListener {
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
                finish()
        }

        binding.btnForgotPassword.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgotPasswordActivity::class.java))
            finish()
        }
    }

}