package com.sunasterisk.demomvvm.ui.detail

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
import com.sunasterisk.demomvvm.databinding.FragmentBookDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookDetailFragment : Fragment() {
    private val bookDetailViewModel by viewModel<BookDetailViewModel>()
    private var binding: FragmentBookDetailBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<FragmentBookDetailBinding>(
        inflater,
        R.layout.fragment_book_detail,
        container,
        false
    )
        .apply { binding = this }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initListener()
        initObserve()
    }

    private fun initData() {
        binding?.apply {
            lifecycleOwner = this@BookDetailFragment
            viewModel = bookDetailViewModel
        }

        arguments?.let {
            val arg = BookDetailFragmentArgs.fromBundle(it)
            val bookPreview = arg.book

            bookDetailViewModel.loadBook(bookPreview.isbn13)
        }
    }

    private fun initListener() {
        binding?.apply {
            imageBackDetailBook.setOnClickListener { findNavController().popBackStack() }
        }
    }

    private fun initObserve() {
        bookDetailViewModel.error.observe(viewLifecycleOwner, Observer {
            context?.showError(it)
        })
    }
}
