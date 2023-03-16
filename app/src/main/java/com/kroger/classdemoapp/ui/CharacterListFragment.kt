package com.kroger.classdemoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kroger.classdemoapp.Exercise
import com.kroger.classdemoapp.ExerciseAdapter
import com.kroger.classdemoapp.R

class CharacterListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_character_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.character_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val exerciseItem = mutableListOf<Exercise>()

        val exerciseName = mutableListOf("Bench press", "Inclined press", "Cable Flies",
            "Reverse Flies", "Shoulder press", "Lateral Raises" , "Side Raises")
        val exerciseList = mutableListOf("Back", "Triceps", "Biceps", "Shoulders", "Chest", "Legs")
        val imageList = mutableListOf("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrzdT3vEdbycdW-2BVI1ioqXnHKSmp8bvLhAX03esXApnq0U7txnf8fQCZkXrmCNUFnNs&usqp=CAU",
            "https://static.strengthlevel.com/images/illustrations/shoulder-press-1000x1000.jpg",
            "https://s3.amazonaws.com/prod.skimble/assets/1727358/image_iphone.jpg",
            "https://www.bodybuildingmealplan.com/wp-content/uploads/Dumbbell-Fly-Muscles-Worked-Image-scaled.jpg",
            "https://static.strengthlevel.com/images/illustrations/dumbbell-tricep-extension-1000x1000.jpg",
            "https://cdn.shopify.com/s/files/1/1497/9682/articles/1_5b3195aa-428f-4a61-a3d0-a0eeef1e0f8d.jpg?v=1653395154"
        )

        for (i in 0..30) {
            exerciseItem.add(
                createExerciseItem(
                    exerciseName.random(),
                    exerciseList.random(),
                    imageList.random()
                )
            )
        }

        val adapter = ExerciseAdapter(exerciseItem)
        recyclerView.adapter = adapter

        return view
    }

    private fun createExerciseItem(
        name: String, subGroup:String ,image: String
    ) = Exercise(
        name = name,
        subGroup = subGroup,
        image = image,
    )
}
