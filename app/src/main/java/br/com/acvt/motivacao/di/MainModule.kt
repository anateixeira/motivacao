package br.com.acvt.motivacao.di

import br.com.acvt.motivacao.presenter.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel {
        SplashViewModel(get())
    }
}

//factory ou single
//reposotorio geral, que fosse utilizado por varias features, dai, nao seria o factory e sim o single

//para ser utilizado apenas 1x, por exemplo,