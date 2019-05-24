package com.manya.epamnetworking

import android.support.annotation.Keep
import com.google.gson.annotations.SerializedName

/**
 *
 * Job data class witch can get from json by [Gson].
 *
 * @author Maria Kirdun
 */

@Keep
data class Job(
    val company : String,
    @SerializedName("title")
    val position : String,
    val location : String
)