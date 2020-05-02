package org.devmeetups.ui.main.cataloge

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.devmeetups.R
import org.devmeetups.model.adapters.AdapterCataloge
import org.devmeetups.model.adapters.ViewHolderCataloge


class FragmentCataloge : Fragment() {

    //val viewModel: MainViewModel by viewModels()
    val fViewModel: FragmentCatalogeViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: AdapterCataloge

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cataloge, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)
        mutable()
        fViewModel.loadData()
    }

    private fun init(view: View) {
        recyclerView = view.findViewById(R.id.rvCataloge)
        recyclerAdapter = AdapterCataloge()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = recyclerAdapter
        recyclerView.addItemDecoration(decorationList)
    }

    private fun mutable() {
        fViewModel.collection().observe(viewLifecycleOwner, Observer { events ->
            recyclerAdapter.setData(events)
        })
    }

    private val decorationList: RecyclerView.ItemDecoration = object : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            val position = parent.getChildAdapterPosition(view)

            outRect.set(0,
                    resources.getDimensionPixelSize(R.dimen._10sdp),
                    0,
                    resources.getDimensionPixelSize(R.dimen._10sdp))
                    //if (position == parent.adapter!!.itemCount - 1) resources.getDimensionPixelSize(R.dimen._20sdp) else resources.getDimensionPixelSize(R.dimen._20sdp))
        }
    }

}
