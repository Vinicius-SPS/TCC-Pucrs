package com.example.projet_tcc_pucrs_2024.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projet_tcc_pucrs_2024.R
import com.example.projet_tcc_pucrs_2024.databinding.ActivityLoginBinding
import com.example.projet_tcc_pucrs_2024.databinding.ActivityRegisterBinding
import com.example.projet_tcc_pucrs_2024.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding
    private lateinit var viewModel : RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = RegisterViewModel()
        setButtons()
    }

    private fun setButtons() {
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
            finish()
        }

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, WelcomeActivity::class.java))
            finish()
        }

        binding.btnRegister.setOnClickListener {
            if (viewModel.doRegister(binding.textInputEmail.text,
                    binding.textInputPassword.text,
                    binding.textInputConfirmPassword.text)){
                startActivity(Intent(this@RegisterActivity, CreateProfileNameActivity::class.java))
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

                if (!viewModel.getIsConfirmPasswordValid()) {
                    binding.fieldTextInputConfirmPassword.error = viewModel.getConfirmPasswordError()
                }
                else{
                    binding.fieldTextInputConfirmPassword.error = null
                }

            }

        }
    }
}