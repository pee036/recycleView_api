package com.example.recycleview.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Data(
    val avatarImage: String,
    val comments: List<Comment>,
    val id: String,
    val subtitle: String,
    val title: String,
    val youtubeImage: String,
    val youtubeUrl: String
):Parcelable