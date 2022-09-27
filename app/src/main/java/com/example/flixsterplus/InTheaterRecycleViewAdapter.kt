package com.example.flixsterplus

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flixsterplus.R.id


class InTheaterRecycleViewAdapter (
    private val movies: List<Movie>, private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<InTheaterRecycleViewAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_movie, parent, false)
        return MovieViewHolder(view)
    }

    /** This inner class refer to all the different View elements  */
    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: Movie? = null
        val mMovieTitle: TextView = mView.findViewById<View>(id.movie_title) as TextView
        val mMovieDescription: TextView = mView.findViewById<View>(id.movie_description) as TextView
        val mMovieImage: ImageView = mView.findViewById<View>(id.movie_image) as ImageView

        override fun toString(): String {
            return mMovieTitle.toString() + " '" + mMovieDescription.text + "'"
        }
    }

    /** This lets us "bind" each Views in the ViewHolder to its' actual data! */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.mItem = movie
        holder.mMovieTitle.text = movie.title
        holder.mMovieDescription.text = movie.description

        var ImageUrl : String = "https://image.tmdb.org/t/p/w500" + movie.movieImageUrl
        Glide.with(holder.mView)
            .load(ImageUrl)
            .centerInside()
            .into(holder.mMovieImage)

        holder.mView.setOnClickListener {
            holder.mItem?.let { book ->
                mListener?.onItemClick(book)
            }
        }
    }

    /** RecyclerView adapters require a getItemCount() method. */
    override fun getItemCount(): Int {
        return movies.size
    }
}