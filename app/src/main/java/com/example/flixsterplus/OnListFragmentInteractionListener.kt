package com.example.flixsterplus


/** This interface is used by the [InTheaterRecycleViewAdapter] to ensure it has an appropriate
 *  Listener. In this app, it's implemented by [InTheaterMovieFragment].  */

interface OnListFragmentInteractionListener {
    fun onItemClick(item: Movie) {}
}