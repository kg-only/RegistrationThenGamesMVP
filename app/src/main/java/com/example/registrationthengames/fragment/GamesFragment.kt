package com.example.registrationthengames.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.registrationthengames.R
import com.example.registrationthengames.adapter.MyAdapter
import com.example.registrationthengames.adapter.MySecondAdapter
import com.example.registrationthengames.adapter.MyThirdAdapter
import com.example.registrationthengames.base.BaseFragment
import com.example.registrationthengames.databinding.FragmentGamesBinding
import com.example.registrationthengames.modelGames.GameResult
import com.example.registrationthengames.modelGames.GamesResponse
import com.example.registrationthengames.retrofit.RetrofitService
import com.example.registrationthengames.utils.Common
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var service: RetrofitService
private lateinit var adapter: MyAdapter
private lateinit var adapterSecond: MySecondAdapter
private lateinit var adapterThird: MyThirdAdapter
private lateinit var binding: FragmentGamesBinding

class GamesFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        service = Common.retrofitService
        ////first adapter
        adapter = MyAdapter(onClick = { startInfoFragment(it) })
        binding.recycler1ViewHero.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recycler1ViewHero.adapter = adapter
        ////second adapter
        adapterSecond = MySecondAdapter(onClick = { startInfoFragment(it) })
        binding.recycler2ViewHero.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recycler2ViewHero.adapter = adapterSecond
        ////third adapter
        adapterThird = MyThirdAdapter(onClick = { startInfoFragment(it) })
        binding.recycler3ViewHero.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recycler3ViewHero.adapter = adapterThird

        getGames()
    }

    private fun getGames() {
        service.getGames(
            2, 4, null, null, null
        ).enqueue(object : Callback<GamesResponse> {
            override fun onResponse(call: Call<GamesResponse>, response: Response<GamesResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()
                    adapter.setItems(data!!.results)
                    adapterSecond.setItems(data.results)
                    adapterThird.setItems(data.results)
                }
            }

            override fun onFailure(call: Call<GamesResponse>, t: Throwable) {
                Log.e("Error from response", "error!!!!", t)
                Toast.makeText(
                    requireContext(),
                    "We`ve some error${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
    }

    private fun startInfoFragment(results: GameResult) {
        Log.e("###", "FirstPoint")
        val data = Bundle()
        data.putParcelable("results", results)
        val infoFragment = InfoFragment()
        infoFragment.arguments = data
        changeFragment(infoFragment, R.id.frame_layout)

    }

}