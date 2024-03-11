package com.example.projet_tcc_pucrs_2024.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projet_tcc_pucrs_2024.R
import com.example.projet_tcc_pucrs_2024.databinding.ActivityCreateProfileNameBinding
import com.example.projet_tcc_pucrs_2024.databinding.ActivityForgotPasswordBinding
import com.example.projet_tcc_pucrs_2024.viewmodel.CreateProfileNameViewModel
import com.example.projet_tcc_pucrs_2024.viewmodel.ForgotPasswordViewModel

class CreateProfileNameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateProfileNameBinding
    private lateinit var viewModel: CreateProfileNameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateProfileNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = CreateProfileNameViewModel()
        setButtons()
    }

    private fun setButtons() {
        binding.btnSend.setOnClickListener {
            if (viewModel.doVerifyName(binding.textInputName.text)) {
                startActivity(Intent(this@CreateProfileNameActivity, WelcomeActivity::class.java))
                finish()
            } else {
                if (!viewModel.getIsNameValid()) {
                    binding.fieldTextInputName.error = viewModel.getNameError()
                } else {
                    binding.fieldTextInputName.error = null
                }
            }
        }

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this@CreateProfileNameActivity, WelcomeActivity::class.java))
            finish()
        }
    }
}