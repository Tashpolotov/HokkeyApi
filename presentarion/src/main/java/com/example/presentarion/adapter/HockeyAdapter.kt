package com.example.presentarion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.HockeyTeamModel
import com.example.presentarion.databinding.ItemGameScoreBinding
import com.example.presentarion.model.HockeyScoreModel
class HockeyAdapter : ListAdapter<HockeyScoreModel, HockeyAdapter.HockeyViewHolder>(HockeyDiffutil()) {
    private var hockeyScoreList: List<HockeyScoreModel> = emptyList()

    inner class HockeyViewHolder(private val binding: ItemGameScoreBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: HockeyScoreModel) {
            binding.tvPart.text = model.part.toString()
            binding.tvScoreTeamSecond.text = model.scoreSecondTeam.toString()
            binding.tvScoreTeamFirst.text = model.scoreFirstTeam.toString()
            binding.tvTime.text = model.time.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HockeyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemGameScoreBinding.inflate(inflater, parent, false)
        return HockeyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HockeyViewHolder, position: Int) {
        holder.bind(hockeyScoreList[position])
    }

    override fun getItemCount(): Int {
        return hockeyScoreList.size
    }

    fun sumitList(list: List<HockeyScoreModel>) {
        hockeyScoreList = list
        notifyDataSetChanged()
    }
}

class HockeyDiffutil : DiffUtil.ItemCallback<HockeyScoreModel>() {
    override fun areItemsTheSame(oldItem: HockeyScoreModel, newItem: HockeyScoreModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HockeyScoreModel, newItem: HockeyScoreModel): Boolean {
        return oldItem == newItem
    }
}