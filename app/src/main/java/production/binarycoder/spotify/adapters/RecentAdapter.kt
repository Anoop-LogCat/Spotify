package production.binarycoder.spotify.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import production.binarycoder.spotify.R
import production.binarycoder.spotify.models.PlayListModel
import production.binarycoder.spotify.models.RecentlyPlayedModel

class RecentAdapter(private val recentList:List<RecentlyPlayedModel>) : RecyclerView.Adapter<RecentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recent_playlist, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(recentList[position])
    }
    override fun getItemCount(): Int {
        return recentList.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(recentList: RecentlyPlayedModel) {
            val image: ImageView =itemView.findViewById(R.id.recentImageView)
            val name: TextView =itemView.findViewById(R.id.recentTextView)
            val card: RelativeLayout =itemView.findViewById(R.id.recentPlayCardLayout)

            image.setImageDrawable(recentList.image)
            name.text=recentList.name
            name.typeface=recentList.font
            card.setOnClickListener {
                recentList.clickAction()
            }
        }
    }
}