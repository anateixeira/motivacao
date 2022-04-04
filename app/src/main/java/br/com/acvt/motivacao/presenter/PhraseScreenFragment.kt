package br.com.acvt.motivacao.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.acvt.motivacao.R
import br.com.acvt.motivacao.data.Mock
import br.com.acvt.motivacao.databinding.InitialFragmentBinding
import br.com.acvt.motivacao.data.repository.MotivationShared
import br.com.acvt.motivacao.data.PHRASEFILTER
import br.com.acvt.motivacao.domain.PhrasesUsecase

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
        binding.apply {
            tvNameUserLogged.text = getUserLogged()
            btAll.setOnClickListener(this@PhraseScreenFragment)
            btHappy.setOnClickListener(this@PhraseScreenFragment)
            btMorning.setOnClickListener(this@PhraseScreenFragment)
            btNewPhrase.setOnClickListener(this@PhraseScreenFragment)
        }

        handleNewPhrase()

        return binding.root
    }

    override fun onClick(view: View) {
        val idComponenteLayout = view.id
        setDefaultColorButton()
        when (idComponenteLayout) {
            R.id.btNewPhrase -> {
                handleNewPhrase();
            }
            R.id.btAll -> {
                binding.btAll.setColorFilter(resources.getColor(R.color.button_selected))
                handleFilter(PHRASEFILTER.ALL)
            }
            R.id.btHappy -> {
                binding.btHappy.setColorFilter(resources.getColor(R.color.button_selected))
                handleFilter(PHRASEFILTER.HAPPY)
            }
            R.id.btMorning -> {
                binding.btMorning.setColorFilter(resources.getColor(R.color.button_selected))
                handleFilter(PHRASEFILTER.MORNING)
            }
        }
    }

    private fun setDefaultColorButton(){
        binding.apply {
            btAll.setColorFilter(resources.getColor(R.color.white))
            btHappy.setColorFilter(resources.getColor(R.color.white))
            btMorning.setColorFilter(resources.getColor(R.color.white))
        }
    }

    private fun getUserLogged() = mMotivationShared?.getString(MotivationShared.KEY_USERNAME)


    fun handleNewPhrase() {
        val phrase = PhrasesUsecase(Mock.phrasesMock()).getPhrase(PHRASEFILTER.ALL)
        binding.tvFrase.text = phrase
    }

    fun handleFilter(typeFilter: Int){
        val phrase = PhrasesUsecase(Mock.phrasesMock()).getPhrase(typeFilter)
        binding.tvFrase.text = phrase
    }

}

