package com.adresto.carfaxtechnicalassignment.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.adresto.carfaxtechnicalassignment.R
import com.adresto.carfaxtechnicalassignment.model.Listing
import com.adresto.carfaxtechnicalassignment.ui.placeholder.PlaceholderContent
import com.adresto.carfaxtechnicalassignment.utils.ResourceState
import com.adresto.carfaxtechnicalassignment.viewmodel.CarfaxViewModel

/**
 * A fragment representing a list of Items.
 */
class CarsListFragment : Fragment() {
    val TAG = "Test Tag"

    private val carfaxViewModel: CarfaxViewModel by viewModels(this::requireActivity)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cars_list_list, container, false)
        carfaxViewModel.loadListings()
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = MyCarsRecyclerViewAdapter(listOf<Listing>()) { navigateToListing(it) }

                carfaxViewModel.listings.observe(viewLifecycleOwner) {
                    when (it.state) {
                        ResourceState.ERROR -> {
                            //TODO if there is data => ignore, else => show error
                        }
                        ResourceState.LOADING -> {
                            //TODO Show loading effect
                        }
                        ResourceState.SUCCESS -> {
                            (adapter as MyCarsRecyclerViewAdapter).values = it.data!!
                            (adapter as MyCarsRecyclerViewAdapter).notifyDataSetChanged()
                        }
                    }
                }
            }
        }
        return view
    }

    private fun navigateToListing(listing: Listing) {
        parentFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, CarDetailsFragment.newInstance(listing))
            .addToBackStack("cars-list")
            .commit()
    }

}