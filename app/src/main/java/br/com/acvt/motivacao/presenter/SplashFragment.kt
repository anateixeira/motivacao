package br.com.acvt.motivacao.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import br.com.acvt.motivacao.databinding.SplashFragmentBinding
import br.com.acvt.motivacao.utils.ValidationText
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : Fragment() {

    private val viewModel: SplashViewModel by viewModel()
    private lateinit var binding: SplashFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.verifyName()?.let {
            goToNextSreen()
        }
    }

    private fun clickButton() {
        viewModel.saveName(binding.editTextTextPersonName.text.toString());
        goToNextSreen()
    }

    private fun goToNextSreen() {
        val action = SplashFragmentDirections.actionSplashFragmentToInitialFragment()
        Navigation.findNavController(binding.root).navigate(action)
    }


}