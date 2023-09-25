package com.example.cocktails.core.di.subcomponent

import com.example.cocktails.presentation.main.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface MainActivitySubcomponent: AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory: AndroidInjector.Factory<MainActivity> {}
}