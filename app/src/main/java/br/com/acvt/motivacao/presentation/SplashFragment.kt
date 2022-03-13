package br.com.acvt.motivacao.presentation

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
import br.com.acvt.motivacao.model.MotivationShared

class SplashFragment : Fragment() {

    private lateinit var viewModel: SplashViewModel
    private lateinit var binding: SplashFragmentBinding

    private var mMotivationShared: MotivationShared? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        binding = SplashFragmentBinding.inflate(inflater, container, false)
        mMotivationShared = activity?.let { MotivationShared(it) }

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
        saveName(binding.editTextTextPersonName.text.toString());
        val action = SplashFragmentDirections.actionSplashFragmentToInitialFragment()
        Navigation.findNavController(binding.root).navigate(action)
    }

    fun saveName(name: String){
        mMotivationShared?.storeString(MotivationShared.KEY_USERNAME, name)
    }
}