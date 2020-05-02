package org.devmeetups.model.enumirate

import org.devmeetups.R

enum class TypeEvent(val resId: Int) {
    CONFERENCE(R.string.coneference),
    MEETUP(R.string.meetup),
    EVENT(R.string.event),
    WORKSHOP(R.string.workshop),
    WEBINAR(R.string.webinar),
    NOTYPE(R.string.notype)
}