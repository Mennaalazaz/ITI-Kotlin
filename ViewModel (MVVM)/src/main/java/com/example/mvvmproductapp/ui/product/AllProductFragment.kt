package com.example.mvvmproductapp.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmproductapp.databinding.FragmentProductAllBinding // Imports your generated ViewBinding for the layout fragment_product_all.xml.
class AllProductFragment : Fragment() {

    private var _binding: FragmentProductAllBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ProductAdapter
    private val viewModel: ProductViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProductAllBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ProductAdapter { product ->   // create instance of ProductAdapter
            val action = AllProductFragmentDirections.actionAllProductFragmentToOneProductFragment(  // passing a lambda (function) that defines what should happen when the user clicks on a product item.
                    productImage = product.image ?: "",
                    text = product.title ?: "")

            findNavController().navigate(action) // tells the Navigation Component to actually move to the new fragment using the action
        }

        // Set up RecyclerView and adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        viewModel.products.observe(viewLifecycleOwner, Observer { products -> // Observe the LiveData in the ViewModel Whenever the product list is updated in the ViewModel, update the adapter’s list
            adapter.submitList(products) // automatically refreshes the UI and shows the items.
        })

        viewModel.loadProducts() // Load products from the repository
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Avoid memory leaks by setting the binding to null when the view is destroyed.
    }
}
