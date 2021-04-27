package production.binarycoder.spotify.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import production.binarycoder.spotify.R
import production.binarycoder.spotify.models.AlbumModel

class AlbumListAdapter(private val albumList:List<AlbumModel>) : RecyclerView.Adapter<AlbumListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardalbum, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(albumList[position])
    }
    override fun getItemCount(): Int {
        return albumList.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(albumList: AlbumModel) {
            val title:TextView=itemView.findViewById(R.id.alumTitleInCard)
            val subTitle:TextView=itemView.findViewById(R.id.alumSubTitleInCard)
            val siNo:TextView=itemView.findViewById(R.id.albumCountInCard)
            val image:ImageView=itemView.findViewById(R.id.alumImageInCard)
            val more:ImageView=itemView.findViewById(R.id.moreButtonInCard)
            val card:RelativeLayout=itemView.findViewById(R.id.albumCardLayout)
            title.text=albumList.albumTitle
            subTitle.text=albumList.albumPlayerCount
            image.setImageDrawable(albumList.imageAlbum)
            siNo.text=(albumList.siNo).toString()
            more.setOnClickListener {
                albumList.moreFunc()
            }
            card.setOnClickListener {
                title.setTextColor(albumList.color)
                albumList.clickAction()
            }


        }
    }
}