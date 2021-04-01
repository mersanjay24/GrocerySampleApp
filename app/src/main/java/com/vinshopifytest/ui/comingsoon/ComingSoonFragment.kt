package com.vinshopifytest.ui.comingsoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vinshopifytest.R

class ComingSoonFragment : Fragment() {

    private lateinit var comingSoonViewModel: ComingSoonViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        comingSoonViewModel =
                ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ComingSoonViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_coming_soon, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        comingSoonViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}