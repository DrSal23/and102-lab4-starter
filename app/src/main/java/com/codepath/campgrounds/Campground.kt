package com.codepath.campgrounds

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Top-level response object
@Keep
@Serializable
data class CampgroundResponse(
    @SerialName("data")
    val data: List<Campground>?
)

// Campground model
@Keep
@Serializable
data class Campground(
    @SerialName("name")
    val name: String?,

    @SerialName("description")
    val description: String?,

    @SerialName("latLong")
    val latLong: String?,

    @SerialName("images")
    val images: List<CampgroundImage>?
) : java.io.Serializable {

    // First available image URL
    val imageUrl: String
        get() = images?.firstOrNull { !it.url.isNullOrEmpty() }?.url ?: ""
}

// Image model
@Keep
@Serializable
data class CampgroundImage(
    @SerialName("url")
    val url: String?,

    @SerialName("title")
    val title: String?
) : java.io.Serializable
