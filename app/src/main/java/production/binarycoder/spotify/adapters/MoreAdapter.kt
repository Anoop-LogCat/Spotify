package production.binarycoder.spotify.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import production.binarycoder.spotify.R
import production.binarycoder.spotify.models.MoreModel

class MoreAdapter(private val moreList:List<MoreModel>) : RecyclerView.Adapter<MoreAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardmore, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(moreList[position])
    }
    override fun getItemCount(): Int {
        return moreList.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(moreList: MoreModel) {
            val titleMore:TextView=itemView.findViewById(R.id.titleMoreCard)
            val iconImageView:ImageView=itemView.findViewById(R.id.more_cardImageView)
            val moreCard:LinearLayout=itemView.findViewById(R.id.moreCardLayout)
            titleMore.text=moreList.title
            iconImageView.setImageDrawable(moreList.icon)
            moreCard.setOnClickListener { moreList.clickAction() }
        }
    }
}