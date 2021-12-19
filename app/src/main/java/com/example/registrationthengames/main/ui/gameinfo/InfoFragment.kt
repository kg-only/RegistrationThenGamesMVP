package com.example.registrationthengames.main.ui.gameinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.registrationthengames.adapter.MyAdapterForScreenshots
import com.example.registrationthengames.databinding.FragmentInfoBinding
import com.example.registrationthengames.main.modelGames.GameResult
import com.squareup.picasso.Picasso

private lateinit var binding: FragmentInfoBinding
private lateinit var adapter: MyAdapterForScreenshots

private lateinit var data: GameResult

class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
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

        adapter = MyAdapterForScreenshots()
        binding.recyclerScreenshots.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerScreenshots.adapter = adapter

        val screenshots = data.screenshots.map { it.imageUrlScreen }

        adapter.setItems(screenshots)


    }
}

