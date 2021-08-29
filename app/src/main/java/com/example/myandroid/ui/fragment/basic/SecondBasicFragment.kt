package com.example.myandroid.ui.fragment.basic

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.myandroid.R
import com.example.myandroid.databinding.FragmentSecondBinding
import com.example.myandroid.ui.base.BaseFragment
import com.example.myandroid.model.SecondModel

class SecondBasicFragment : BaseFragment() {

    private val binding get() = _binding as FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i(logTag, "onCreateView")
        _binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = requireArguments().getParcelable<SecondModel>("model")
        binding.tvData.text = model?.name ?: "Not found model"

        binding.btnNext.setOnClickListener {
            navigateToThird()
        }
    }

    private fun navigateToThird() {
        activity?.supportFragmentManager?.commit {
            setReorderingAllowed(true)
            add<ThirdBasicFragment>(R.id.basic_fragment_view)
            addToBackStack(null)
        }
    }
}
