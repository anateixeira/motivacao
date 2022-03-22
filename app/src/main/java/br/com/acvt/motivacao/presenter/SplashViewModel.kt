package br.com.acvt.motivacao.presenter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.acvt.motivacao.data.MotivationShared

class SplashViewModel(private val app: Application) : AndroidViewModel(app) {

    private var mMotivationShared: MotivationShared? = null

    val errorValidation by lazy { MutableLiveData<Boolean>() }

    fun validation(str : String){
        if(str.isEmpty()){
            errorValidation.value = true
        }else errorValidation.value = str.length < 5
    }

    fun saveName(name: String) = mMotivationShared?.storeString(MotivationShared.KEY_USERNAME, name)

    fun verifyName(): String? = mMotivationShared?.getString(MotivationShared.KEY_USERNAME)

    init {
        mMotivationShared = app?.let { MotivationShared(it) }
    }
}