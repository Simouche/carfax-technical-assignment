package com.adresto.carfaxtechnicalassignment.ui

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.adresto.carfaxtechnicalassignment.databinding.CarsItemBinding
import com.adresto.carfaxtechnicalassignment.model.Listing
import com.adresto.carfaxtechnicalassignment.ui.placeholder.PlaceholderContent.PlaceholderItem
import com.squareup.picasso.Picasso


/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyCarsRecyclerViewAdapter(
    var values: List<Listing>,
    val itemClickCallback: (Listing) -> Unit,
) : RecyclerView.Adapter<MyCarsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            CarsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

        holder.carName.text = item.getFullName()
        holder.carPrice.text = "$ ${item.currentPrice}"
        holder.carMileage.text = "${item.mileage} km"
        holder.carLocation.text = "${item.dealer?.address}"
        Picasso.get().load(item.images!!.firstPhoto!!.large).into(holder.carImage)
        holder.callDealerButton.setBackgroundColor(Color.WHITE)
        holder.callDealerButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "${item.dealer!!.phone}"))
            holder.itemView.context.startActivity(intent)
        }
        holder.carCard.setOnClickListener {
            itemClickCallback.invoke(item)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: CarsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val carImage: ImageView = binding.carImage
        val carName: TextView = binding.carName
        val carPrice: TextView = binding.carPrice
        val carMileage: TextView = binding.carMileage
        val carLocation: TextView = binding.carLocation
        val callDealerButton: Button = binding.callDealerButton
        val carCard: CardView = binding.carCard

    }

}