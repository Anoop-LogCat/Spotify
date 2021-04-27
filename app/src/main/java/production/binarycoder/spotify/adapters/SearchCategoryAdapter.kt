package production.binarycoder.spotify.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import production.binarycoder.spotify.R
import production.binarycoder.spotify.models.SearchCategoryModel

class SearchCategoryAdapter(private val categoryListInSearch:List<SearchCategoryModel>) : RecyclerView.Adapter<SearchCategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.category_card, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(categoryListInSearch[position])
    }
    override fun getItemCount(): Int {
        return categoryListInSearch.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(searchCategoryList: SearchCategoryModel) {
            val cardImage: ImageView =itemView.findViewById(R.id.search_card_imageView)
            val cardTitle: TextView =itemView.findViewById(R.id.search_card_title)
            val card: CardView =itemView.findViewById(R.id.search_cardLayout)
            card.setCardBackgroundColor(searchCategoryList.colorID)
            cardTitle.text = searchCategoryList.title
            cardImage.setImageDrawable(searchCategoryList.ImageInCard)
            cardImage.animate().rotation(25f)
            cardImage.animate().translationXBy(40f)
            card.setOnClickListener {

            }
        }
    }
}