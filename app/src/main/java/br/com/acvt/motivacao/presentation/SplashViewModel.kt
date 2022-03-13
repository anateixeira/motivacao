package br.com.acvt.motivacao.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class SplashViewModel(private val app: Application) : AndroidViewModel(app) {

    val errorValidation by lazy { MutableLiveData<Boolean>() }

    //contexto = sao as informações da sua aplicação
    fun validation(str : String){
        if(str.isEmpty()){
            errorValidation.value = true
        }else errorValidation.value = str.length < 5
    }

}