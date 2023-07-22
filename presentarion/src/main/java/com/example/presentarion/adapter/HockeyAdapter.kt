package com.example.presentarion.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.GameAvailable
import com.example.domain.model.GameState
import com.example.presentarion.databinding.ItemGameScoreBinding
import com.example.presentarion.viewmodel.HockeyViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HockeyAdapter(
    private val viewModel: HockeyViewModel,
    private val onClick: (id: String) -> Unit)
    : ListAdapter<GameAvailable, RecyclerView.ViewHolder>(HockeyDiffutil()) {

    private var coins: Int = 0

    companion object {
        private const val VIEW_TYPE_OPEN_GAME = 1
        private const val VIEW_TYPE_CLOSED_GAME = 2
    }

    inner class OpenGameViewHolder(private val binding: ItemGameScoreBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: GameAvailable.OpenGame) {
            val game = model.game
            binding.tvScoreTeamFirst.text = game?.scoreFirstTeam.toString()
            binding.tvScoreTeamSecond.text = game?.scoreSecondTeam.toString()

            val gameState = game?.stateGame
            if (gameState is GameState.LiveGame) {
                binding.tvTime.text = "Time: ${gameState.time}"
                binding.tvPart.text = "Part: ${gameState.part}"
            }

            itemView.setOnClickListener {
                val gameId = game?.id
                if (gameId != null) {
                    onClick(gameId)
                }
            }
        }
    }


    inner class ClosedGameViewHolder(private val binding: ItemGameScoreBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: GameAvailable.HiddenGame) {
            binding.tvScoreTeamFirst.text = ""
            binding.tvScoreTeamSecond.text = ""
            binding.tvPart.text = ""
            binding.tvTime.text = ""

            itemView.setOnClickListener {

                val hiddenGameId = model.id
                if(viewModel.balanceNew.value != null) {
                    GlobalScope.launch {
                        viewModel.balance.collect{
                            it?.balance
                        }
                    }
                    viewModel.unlockGame()
                    onClick(hiddenGameId)
                } else {
                    Toast.makeText(itemView.context, "Недостаточно монет", Toast.LENGTH_SHORT).show()
                }


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_OPEN_GAME -> {
                val binding = ItemGameScoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                OpenGameViewHolder(binding)
            }
            VIEW_TYPE_CLOSED_GAME -> {
                val binding = ItemGameScoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ClosedGameViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Unknown view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (item) {
            is GameAvailable.OpenGame -> {
                (holder as OpenGameViewHolder).bind(item)
            }
            is GameAvailable.HiddenGame -> {
                (holder as ClosedGameViewHolder).bind(item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return when (item) {
            is GameAvailable.OpenGame -> VIEW_TYPE_OPEN_GAME
            is GameAvailable.HiddenGame -> VIEW_TYPE_CLOSED_GAME
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
