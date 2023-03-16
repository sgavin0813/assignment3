package com.kroger.classdemoapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.kroger.classdemoapp.R

class ExercideFragment : Fragment() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_character_detail, container, false)

        if (arguments != null) {
            val name = requireArguments().getString("name")
            val image = requireArguments().getString("image")
            val subGroup = requireArguments().getString("subGroup")
            val desc = requireArguments().getString("desc")
            view.findViewById<TextView>(R.id.name_expanded).text = "Exercise Name: $name"
            view.findViewById<TextView>(R.id.sub_group_expanded).text = "Subgroup: $subGroup"
            val imageId = view.findViewById<ImageView>(R.id.image_expanded)
            Glide
                .with(view.context)
                .load(image)
                .into(imageId)
            view.findViewById<TextView>(R.id.sub_desc_expanded).text = desc
        }

        return view
    }
}
