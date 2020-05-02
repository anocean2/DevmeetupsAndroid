package org.devmeetups.utils

import org.devmeetups.model.enumirate.TypeEvent

object UtilsK {

    /**
     * делаем и строки 11/04/2020 строку 11
     */
    fun getDayFromString(dateStart: String?): String {
        if (!dateStart.isNullOrEmpty()) {
            val items = dateStart.split(Constants.DELIMETERS)
            return items[0]
        } else {
            return ""
        }
    }

    /**
     *  делаем из строки 11/04/2020 строку 04/2020
     */
    fun getMonthYear(dateStart: String?): String {
        if (!dateStart.isNullOrEmpty()) {
            val items = dateStart.split(Constants.DELIMETERS)
            if (!items[1].isEmpty() && !items[2].isEmpty()) {
                val s: String = items[1] + "/" + items[2]
                return s
            } else {
                return ""
            }
        } else {
            return ""
        }
    }

    /**
     * Обрезаем строку в count символов
     */
    fun shorten(count: Int, shortDescription: String?): String {
        return shortDescription?.substring(0, count) ?: ""
    }

    fun getTypeMeetup(typeEvent: Int?): TypeEvent {
        if (typeEvent != null) {
            when (typeEvent) {
                1 -> return TypeEvent.CONFERENCE
                2 -> return TypeEvent.MEETUP
                3 -> return TypeEvent.EVENT
                4 -> return TypeEvent.WORKSHOP
                5 -> return TypeEvent.WEBINAR
                else -> return TypeEvent.NOTYPE
            }
        } else {
            return TypeEvent.NOTYPE
        }
    }

    fun getFullUrl(imageUrl: String?): String {
        if (!imageUrl.isNullOrEmpty()) {
            return Constants.BASE_URL + imageUrl
        } else {
            return ""
        }
    }
}