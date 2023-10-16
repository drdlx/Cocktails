package com.example.cocktails.core.di

import com.example.cocktails.BuildConfig
import com.example.cocktails.core.utils.API_KEY
import com.example.cocktails.core.utils.BASE_URL
import com.example.cocktails.core.utils.STR_SLASH
import com.example.cocktails.data.service.CocktailApiService
import com.example.cocktails.utils.navigation.AppNavigation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideNavigation(): AppNavigation = AppNavigation()

    @Provides
    @Singleton
    fun provideOKHttpClient(): OkHttpClient {
        // We need to prepare a custom OkHttp client because need to use our custom call interceptor.
        // to be able to authenticate our requests.
        val builder = OkHttpClient.Builder()
        // We add the interceptor to OkHttpClient.
        // It will add authentication headers to every call we make.
        // Configure this client not to retry when a connectivity problem is encountered.
        builder.retryOnConnectionFailure(false)
        // Log requests and responses.
        // Add logging as the last interceptor, because this will also log the information which
        // you added or manipulated with previous interceptors to your request.
        builder.interceptors().add(HttpLoggingInterceptor().apply {
            // For production environment to enhance apps performance we will be skipping any
            // logging operation. We will show logs just for debug builds.
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        })
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideApiService(httpClient: OkHttpClient): CocktailApiService {
        return Retrofit.Builder() // Create retrofit builder.
            .baseUrl(BASE_URL + API_KEY + STR_SLASH) // Base url for the api has to end with a slash.
            .addConverterFactory(GsonConverterFactory.create()) // Use GSON converter for JSON to POJO object mapping.
//            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .client(httpClient) // Here we set the custom OkHttp client we just created.
            .build()
            .create(CocktailApiService::class.java) // We create an API using the interface we defined.
    }

}