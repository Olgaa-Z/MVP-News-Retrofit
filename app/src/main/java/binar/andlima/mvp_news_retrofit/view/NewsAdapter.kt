package binar.andlima.mvp_news_retrofit.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.andlima.mvp_news_retrofit.R
import binar.andlima.mvp_news_retrofit.model.getAllNewsItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(private var newsdata : List<getAllNewsItem>): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return  ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.itemView.tvTitle.text= newsdata[position].title
        holder.itemView.tvDate.text = newsdata[position].createdAt
        holder.itemView.tvAuthor.text = newsdata[position].author

        Glide.with(holder.itemView.context).load(newsdata[position].image).into(holder.itemView.imgNews)

    }

    override fun getItemCount(): Int {
        return newsdata.size
    }
}