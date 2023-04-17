package com.deanuharatinu.moviedatabase.common.data.remote

import com.deanuharatinu.moviedatabase.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {
  fun movieApi(retrofit: Retrofit): MovieDatabaseApi {
    return retrofit
      .create(MovieDatabaseApi::class.java)
  }

  fun retrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .baseUrl(ApiConstants.BASE_ENDPOINT)
      .client(okHttpClient)
      .addConverterFactory(MoshiConverterFactory.create())
      .build()
  }

  fun okhttpClient(): OkHttpClient {
    val httpLogging = HttpLoggingInterceptor()
    if (BuildConfig.DEBUG) {
      httpLogging.setLevel(HttpLoggingInterceptor.Level.HEADERS)
      httpLogging.setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    return OkHttpClient.Builder()
      .addInterceptor(httpLogging)
      .build()
  }
}