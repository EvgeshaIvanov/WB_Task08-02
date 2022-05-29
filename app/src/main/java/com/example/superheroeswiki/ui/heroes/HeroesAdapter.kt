package com.example.superheroeswiki.ui.heroes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroeswiki.R
import com.example.superheroeswiki.databinding.ItemListMainBinding
import com.example.superheroeswiki.model.HeroData
import com.squareup.picasso.Picasso

class HeroesAdapter : RecyclerView.Adapter<HeroesViewHolder>() {

    var onClickHeroListener: ((HeroData) -> Unit)? = null

    var list = emptyList<HeroData>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListMainBinding.inflate(layoutInflater, parent, false)
        return HeroesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        val hero = list[position]
        with(holder.binding) {
            heroName.text = hero.name
            setImage(hero.image.url, heroImage)
            heroCardView.setOnClickListener {
                onClickHeroListener?.invoke(hero)
            }
        }
    }

    override fun getItemCount(): Int = list.size

    private fun setImage(url: String, imageView: ImageView) {
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .resize(200, 200)
            .centerCrop()
            .error(R.drawable.ic_launcher_foreground)
            .into(imageView)
    }

}