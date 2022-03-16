package com.adresto.carfaxtechnicalassignment.api.client

import com.adresto.carfaxtechnicalassignment.BuildConfig
import com.adresto.carfaxtechnicalassignment.api.service.ListingService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.File
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private fun provideOkHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private fun provideOkHttpCache(): Cache {
        return Cache(File("/cache"), 2000);
    }

    private fun provideOkHttpClient(logger: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        val client = OkHttpClient().newBuilder()
            .cache(cache)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
        if (BuildConfig.DEBUG)
            client.addInterceptor(interceptor = logger)
        return client.build()
    }

    private fun provideGson(): Gson {
        return GsonBuilder()
            .enableComplexMapKeySerialization()
            .serializeNulls()
            .setPrettyPrinting()
            .setLenient()
            .create()
    }

    private fun provideRetrofitClient(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://carfax-for-consumers.firebaseio.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }


    private val client = provideRetrofitClient(
        provideOkHttpClient(
            provideOkHttpLoggingInterceptor(),
            provideOkHttpCache()
        ),
        provideGson()
    )

    val listingService = client.create(ListingService::class.java)

}