package com.example.presentarion.fragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.presentarion.adapter.HockeyPagerAdapter
import com.example.presentarion.databinding.FragmentHockeyTutorialBinding
import com.example.presentarion.viewmodel.HockeyTutorialViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HockeyTutorialFragment : Fragment() {

    private lateinit var binding: FragmentHockeyTutorialBinding
    private val adapter = HockeyPagerAdapter()
    private val viewModel by viewModels<HockeyTutorialViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHockeyTutorialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
        lifecycleScope.launchWhenCreated {
            viewModel.tutorial.collect{
                adapter.submitList(it)
            }
        }
        viewModel.loadTutorialHockey()
    }

}