package org.devmeetups.model.adapters

import android.app.Application
import android.graphics.Rect
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import org.devmeetups.DevmeetupsApp
import org.devmeetups.R
import org.devmeetups.model.entity.Event
import org.devmeetups.utils.UtilsK
import javax.inject.Inject


class AdapterCataloge : RecyclerView.Adapter<ViewHolderCataloge>() {

    private val collection = mutableListOf<Event>()
    @Inject
    lateinit var app: Application

    init {
        DevmeetupsApp.getDaggerComponent().inject(this)
    }

    fun setData(collect: MutableList<Event>) {
        collection.clear()
        collection.addAll(collect)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCataloge {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_cataloge, parent, false)
        return ViewHolderCataloge(view)
    }

    override fun getItemCount(): Int {
        return collection.size
    }

    override fun onBindViewHolder(view: ViewHolderCataloge, position: Int) {
        bindItem(view, position)
    }

    private fun bindItem(view: ViewHolderCataloge, position: Int) {
        val event: Event = collection[position]
        clearViewHolder(view)
        setTitle(view, event)
        setDay(view, event)
        setMonthYear(view, event)
        setTypeMeetup(view, event)
        setStackTech(view, event)
        setImageEvent(view, event)
    }

    private fun setImageEvent(view: ViewHolderCataloge, event: Event) {
        if (!event.imageUrl.isNullOrEmpty()) {
            val url = UtilsK.getFullUrl(event.imageUrl)

            Picasso.get()
                    .load(url)
                    .fit()
                    .centerCrop()
                    .transform(RoundedCornersTransformation(app.resources.getDimensionPixelSize(R.dimen.background_radius), 0, RoundedCornersTransformation.CornerType.TOP))
                    .into(view.ivEventImage)

        } else {
            view.ivEventImage.setImageResource(R.drawable.ic_like_icon)
        }
    }

    private fun setTypeMeetup(view: ViewHolderCataloge, event: Event) {
        if (event.typeEvent != null) {
            view.tvTypeMeetup.text = app.getString(UtilsK.getTypeMeetup(event.typeEvent).resId)
        } else {
            view.tvTypeMeetup.text = ""
        }
    }

    private fun setStackTech(view: ViewHolderCataloge, event: Event) {
        if (!event.technologies.isNullOrEmpty()) {
            view.tvStackTech.text = event.technologies
        } else {
            view.tvStackTech.text = ""
        }
    }

    private fun clearViewHolder(view: ViewHolderCataloge) {
        view.tvDateMonthYear.text = ""
        view.tvDateDay.text = ""
        view.tvTitle.text = ""
        view.tvStackTech.text = ""
        view.tvTypeMeetup.text = ""
    }

    private fun setMonthYear(view: ViewHolderCataloge, event: Event) {
        if (!event.dateStart.isNullOrEmpty()) {
            val monthYear = UtilsK.getMonthYear(event.dateStart)
            view.tvDateMonthYear.text = monthYear
        }

    }

    private fun setDay(view: ViewHolderCataloge, event: Event) {
        if ((event.dateStart != null) && (!TextUtils.isEmpty(event.dateStart))) {
            val day = UtilsK.getDayFromString(event.dateStart)
            view.tvDateDay.text = day
        } else {
            view.tvDateDay.text = ""
        }
    }

    private fun setTitle(view: ViewHolderCataloge, event: Event) {
        if ((event.title != null) && (!TextUtils.isEmpty(event.title))) {
            view.tvTitle.text = event.title
        } else {
            view.tvTitle.text = ""
        }
    }
}