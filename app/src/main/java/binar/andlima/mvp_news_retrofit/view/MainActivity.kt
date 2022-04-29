package binar.andlima.mvp_news_retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import binar.andlima.mvp_news_retrofit.R
import binar.andlima.mvp_news_retrofit.model.getAllNewsItem
import binar.andlima.mvp_news_retrofit.presenter.NewsPresenter
import binar.andlima.mvp_news_retrofit.presenter.NewsView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsView{

    private lateinit var newsPresenter : NewsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsPresenter = NewsPresenter(this)
        newsPresenter.getNews()

    }

    override fun onSuccess(meg: String, news: List<getAllNewsItem>) {
        for (i in news.indices){
            Log.d("news", news.get(i).title)
        }
        rvnews.layoutManager= LinearLayoutManager(this)
        rvnews.adapter = NewsAdapter(news)
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }



}