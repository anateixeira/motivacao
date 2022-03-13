package br.com.acvt.motivacao.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.acvt.motivacao.R
import br.com.acvt.motivacao.databinding.InitialFragmentBinding
import br.com.acvt.motivacao.model.MotivationShared

class PhraseScreenFragment : Fragment(), View.OnClickListener {

    private lateinit var viewModel: PhraseScreenViewModel
    private lateinit var binding: InitialFragmentBinding
    private var mMotivationShared: MotivationShared? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(PhraseScreenViewModel::class.java)
        binding = InitialFragmentBinding.inflate(inflater, container, false)
        mMotivationShared = activity?.let { MotivationShared(it) }
        binding.tvNameUserLogged.text = getUserLogged()
        return binding.root
    }

    override fun onClick(view: View) {
        val idComponenteLayout = view.id
        when (idComponenteLayout) {
            R.id.btNewPhrase -> {
            }
            else -> {

            }
        }
    }

    private fun getUserLogged() = mMotivationShared?.getString(MotivationShared.KEY_USERNAME)


}

