package com.sunasterisk.demomvvm.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.sunasterisk.demomvvm.R
import com.sunasterisk.demomvvm.Ultils.showError
import com.sunasterisk.demomvvm.data.model.BookPreview
import com.sunasterisk.demomvvm.databinding.FragmentHomeBinding
import com.sunasterisk.demomvvm.ui.adapter.BookAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val homeViewModel by viewModel<HomeViewModel>()
    private var binding: FragmentHomeBinding? = null
    private val bookAdapter = BookAdapter(this::onBookClick)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<FragmentHomeBinding>(
        inflater,
        R.layout.fragment_home,
        container,
        false
    )
        .apply { binding = this }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initObserve()
    }

    private fun initData() {
        binding?.apply {
            lifecycleOwner = this@HomeFragment
            viewModel = homeViewModel
            recyclerBooks.adapter = bookAdapter
        }
        homeViewModel.getNewBooks()
    }

    private fun initObserve() {
        homeViewModel.error.observe(viewLifecycleOwner, Observer {
            context?.showError(it)
        })
    }

    private fun onBookClick(book: BookPreview) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToBookDetailFragment(book)
        )
    }
}
