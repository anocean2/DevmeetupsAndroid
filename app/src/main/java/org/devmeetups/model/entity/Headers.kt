package org.devmeetups.model.entity


import com.google.gson.annotations.SerializedName

data class Headers(
    @SerializedName("Content-Disposition")
    var contentDisposition: List<String?>? = listOf(),
    @SerializedName("Content-Type")
    var contentType: List<String?>? = listOf()
)