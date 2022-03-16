package com.adresto.carfaxtechnicalassignment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adresto.carfaxtechnicalassignment.R
import com.adresto.carfaxtechnicalassignment.model.Listing


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "listing"

/**
 * A simple [Fragment] subclass.
 * Use the [CarDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarDetailsFragment : Fragment() {
    private var listing: Listing? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            listing = (it.getSerializable(ARG_PARAM1) as Listing)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_details, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment CarDetailsFragment.
         */
        @JvmStatic
        fun newInstance(param1: Listing) =
            CarDetailsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }
    }
}