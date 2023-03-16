package com.kroger.classdemoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kroger.classdemoapp.ui.ExercideFragment

class ExerciseAdapter(private val exerciseItem: List<Exercise>) :
    RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_card_view, parent, false)
        return ExerciseViewHolder(view) { position ->
            val exercise = exerciseItem[position]

            val bundle = bundleOf(
                "name" to exercise.name,
                "subGroup" to exercise.subGroup,
                "image" to exercise.image,
                "desc" to exercise.desc
            )

            val detailFragment = ExercideFragment()
            detailFragment.arguments = bundle

            val activity = view.context as AppCompatActivity

            activity.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, detailFragment)
                addToBackStack(null)
            }
        }
    }

    override fun getItemCount() = exerciseItem.size

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val exercise = exerciseItem[position]
        Glide
            .with(holder.itemView.context)
            .load(exercise.image)
            .into(holder.exerciseImage)

        holder.exerciseName.text = exercise.name
        holder.exerciseSubgroup.text = exercise.subGroup
    }

    inner class ExerciseViewHolder(
        itemView: View,
        private val onItemClick: (adapterPosition: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        val exerciseImage: ImageView = itemView.findViewById(R.id.character_image)
        val exerciseName: TextView = itemView.findViewById(R.id.character_name)
        val exerciseSubgroup: TextView = itemView.findViewById(R.id.sub_group)

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }
    }
}
