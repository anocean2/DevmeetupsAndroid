package org.devmeetups.model.entity


import com.google.gson.annotations.SerializedName

data class Event(
        @SerializedName("adresOrUrl")
    var adresOrUrl: String? = "",
        @SerializedName("dateEnd")
    var dateEnd: String? = "",
        @SerializedName("dateStart")
    var dateStart: String? = "",
        @SerializedName("id")
    var id: Int? = null,
        @SerializedName("imageUrl")
    var imageUrl: String? = "",
        @SerializedName("organizators")
    var organizators: String? = "",
        @SerializedName("periodEvent")
    var periodEvent: String? = "",
        @SerializedName("policy")
    var policy: String? = "",
        @SerializedName("shortDescription")
    var shortDescription: String? = "",
        @SerializedName("technologies")
    var technologies: String? = "",
        @SerializedName("technologiesEvent")
    var technologiesEvent: List<String?>? = mutableListOf(),
        @SerializedName("timeEnd")
    var timeEnd: String? = "",
        @SerializedName("timeStart")
    var timeStart: String? = "",
        @SerializedName("title")
    var title: String? = "",
        @SerializedName("typeEvent")
    var typeEvent: Int? = null,
        @SerializedName("typePlace")
    var typePlace: Int? = null
)