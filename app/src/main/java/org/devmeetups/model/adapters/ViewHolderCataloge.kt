package org.devmeetups.model.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.devmeetups.R

class ViewHolderCataloge(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvTitle: TextView = itemView.findViewById(R.id.tvCatalogeTitle)
    val tvDateDay: TextView = itemView.findViewById(R.id.tvCatalogeDateDay)
    val tvDateMonthYear: TextView = itemView.findViewById(R.id.tvCatalogeDateMonthYear)
    val tvTypeMeetup: TextView = itemView.findViewById(R.id.tvTypeMeetup)
    val tvStackTech: TextView = itemView.findViewById(R.id.tvStackTech)
    val ivEventImage: ImageView = itemView.findViewById(R.id.ivEventImage)
}