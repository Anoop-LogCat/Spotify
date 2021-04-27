package production.binarycoder.spotify.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import production.binarycoder.spotify.R
import production.binarycoder.spotify.models.PlayListModel

class PlayListAdapter(private val playList:List<PlayListModel>) : RecyclerView.Adapter<PlayListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.saved_playlist, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(playList[position])
    }
    override fun getItemCount(): Int {
        return playList.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(playList: PlayListModel) {
            val firstImage: ImageView=itemView.findViewById(R.id.playList_Image_1)
            val secondImage: ImageView=itemView.findViewById(R.id.playList_Image_2)
            val firstName: TextView=itemView.findViewById(R.id.name_col1_textView)
            val secondName: TextView=itemView.findViewById(R.id.name_col2_textView)
            firstImage.setImageDrawable(playList.imageUrl_col1)
            secondImage.setImageDrawable(playList.imageUrl_col2)
            firstName.text=playList.name_col1
            firstName.typeface = playList.typeFace
            secondName.text=playList.name_col2
            secondName.typeface = playList.typeFace
        }
    }
}