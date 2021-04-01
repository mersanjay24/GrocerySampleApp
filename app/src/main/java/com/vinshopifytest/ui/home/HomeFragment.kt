package com.vinshopifytest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinshopifytest.R
import com.vinshopifytest.utilities.progressOFF
import com.vinshopifytest.utilities.progressON
import com.vinshopifytest.utilities.showToast
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = HomeViewModel(requireActivity().application)
        //homeViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()

        homeViewModel.getHomeData()
    }

    private fun setupObservers() {

        homeViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it) {
                progressON(activity)
            } else {
                progressOFF()
            }
        })
        homeViewModel.data.observe(viewLifecycleOwner, Observer {

            if (it.httpcode == 200 && it.status.equals("success")) {
                rvSlider.layoutManager = LinearLayoutManager(
                    this!!.activity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                rvSlider.adapter = SliderAdapter(it?.data?.bannerSlider)
                rvSlider.isNestedScrollingEnabled = false


                rvFeatured?.layoutManager = LinearLayoutManager(
                    this!!.activity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                rvFeatured?.adapter = ListingAdapter(it?.data?.featured)

                rvCategory?.layoutManager = LinearLayoutManager(
                    this!!.activity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                rvCategory?.adapter = CategoryAdapter(it?.data?.categories)



            }

        })
        homeViewModel.failure.observe(viewLifecycleOwner, Observer {
            showToast(requireContext(), it)
        })
    }
}