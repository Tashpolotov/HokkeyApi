package com.example.presentarion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.GameAvailable
import com.example.domain.model.HockeyGame
import com.example.presentarion.databinding.ItemGameScoreBinding

class HockeyAdapter:ListAdapter<GameAvailable, HockeyAdapter.HockeyViewHolder>(HockeyDiffutil()) {


    inner class HockeyViewHolder (private val binding: ItemGameScoreBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(model: GameAvailable) {
            when (model) {
                is GameAvailable.OpenGame -> {
                    // Обработка для открытой игры
                    val game = model.game
                    binding.tvTime.text = game.stateGame.toString()
                    binding.tvPart.text = game.stateGame.toString()
                    binding.tvScoreTeamFirst.text = game.scoreFirstTeam.toString()
                    binding.tvScoreTeamSecond.text = game.scoreSecondTeam.toString()
                }
                is GameAvailable.HiddenGame -> {
                    // Обработка для скрытой игры
                    binding.tvTime.text = "Hidden Game"
                    binding.tvPart.text = "Hidden Game"
                    binding.tvScoreTeamFirst.text = ""
                    binding.tvScoreTeamSecond.text = ""
                }

        }

    }
}

class HockeyDiffutil:DiffUtil.ItemCallback<GameAvailable>() {
    override fun areItemsTheSame(oldItem: GameAvailable, newItem: GameAvailable): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: GameAvailable, newItem: GameAvailable): Boolean {
        return oldItem == newItem
    }

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HockeyViewHolder {
        return HockeyViewHolder(ItemGameScoreBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HockeyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
