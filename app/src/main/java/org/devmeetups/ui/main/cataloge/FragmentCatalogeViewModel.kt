package org.devmeetups.ui.main.cataloge

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.*
import org.devmeetups.model.entity.Event
import org.devmeetups.utils.Constants

class FragmentCatalogeViewModel : ViewModel() {
    val database = FirebaseDatabase.getInstance()
    val collection: MutableLiveData<MutableList<Event>> = MutableLiveData()

    fun collection(): LiveData<MutableList<Event>>{
        return this.collection
    }

    fun setCollection(valueList: MutableList<Event>){
        this.collection.value = valueList
    }


    fun loadData() {
        val eventsRef = database.getReference("Events")
        mutable(eventsRef)
    }

    private fun mutable(eventsRef: DatabaseReference) {
        eventsRef.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    // val neponyatnoChto = dataSnapshot.children.first().getValue(Event::class.java)
                    //  Log.v(Constants.LOGS_TAG, neponyatnoChto?.title.toString())
                    val tempCollection = mutableListOf<Event>()
                    for (eventSnapshot in dataSnapshot.children) {
                        val event = eventSnapshot.getValue(Event::class.java)
                        if (event != null) {
                            tempCollection.add(event)
                        }
                    }
                    setCollection(tempCollection)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.v(Constants.LOGS_TAG, error.toString())
            }

        })
    }


}