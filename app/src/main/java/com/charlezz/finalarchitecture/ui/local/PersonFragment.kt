package com.charlezz.finalarchitecture.ui.local

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.charlezz.finalarchitecture.databinding.FragmentPersonBinding
import com.charlezz.finalarchitecture.viewmodel.PersonFragmentViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PersonFragment : DaggerFragment() {
    val TAG = PersonFragment::class.java.simpleName
    @Inject
    lateinit var binding: FragmentPersonBinding

    @Inject
    lateinit var viewmodel: PersonFragmentViewModel

    @Inject
    lateinit var adapter:PersonAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setLifecycleOwner(this)
        binding.recyclerView.adapter = adapter
        binding.viewmodel = viewmodel
        viewmodel.persons.observe(this, Observer {
            Log.e(TAG,"data count:${it?.size}") }
        )
    }

}