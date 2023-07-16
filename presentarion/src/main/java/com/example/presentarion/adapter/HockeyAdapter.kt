package com.example.presentarion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.HockeyTeamModel
import com.example.presentarion.databinding.ItemGameScoreBinding
import com.example.presentarion.model.HockeyScoreModel

class HockeyAdapter:ListAdapter<HockeyScoreModel, HockeyAdapter.HockeyViewHolder>(HockeyDiffutil()) {


    inner class HockeyViewHolder (private val binding: ItemGameScoreBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(model: HockeyScoreModel) {
            binding.tvPart.text = model.part.toString()
            binding.tvScoreTeamSecond.text = model.scoreSecondTeam.toString()
            binding.tvScoreTeamFirst.text = model.scoreFirstTeam.toString()
            binding.tvTime.text = model.time.toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HockeyViewHolder {
        return HockeyViewHolder(ItemGameScoreBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HockeyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class HockeyDiffutil:DiffUtil.ItemCallback<HockeyScoreModel>() {
    override fun areItemsTheSame(oldItem: HockeyScoreModel, newItem: HockeyScoreModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HockeyScoreModel, newItem: HockeyScoreModel): Boolean {
        return oldItem == newItem
    }

}
