package com.stikubank.mynetflex.ui

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.stikubank.mynetflex.R
import com.stikubank.mynetflex.adapter.ShowAdapter
import com.stikubank.mynetflex.databinding.FragmentShowsBinding
import com.stikubank.mynetflex.viewmodel.ShowsViewModel
import com.stikubank.mynetflex.viewmodel.ViewModelFactory
import com.stikubank.mynetflex.vo.Status
import org.koin.android.viewmodel.ext.android.viewModel

class ShowsFragment : Fragment() {

    private var showsFragmentBinding: FragmentShowsBinding? = null
    private val vModel: ShowsViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        showsFragmentBinding = FragmentShowsBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return showsFragmentBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){

//            val factory = ViewModelFactory.getInstance(requireActivity())
//            val vModel = ViewModelProvider(this, factory)[ShowsViewModel::class.java]

            val showsAdapter = ShowAdapter()

            vModel.getShows().observe(this, { shows ->
                if(shows != null ){
                    when(shows.status){
                        Status.LOADING -> showsFragmentBinding?.progressBar?.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            showsFragmentBinding?.progressBar?.visibility = View.GONE
//                            showsAdapter.setShows(shows.data)
                            showsAdapter.submitList(shows.data)
                            showsAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            showsFragmentBinding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Something Went Wrong", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(showsFragmentBinding?.rvShows){
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = showsAdapter
            }

//            showsFragmentBinding.progressBar.visibility = View.VISIBLE
//            vModel.getShows().observe(this, { shows ->
//                showsFragmentBinding.progressBar.visibility = View.GONE
//                showsAdapter.setShows(shows)
//                showsAdapter.notifyDataSetChanged()
//            })
//
//            with(showsFragmentBinding.rvShows){
//                layoutManager = LinearLayoutManager(context)
//                setHasFixedSize(true)
//                 adapter = showsAdapter
//            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_favorite, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_favorite -> startActivity(Intent(requireContext(), FavoriteActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        showsFragmentBinding = null
    }
}
