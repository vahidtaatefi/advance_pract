package com.totan.advance_pract.Kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.totan.advance_pract.R
import kotlinx.android.synthetic.main.recycler_item.view.*


class TestKotlinRecyclerAdapter(
        val names: List<String>,
        val clickListener: TestRecyclerClickListener
) :
        RecyclerView.Adapter<TestKotlinRecyclerAdapter.TestKotlinRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestKotlinRecyclerViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return TestKotlinRecyclerViewHolder(v, clickListener)
    }

    override fun getItemCount() = names.size

    override fun onBindViewHolder(holder: TestKotlinRecyclerViewHolder, position: Int) = holder.onBind(names[position])

    class TestKotlinRecyclerViewHolder(
            val item: View,
            val clickListener: TestRecyclerClickListener
    ) : RecyclerView.ViewHolder(item) {


        fun onBind(name: String) {
            item.txtName.text = name
            item.setOnClickListener {
                clickListener.onClick(name)
            }
        }
    }
}