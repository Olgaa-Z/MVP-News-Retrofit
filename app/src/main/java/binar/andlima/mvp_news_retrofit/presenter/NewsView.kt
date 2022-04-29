package binar.andlima.mvp_news_retrofit.presenter

import binar.andlima.mvp_news_retrofit.model.getAllNewsItem

interface NewsView {

    fun onSuccess(meg : String, news :List<getAllNewsItem>)
    fun onError(msg : String)
}