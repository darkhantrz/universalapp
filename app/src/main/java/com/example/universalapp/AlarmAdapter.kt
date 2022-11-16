package com.example.universalapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.universalapp.databinding.AlarmItemBinding

class AlarmAdapter: RecyclerView.Adapter<AlarmAdapter.AlarmHolder>() {
    private val alarmList = ArrayList<Alarm>()

    class AlarmHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = AlarmItemBinding.bind(item)
        fun bind(alarm: Alarm) = with(binding) {
            tvTitle.text = alarm.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.alarm_item, parent, false)
        return AlarmHolder(view)
    }

    override fun onBindViewHolder(holder: AlarmHolder, position: Int) {
        holder.bind(alarmList[position])
    }

    override fun getItemCount(): Int {
        return alarmList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAlarm(alarm: Alarm) {
        alarmList.add(alarm)
        notifyDataSetChanged()
    }
}