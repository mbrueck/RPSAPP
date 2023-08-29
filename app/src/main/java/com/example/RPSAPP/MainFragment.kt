package com.example.RPSAPP

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.RPSAPP.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnStone.setOnClickListener { viewModel.playSystem(gameOption.STONE) }
        binding.btnPapier.setOnClickListener { viewModel.playSystem(gameOption.PAPER) }
        binding.btnSissor.setOnClickListener { viewModel.playSystem(gameOption.SCISSOR) }

        viewModel.playChose.observe(viewLifecycleOwner, Observer {
            result -> displayResult(result)
        })
    }

    private fun displayResult(result: gameResult) {
            when (result){
                gameResult.WIN -> binding.tvResut.text = "Gewonnen!"
                gameResult.LOSE -> binding.tvResut.text = "Verloren!"
                gameResult.DRAW -> binding.tvResut.text = "Unentschieden, gleich nochmal :D !"
            }
    }


}