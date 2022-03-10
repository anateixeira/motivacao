package br.com.acvt.motivacao

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import br.com.acvt.motivacao.databinding.SplashFragmentBinding

class SplashFragment : Fragment() {

    private lateinit var viewModel: SplashViewModel
    private lateinit var binding: SplashFragmentBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        binding = SplashFragmentBinding.inflate(inflater, container, false)

        binding.apply {
            button.isEnabled = false
            button.setOnClickListener {
                clickButton()
            }
            editTextTextPersonName.addTextChangedListener(ValidationText(viewModel, binding))
            viewModel.errorValidation.observe(viewLifecycleOwner, Observer<Boolean> { validation ->
                button.isEnabled = !validation
            })
        }
        return binding.root
    }

    fun clickButton() {

        Toast.makeText(context, "Click Botão", Toast.LENGTH_SHORT).show()
    }

}