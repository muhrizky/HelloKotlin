package id.ac.undip.ce.student.muhammadrizqi.hellokotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.ScrollingTabContainerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

import kotlinx.android.extensions.LayoutContainer
import id.ac.undip.ce.student.muhammadrizqi.hellokotlin.R.id.image
import id.ac.undip.ce.student.muhammadrizqi.hellokotlin.R.id.name
import id.ac.undip.ce.student.muhammadrizqi.hellokotlin.R.layout.item_list
import kotlinx.android.synthetic.main.item_list.*

import java.security.AccessControlContext



class RecyclerViewAdapter(private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size


    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer {

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            name.text = items.name
            Glide.with(containerView).load(items.image).into(image)
            containerView.setOnClickListener { listener(items) }
        }
    }
}