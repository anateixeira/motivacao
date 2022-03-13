package br.com.acvt.motivacao.utils

import android.text.Editable
import android.text.TextWatcher
import br.com.acvt.motivacao.databinding.SplashFragmentBinding
import br.com.acvt.motivacao.presentation.SplashViewModel

class ValidationText(val viewModel: SplashViewModel, val binding: SplashFragmentBinding) : TextWatcher {

    override fun afterTextChanged(p0: Editable?) {
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        viewModel.validation(binding.editTextTextPersonName.text.toString())
    }
}