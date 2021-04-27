package production.binarycoder.spotify.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import production.binarycoder.spotify.R
import production.binarycoder.spotify.models.PlayListViewModel
import java.util.*


class PlayListViewAdapter(private val playListView: List<PlayListViewModel>) : RecyclerView.Adapter<PlayListViewAdapter.ViewHolder>() , ItemMoveCallback.ItemTouchHelperContract {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardplaylist, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(playListView[position])
    }
    override fun getItemCount(): Int {
        return playListView.size
    }

    override fun onRowMoved(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(playListView, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(playListView, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onRowSelected(myViewHolder: ViewHolder) {
        myViewHolder.rowView.setBackgroundColor(playListView[0].resources.getColor(R.color.lightBlack))
    }

    override fun onRowClear(myViewHolder: ViewHolder) {
        myViewHolder.rowView.setBackgroundColor(playListView[0].resources.getColor(R.color.black))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val rowView: View = itemView

        fun bindItems(playListView: PlayListViewModel) {
            val singer:TextView=itemView.findViewById(R.id.singerNameInCardPlayList)
            val song:TextView=itemView.findViewById(R.id.songNameInCardPlayList)
            val card:RelativeLayout=itemView.findViewById(R.id.playListCardLayout)
            singer.text=playListView.artistName
            song.text=playListView.songName
            card.setOnClickListener {
                playListView.playAction()
            }
        }
    }
}