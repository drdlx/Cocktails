package com.example.cocktails.core.di

import com.example.cocktails.core.di.subcomponent.MainActivitySubcomponent
import com.example.cocktails.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class AndroidBindingModule {
//    @Binds
//    @IntoMap
//    @ClassKey(MainActivity::class)
//    abstract fun bindMainAndroidInjectorFactory(factory: MainActivitySubcomponent.Factory): AndroidInjector.Factory<*>
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

}