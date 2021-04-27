package production.binarycoder.spotify.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import production.binarycoder.spotify.R
import production.binarycoder.spotify.models.CategoryModel

class CategoryAdapter(private val categoryList:List<CategoryModel>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.category_playlist, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(categoryList[position])
    }
    override fun getItemCount(): Int {
        return categoryList.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(categoryList: CategoryModel) {
            val albumPic: ImageView =itemView.findViewById(R.id.albumImageView)
            val title: TextView =itemView.findViewById(R.id.albumTitleTextView)
            val subTitle: TextView =itemView.findViewById(R.id.albumSubTitleTextView)
            albumPic.setImageDrawable(categoryList.image)
            if(categoryList.albumTitle.compareTo("")==0){
                title.visibility=View.GONE
                subTitle.setPadding(0,20,0,0)
            } else{ title.visibility=View.VISIBLE }
            title.text=categoryList.albumTitle
            title.typeface=categoryList.fontBold
            subTitle.text=categoryList.albumSubTitle
            subTitle.typeface=categoryList.fontLight
        }
    }
}