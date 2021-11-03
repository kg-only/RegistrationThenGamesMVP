package com.example.registrationthengames.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.registrationthengames.databinding.FragmentTestBinding
import com.example.registrationthengames.modelGames.GameResult

private lateinit var dataResult: GameResult
private lateinit var binding: FragmentTestBinding

class TestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestBinding.inflate(inflater, container, false)
//        dataResult = requireArguments().getParcelable("results")!!
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.test1.text = dataResult.name
    }
}