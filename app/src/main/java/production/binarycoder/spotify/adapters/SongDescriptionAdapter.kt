package production.binarycoder.spotify.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import production.binarycoder.spotify.R
import production.binarycoder.spotify.models.SongDescriptionModel

class SongDescriptionAdapter(private val descriptionList:List<SongDescriptionModel>) : RecyclerView.Adapter<SongDescriptionAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.songdescriptioncard, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(descriptionList[position])
    }
    override fun getItemCount(): Int {
        return descriptionList.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(descriptionList: SongDescriptionModel) {
            val songName: TextView =itemView.findViewById(R.id.songNameTextView)
            val singerName: TextView =itemView.findViewById(R.id.singerNameTextView)
            songName.text = descriptionList.songNameDetails
            songName.isSelected=true
            singerName.text = descriptionList.singerNameDetails
        }
    }
}