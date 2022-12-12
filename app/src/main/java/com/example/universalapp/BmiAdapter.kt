package com.example.universalapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.universalapp.database.BMI
import com.example.universalapp.databinding.BmiListItemBinding

class BmiAdapter : ListAdapter<BMI, BmiAdapter.ItemHolder>(ItemComparator()) {

    class ItemHolder(private val binding: BmiListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(bmi: BMI) = with(binding){
            nameRv.text = bmi.name
            weightRv.text = bmi.weight
            heightRv.text = bmi.height
            resultRv.text = bmi.result
        }
        companion object {
            fun create(parent: ViewGroup): ItemHolder {
                return ItemHolder(BmiListItemBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false))
            }
        }
    }

    class ItemComparator : DiffUtil.ItemCallback<BMI>() {
        override fun areItemsTheSame(oldItem: BMI, newItem: BMI): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: BMI, newItem: BMI): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))
    }

}