package com.stikubank.mynetflex.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.stikubank.mynetflex.adapter.ShowAdapter
import com.stikubank.mynetflex.databinding.FragmentShowsBinding
import com.stikubank.mynetflex.viewmodel.ShowsViewModel
import com.stikubank.mynetflex.viewmodel.ViewModelFactory

class ShowsFragment : Fragment() {

    private lateinit var showsFragmentBinding: FragmentShowsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        showsFragmentBinding = FragmentShowsBinding.inflate(inflater, container, false)
        return showsFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){

            val factory = ViewModelFactory.getInstance(requireActivity())
            val vModel = ViewModelProvider(this, factory)[ShowsViewModel::class.java]

            val showsAdapter = ShowAdapter()

            showsFragmentBinding.progressBar.visibility = View.VISIBLE
            vModel.getShows().observe(this, { shows ->
                showsFragmentBinding.progressBar.visibility = View.GONE
                showsAdapter.setShows(shows)
                showsAdapter.notifyDataSetChanged()
            })

            with(showsFragmentBinding.rvShows){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = showsAdapter
            }
        }
    }
}
