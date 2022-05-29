package com.example.superheroeswiki

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroeswiki.databinding.ItemListMainBinding
import com.example.superheroeswiki.model.HeroData
import com.squareup.picasso.Picasso

class HeroesAdapter : RecyclerView.Adapter<HeroesAdapter.HeroViewHolder>() {

    var onClickHeroListener: ((HeroData) -> Unit)? = null

    var list = emptyList<HeroData>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListMainBinding.inflate(layoutInflater, parent, false)
        return HeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
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

    class HeroViewHolder(val binding: ItemListMainBinding) : RecyclerView.ViewHolder(binding.root)
}