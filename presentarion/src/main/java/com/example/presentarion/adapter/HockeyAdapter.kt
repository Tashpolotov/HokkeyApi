package com.example.presentarion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.HockeyModel
import com.example.presentarion.databinding.ItemGameScoreBinding

class HockeyAdapter:ListAdapter<HockeyModel, HockeyAdapter.HockeyViewHolder>(HockeyDiffutil()) {
    inner class HockeyViewHolder (private val binding: ItemGameScoreBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(model: HockeyModel) {
            binding.tvPart.text = model.part
            binding.tvScoreTeamFirst.text = model.firstTeamScore
            binding.tvScoreTeamSecond.text = model.secondTeamScore

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HockeyViewHolder {
        return HockeyViewHolder(ItemGameScoreBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HockeyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class HockeyDiffutil:DiffUtil.ItemCallback<HockeyModel>() {
    override fun areItemsTheSame(oldItem: HockeyModel, newItem: HockeyModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HockeyModel, newItem: HockeyModel): Boolean {
        return oldItem == newItem
    }

}
