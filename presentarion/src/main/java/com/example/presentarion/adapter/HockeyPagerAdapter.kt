package com.example.presentarion.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.HockeyTutorial
import com.example.presentarion.databinding.ItemVp2InfoBinding


class HockeyPagerAdapter : ListAdapter<HockeyTutorial, HockeyPagerAdapter.VPHolder>(VPDiffutil()) {
    inner class VPHolder(private val binding: ItemVp2InfoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: HockeyTutorial) {
            binding.tvTutorialHockey.text = model.function
            binding.tvTutorialHockey1.text = model.teamName
            binding.tvTutorialHockey3.text = model.playerTeam.toString()
            binding.tvTutorialHockey2.text = model.position
            Log.e("HockeyPagerAdapter", "Binding item at position $adapterPosition: $model")
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VPHolder {
        return VPHolder(ItemVp2InfoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VPHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class VPDiffutil: DiffUtil.ItemCallback<HockeyTutorial>() {
    override fun areItemsTheSame(oldItem: HockeyTutorial, newItem: HockeyTutorial): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HockeyTutorial, newItem: HockeyTutorial): Boolean {
        return oldItem == newItem
    }

}
