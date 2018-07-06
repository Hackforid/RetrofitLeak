package com.smilehacker.retrofitleak

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Client {

    val API by lazy { buildService() }

    private fun buildService() = Retrofit.Builder()
                .baseUrl("http://reload.kwai.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(OkHttpClient())
                .build()
                .create(ApiService::class.java)
}