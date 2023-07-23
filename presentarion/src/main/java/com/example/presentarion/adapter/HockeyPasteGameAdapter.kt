package com.example.presentarion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.GameAvailable
import com.example.presentarion.databinding.ItemPastGameBinding

class HockeyPasteGameAdapter(var onClick: (id: String) -> Unit )
    :ListAdapter<GameAvailable, HockeyPasteGameAdapter.PasteGameViewHolder>(PasteGameDiffutil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PasteGameViewHolder {
        return PasteGameViewHolder(ItemPastGameBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PasteGameViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PasteGameViewHolder(private val binding: ItemPastGameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: GameAvailable) {

            when (model) {
                is GameAvailable.OpenGame -> {

                    val game = model.game
                    binding.tvScoreTeamFirst.text = game.scoreFirstTeam.toString()
                    binding.tvScoreTeamSecond.text = game.scoreSecondTeam.toString()


                }
                is GameAvailable.HiddenGame -> {

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
