package com.example.mvvmproductapp.ui.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmproductapp.data.model.Product
import com.example.mvvmproductapp.databinding.ItemProductBinding

class ProductAdapter(private val onItemClick: (Product) -> Unit) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private var productList: List<Product> = emptyList()
    inner class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.titleTextView.text = product.title
            Glide.with(binding.imageView.context).load(product.image).into(binding.imageView)
            binding.openButton.setOnClickListener {
                onItemClick(product)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    fun submitList(products: List<Product>) {
        productList = products
        notifyDataSetChanged()
    }
}