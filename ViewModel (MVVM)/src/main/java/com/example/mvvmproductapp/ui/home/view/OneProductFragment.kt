package com.example.mvvmproductapp.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.mvvmproductapp.databinding.FragmentOneProductBinding

class OneProductFragment : Fragment() {

    private var _binding: FragmentOneProductBinding? = null
    private val binding get() = _binding!!

    private val args: OneProductFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentOneProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product = args.text

        // Display the product text and image using Glide
        binding.productText.text = product
        Glide.with(requireContext())
            .load(args.productImage)
            .into(binding.productImage)

        binding.closeBtn.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}