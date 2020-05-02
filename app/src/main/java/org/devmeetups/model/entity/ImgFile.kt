package org.devmeetups.model.entity


import com.google.gson.annotations.SerializedName

data class ImgFile(
    @SerializedName("ContentDisposition")
    var contentDisposition: String? = "",
    @SerializedName("ContentType")
    var contentType: String? = "",
    @SerializedName("FileName")
    var fileName: String? = "",
    @SerializedName("Headers")
    var headers: Headers? = Headers(),
    @SerializedName("Length")
    var length: Int? = 0,
    @SerializedName("Name")
    var name: String? = ""
)