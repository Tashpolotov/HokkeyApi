package com.example.presentarion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.GameAvailable
import com.example.domain.model.HockeyGame
import com.example.presentarion.databinding.ItemGameScoreBinding
import com.example.presentarion.fragment.HomeFragment

class HockeyPasteGameAdapter(var onClick: (id: String) -> Unit )
    :ListAdapter<GameAvailable, HockeyPasteGameAdapter.PasteGameViewHolder>(PasteGameDiffutil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PasteGameViewHolder {
        return PasteGameViewHolder(
            ItemGameScoreBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PasteGameViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PasteGameViewHolder(private val binding: ItemGameScoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: GameAvailable) {
            when (model) {
                is GameAvailable.OpenGame -> {
                    // Обработка для открытой игры
                    val game = model.game
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
                itemView.setOnClickListener {
                    when (model) {
                        is GameAvailable.OpenGame -> onClick(model.game.id)
                        is GameAvailable.HiddenGame -> onClick(model.id)
                    }

                }
        }
    }
}

class PasteGameDiffutil:DiffUtil.ItemCallback<GameAvailable>() {
    override fun areItemsTheSame(oldItem: GameAvailable, newItem: GameAvailable): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: GameAvailable, newItem: GameAvailable): Boolean {
        return oldItem == newItem
    }

}
