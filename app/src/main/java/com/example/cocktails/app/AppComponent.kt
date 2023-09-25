package com.example.cocktails.app

import com.example.cocktails.core.di.AndroidBindingModule
import com.example.cocktails.core.di.NavigationModule
import com.example.cocktails.presentation.main.MainActivity
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [
    AppModule::class,
    NavigationModule::class
])
@Singleton
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(app: App)

}