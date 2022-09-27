package com.example.flixsterplus

import com.google.gson.annotations.SerializedName

/** The Model stores a single movie from themoviedb API.
 * SerializedName tags match the JSON response for the object. */
class Movie {
    @JvmField
    @SerializedName("original_title")
    var title: String? = null

    @SerializedName("poster_path")
    var movieImageUrl: String? = null

    @SerializedName("overview")
    var description : String? = null

    @SerializedName("release_date")
    var releaseDate : String? = null

    @SerializedName("vote_average")
    var voteAverage : String? = null
}