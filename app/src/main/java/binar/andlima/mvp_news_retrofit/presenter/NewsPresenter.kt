package binar.andlima.mvp_news_retrofit.presenter

import android.util.Log
import binar.andlima.mvp_news_retrofit.model.getAllNewsItem
import binar.andlima.mvp_news_retrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsPresenter(val news : NewsView) {

    fun getNews(){

        ApiClient.instance.getAllNews()
            .enqueue(object : Callback<List<getAllNewsItem>>{
                override fun onResponse(
                    call: Call<List<getAllNewsItem>>,
                    response: Response<List<getAllNewsItem>>
                ) {
                    if (response.isSuccessful){
                        news.onSuccess(response.message(), response.body()!!)
                        Log.d("oi", response.body().toString())
                    }else{
                        news.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<getAllNewsItem>>, t: Throwable) {
                    news.onError(t.message!!)
                }

            })
    }


}