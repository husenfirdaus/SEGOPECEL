package com.example.segopecel2.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.segopecel2.R
import com.example.segopecel2.application.PecelApp
import com.example.segopecel2.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null


    private val binding get() = _binding!!
    private lateinit var applicationContext: Context
    private val PecelViewModel: PecelViewModel by viewModels {
        PecelViewModelFactory((applicationContext as PecelApp).repository)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        applicationContext = requireContext().applicationContext
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PecelListAdapter {pecel ->
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(pecel)
            findNavController().navigate(action)
        }
        binding.dataRecyclerView.adapter = adapter
        binding.dataRecyclerView.layoutManager = LinearLayoutManager(context)
        PecelViewModel.allPecels.observe(viewLifecycleOwner){ Pecels ->
            Pecels.let {
                if (Pecels.isEmpty()) {
                    binding.emptytextView.visibility = View.VISIBLE
                    binding.imageView.visibility = View.VISIBLE
                } else {
                    binding.emptytextView.visibility = View.GONE
                    binding.imageView.visibility = View.GONE
                }
                adapter.submitList(Pecels)
            }

        }

        binding.addFAB.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(null)
            findNavController().navigate(action)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}