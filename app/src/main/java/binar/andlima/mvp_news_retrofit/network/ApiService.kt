package binar.andlima.mvp_news_retrofit.network

import binar.andlima.mvp_news_retrofit.model.getAllNewsItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("news")
    fun getAllNews() : Call<List<getAllNewsItem>>

}