import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import haris.learnandroiddasar.Movie
import haris.learnandroiddasar.R

class MovieAdapter(private val context: Context, private val movieList: List<Movie>) : BaseAdapter() {

    override fun getCount(): Int = movieList.size

    override fun getItem(position: Int): Any = movieList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val movie = movieList[position]
        holder.titleTextView.text = movie.title
        holder.descriptionTextView.text = movie.description
        holder.posterImageView.setImageResource(movie.posterResourceId)

        return view
    }

    private class ViewHolder(view: View) {
        val posterImageView: ImageView = view.findViewById(R.id.movie_poster)
        val titleTextView: TextView = view.findViewById(R.id.movie_title)
        val descriptionTextView: TextView = view.findViewById(R.id.movie_description)
    }
}