package com.sunasterisk.demomvvm.ui.favorite

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
import com.sunasterisk.demomvvm.databinding.FragmentFavoriteBinding
import com.sunasterisk.demomvvm.ui.adapter.BookAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteBookFragment : Fragment(R.layout.fragment_favorite) {
    private val favoriteBookViewModel by viewModel<FavoriteBookViewModel>()
    private var binding: FragmentFavoriteBinding? = null
    private val bookAdapter = BookAdapter(this::onBookClick)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<FragmentFavoriteBinding>(
        inflater,
        R.layout.fragment_favorite,
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
            lifecycleOwner = this@FavoriteBookFragment
            viewModel = favoriteBookViewModel
            recyclerBooks.adapter = bookAdapter
        }
        favoriteBookViewModel.getBooks()
    }

    private fun initObserve() {
        favoriteBookViewModel.error.observe(viewLifecycleOwner, Observer {
            context?.showError(it)
        })
    }

    private fun onBookClick(book: BookPreview) {
        findNavController().navigate(
            FavoriteBookFragmentDirections.actionFavoriteBookFragmentToBookDetailFragment(book)
        )
    }
}
