package production.binarycoder.spotify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import production.binarycoder.spotify.adapters.CategoryAdapter
import production.binarycoder.spotify.adapters.SearchCategoryAdapter
import production.binarycoder.spotify.models.CategoryModel
import production.binarycoder.spotify.models.SearchCategoryModel

class Search : Fragment(){

    private var searchCategoryList1=ArrayList<SearchCategoryModel>()
    private var searchCategoryList2=ArrayList<SearchCategoryModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryRecyclerView1:RecyclerView=view.findViewById(R.id.recycler_view_category_1)
        val categoryRecyclerView2:RecyclerView=view.findViewById(R.id.recycler_view_category_2)

        categoryRecyclerView1.layoutManager=GridLayoutManager(context,2,RecyclerView.VERTICAL,false)
        if(searchCategoryList1.isNotEmpty()){ searchCategoryList1.clear() }
        searchCategoryList1.add(SearchCategoryModel("Pop",resources.getColor(R.color.green_shade_1_back_color),resources.getDrawable(R.drawable.browser_pop_image)))
        searchCategoryList1.add(SearchCategoryModel("Hip Hop",resources.getColor(R.color.brown_shade_1_back_color),resources.getDrawable(R.drawable.browser_hiphop_image)))
        searchCategoryList1.add(SearchCategoryModel("Dance / Electronic",resources.getColor(R.color.green_shade_2_back_color),resources.getDrawable(R.drawable.browser_dance_ele_image)))
        searchCategoryList1.add(SearchCategoryModel("Bollywood",resources.getColor(R.color.red_shade_1_back_color),resources.getDrawable(R.drawable.browser_bollywood_image)))
        val categoryAdapter1=SearchCategoryAdapter(searchCategoryList1)
        categoryRecyclerView1.adapter=categoryAdapter1

        categoryRecyclerView2.layoutManager=GridLayoutManager(context,2,RecyclerView.VERTICAL,false)
        if(searchCategoryList2.isNotEmpty()){ searchCategoryList2.clear() }
        searchCategoryList2.add(SearchCategoryModel("Podcasts",resources.getColor(R.color.brown_shade_1_back_color),resources.getDrawable(R.drawable.browser_podcast_image)))
        searchCategoryList2.add(SearchCategoryModel("New Releases",resources.getColor(R.color.green_shade_3_back_color),resources.getDrawable(R.drawable.browser_new_rel_image)))
        searchCategoryList2.add(SearchCategoryModel("Charts",resources.getColor(R.color.green_shade_4_back_color),resources.getDrawable(R.drawable.browser_chart_image)))
        searchCategoryList2.add(SearchCategoryModel("Concerts",resources.getColor(R.color.red_shade_2_back_color),resources.getDrawable(R.drawable.browser_concerts_image)))
        searchCategoryList2.add(SearchCategoryModel("Made for You",resources.getColor(R.color.blue_shade_2_back_color),resources.getDrawable(R.drawable.hit_play_1)))
        searchCategoryList2.add(SearchCategoryModel("At Home",resources.getColor(R.color.brown_shade_1_back_color),resources.getDrawable(R.drawable.hit_play_1)))
        searchCategoryList2.add(SearchCategoryModel("EQUAL",resources.getColor(R.color.green_shade_3_back_color),resources.getDrawable(R.drawable.hit_play_1)))
        searchCategoryList2.add(SearchCategoryModel("Punjabi",resources.getColor(R.color.rose_shade_1_back_color),resources.getDrawable(R.drawable.hit_play_1)))
        searchCategoryList2.add(SearchCategoryModel("Tamil",resources.getColor(R.color.brown_shade_1_back_color),resources.getDrawable(R.drawable.hit_play_1)))
        searchCategoryList2.add(SearchCategoryModel("Telugu",resources.getColor(R.color.green_shade_3_back_color),resources.getDrawable(R.drawable.hit_play_1)))
        searchCategoryList2.add(SearchCategoryModel("Indie",resources.getColor(R.color.blue_shade_1_back_color),resources.getDrawable(R.drawable.hit_play_1)))
        searchCategoryList2.add(SearchCategoryModel("RADAR",resources.getColor(R.color.brown_shade_2_back_color),resources.getDrawable(R.drawable.hit_play_1)))
        searchCategoryList2.add(SearchCategoryModel("Marathi",resources.getColor(R.color.red_shade_1_back_color),resources.getDrawable(R.drawable.hit_play_1)))
        searchCategoryList2.add(SearchCategoryModel("Devotional",resources.getColor(R.color.brown_shade_2_back_color),resources.getDrawable(R.drawable.hit_play_1)))

        val categoryAdapter2=SearchCategoryAdapter(searchCategoryList2)
        categoryRecyclerView2.adapter=categoryAdapter2

    }
}