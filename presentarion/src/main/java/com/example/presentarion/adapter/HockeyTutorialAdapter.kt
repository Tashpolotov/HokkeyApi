package com.example.presentarion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.HockeyTutorial
import com.example.presentarion.databinding.ItemTutorialBinding

class HockeyTutorialAdapter():ListAdapter<HockeyTutorial, HockeyTutorialAdapter.TutorialViewHolder>(TutorialDiffutil()) {
    inner class TutorialViewHolder(private val binding : ItemTutorialBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: HockeyTutorial) {
            binding.tvTeamName.text = model.teamName
            binding.tvTeamPlayer.text = model.playerTeam.toString()
            binding.tvPlayerPosition.text = model.position
            binding.tvPlayerTutorial.text = model.function
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TutorialViewHolder {
        return TutorialViewHolder(ItemTutorialBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TutorialViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class TutorialDiffutil:DiffUtil.ItemCallback<HockeyTutorial>() {
    override fun areItemsTheSame(oldItem: HockeyTutorial, newItem: HockeyTutorial): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HockeyTutorial, newItem: HockeyTutorial): Boolean {
        return oldItem == newItem
    }

}
