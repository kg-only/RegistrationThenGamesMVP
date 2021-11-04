package com.example.registrationthengames.fragment

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.registrationthengames.R
import com.example.registrationthengames.databinding.FragmentInfoBinding
import com.example.registrationthengames.modelGames.GameResult
import com.squareup.picasso.Picasso

private lateinit var binding: FragmentInfoBinding
private lateinit var data: GameResult

@SuppressLint("StaticFieldLeak")

class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        data = requireArguments().getParcelable("results")!!
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Picasso.get().load(data.imageUrl).into(binding.image)
        binding.name.text = data.name
        binding.id.text = data.gameId.toString()
        binding.released.text = data.released
        binding.ratingBar.rating = data.rating
        binding.ratingBarTop.rating = data.ratingTop
        binding.ratingBarCount.rating = data.ratingsCount.toFloat()



    }
}