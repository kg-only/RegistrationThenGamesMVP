package com.example.registrationthengames.main.ui.gamelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.registrationthengames.R
import com.example.registrationthengames.adapter.MyAdapter
import com.example.registrationthengames.common.mvp.BaseFragmentMvp
import com.example.registrationthengames.databinding.FragmentGamesBinding
import com.example.registrationthengames.main.modelGames.GameResult
import com.example.registrationthengames.main.ui.gameinfo.InfoFragment
import kotlinx.coroutines.DelicateCoroutinesApi
import org.koin.android.ext.android.inject


private lateinit var adapter: MyAdapter
private lateinit var adapter2: MyAdapter
private lateinit var adapter3: MyAdapter
private lateinit var binding: FragmentGamesBinding

class GamesFragment : BaseFragmentMvp<GameListContract.View,
        GameListContract.Presenter>(), GameListContract.View {

    override val presenter: GameListContract.Presenter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    @DelicateCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.loadDataGameList()
        presenter.getActionFromFlowList()
        presenter.getRacingFromFlowList()
        presenter.getShooterFromFlowList()

        buildFirstRecyclerView()
        buildSecondRecyclerView()
        buildThirdRecyclerView()
    }

    private fun buildFirstRecyclerView() {
        adapter = MyAdapter(onClick = { startInfoFragment(it) })
        binding.recycler1ViewHero.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recycler1ViewHero.adapter = adapter
    }

    private fun buildSecondRecyclerView() {
        adapter2 = MyAdapter(onClick = { startInfoFragment(it) })
        binding.recycler2ViewHero.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recycler2ViewHero.adapter = adapter2
    }

    private fun buildThirdRecyclerView() {
        adapter3 = MyAdapter(onClick = { startInfoFragment(it) })
        binding.recycler3ViewHero.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recycler3ViewHero.adapter = adapter3
    }

    override fun showActionGameListActionFromDb(list: List<GameResult>) {
        adapter.setItems(list)
    }

    override fun showRacingGameListActionFromDb(list: List<GameResult>) {
        adapter2.setItems(list)
    }

    override fun showShooterGameListActionFromDb(list: List<GameResult>) {
        adapter3.setItems(list)
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