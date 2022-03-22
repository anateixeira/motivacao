package br.com.acvt.motivacao.presenter

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import br.com.acvt.motivacao.utils.ValidationText
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.verifyName()?.let{
            goToNextSreen()
        }
    }

    private fun clickButton() {
        viewModel.saveName(binding.editTextTextPersonName.text.toString());
        goToNextSreen()
    }

    private fun goToNextSreen(){
        val action = SplashFragmentDirections.actionSplashFragmentToInitialFragment()
        Navigation.findNavController(binding.root).navigate(action)
    }


}