package production.binarycoder.spotify

import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import production.binarycoder.spotify.adapters.CategoryAdapter
import production.binarycoder.spotify.adapters.PlayListAdapter
import production.binarycoder.spotify.adapters.RecentAdapter
import production.binarycoder.spotify.models.CategoryModel
import production.binarycoder.spotify.models.PlayListModel
import production.binarycoder.spotify.models.RecentlyPlayedModel


class Home : Fragment() {

    private var playList=ArrayList<PlayListModel>()
    private var recentList=ArrayList<RecentlyPlayedModel>()
    private var categoryListType1=ArrayList<CategoryModel>()
    private var categoryListType2=ArrayList<CategoryModel>()
    private var categoryListType3=ArrayList<CategoryModel>()
    private var categoryListType4=ArrayList<CategoryModel>()
    private var categoryListType5=ArrayList<CategoryModel>()
    private var categoryListType6=ArrayList<CategoryModel>()

    private lateinit var greetingTextView:TextView
    private lateinit var recentTitleTextView:TextView
    private lateinit var categoryTitleTextView1:TextView
    private lateinit var categoryTitleTextView2:TextView
    private lateinit var categoryTitleTextView3:TextView
    private lateinit var categoryTitleTextView4:TextView
    private lateinit var categoryTitleTextView5:TextView
    private lateinit var categoryTitleTextView6:TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        greetingTextView=view.findViewById(R.id.greetingTextView)
        recentTitleTextView=view.findViewById(R.id.recentTitleTextView)
        categoryTitleTextView1=view.findViewById(R.id.categoryTitleTextView1)
        categoryTitleTextView2=view.findViewById(R.id.categoryTitleTextView2)
        categoryTitleTextView3=view.findViewById(R.id.categoryTitleTextView3)
        categoryTitleTextView4=view.findViewById(R.id.categoryTitleTextView4)
        categoryTitleTextView5=view.findViewById(R.id.categoryTitleTextView5)
        categoryTitleTextView6=view.findViewById(R.id.categoryTitleTextView6)
        val typeface = resources.getFont(R.font.proxima_nova_bold)
        val typefaceLight = resources.getFont(R.font.proxima_nova_regular)
        val navController:NavController=Navigation.findNavController(view)
        greetingTextView.typeface = typeface

        greetingTextView.text="Good Morning"
        val playListRecyclerView:RecyclerView=view.findViewById(R.id.playlist_recycler_view)
        playListRecyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        if(playList.isNotEmpty()){ playList.clear() }
        playList.add(PlayListModel(typeface,"English", "Hindi", resources.getDrawable(R.drawable.playlist_1), resources.getDrawable(R.drawable.playlist_2)))
        playList.add(PlayListModel(typeface,"Malayalam", "Tamil", resources.getDrawable(R.drawable.playlist_3), resources.getDrawable(R.drawable.playlist_4)))
        playList.add(PlayListModel(typeface,"Ritviz", "Aniruth Ravichander", resources.getDrawable(R.drawable.ritviz_background), resources.getDrawable(R.drawable.playlist_6)))
        val playListAdapter= PlayListAdapter(playList)
        playListRecyclerView.adapter = playListAdapter

        recentTitleTextView.text="Recently played"
        recentTitleTextView.typeface = typeface
        val recentRecyclerView:RecyclerView=view.findViewById(R.id.recent_recycler_view)
        recentRecyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        if(recentList.isNotEmpty()){ recentList.clear() }
        recentList.add(RecentlyPlayedModel(typeface,"Eminem", resources.getDrawable(R.drawable.recent_play_1)){
            navController.navigate(R.id.action_home2_to_albumFragment2)
        })
        recentList.add(RecentlyPlayedModel(typeface,"Ritviz", resources.getDrawable(R.drawable.recent_play_2)){
            navController.navigate(R.id.action_home2_to_albumFragment2)
        })
        recentList.add(RecentlyPlayedModel(typeface,"XXX Tentacion", resources.getDrawable(R.drawable.recent_play_3)){
            navController.navigate(R.id.action_home2_to_albumFragment2)
        })
        val recentAdapter= RecentAdapter(recentList)
        recentRecyclerView.adapter = recentAdapter

        categoryTitleTextView1.text="Your top shows"
        categoryTitleTextView1.typeface = typeface
        val categoryRecyclerView1:RecyclerView=view.findViewById(R.id.category_recycler_view1)
        categoryRecyclerView1.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        if(categoryListType1.isNotEmpty()){ categoryListType1.clear() }
        categoryListType1.add(CategoryModel(typefaceLight,typeface,resources.getDrawable(R.drawable.hit_play_1), "Justin Bieber Hits", "Selena Gomez, Justin Bieber"))
        categoryListType1.add(CategoryModel(typefaceLight,typeface,resources.getDrawable(R.drawable.hit_play_2), "Camila Cabello Hits", "Shawn Mendes, Camila Cabello"))
        categoryListType1.add(CategoryModel(typefaceLight,typeface,resources.getDrawable(R.drawable.hit_play_3), "Selena Gomez Hits", "DJ Snake, Selena Gomez"))
        val categoryAdapter1= CategoryAdapter(categoryListType1)
        categoryRecyclerView1.adapter = categoryAdapter1

        categoryTitleTextView2.text="Jump back in"
        categoryTitleTextView2.typeface = typeface
        val categoryRecyclerView2:RecyclerView=view.findViewById(R.id.category_recycler_view2)
        categoryRecyclerView2.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        if(categoryListType2.isNotEmpty()){ categoryListType2.clear() }
        categoryListType2.add(CategoryModel(typefaceLight,typeface,resources.getDrawable(R.drawable.hit_play_1), "", "Selena Gomez, Justin Bieber"))
        categoryListType2.add(CategoryModel(typefaceLight,typeface,resources.getDrawable(R.drawable.hit_play_2), "", "Shawn Mendes, Camila Cabello"))
        categoryListType2.add(CategoryModel(typefaceLight,typeface,resources.getDrawable(R.drawable.hit_play_3), "", "DJ Snake, Selena Gomez"))
        val categoryAdapter2= CategoryAdapter(categoryListType2)
        categoryRecyclerView2.adapter = categoryAdapter2

        categoryTitleTextView3.text="More of what you like"
        categoryTitleTextView3.typeface = typeface
        val categoryRecyclerView3:RecyclerView=view.findViewById(R.id.category_recycler_view3)
        categoryRecyclerView3.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        if(categoryListType3.isNotEmpty()){ categoryListType3.clear() }
        categoryListType3.add(CategoryModel(typefaceLight,typeface,resources.getDrawable(R.drawable.hit_play_1), "", "Selena Gomez, Justin Bieber"))
        categoryListType3.add(CategoryModel(typefaceLight,typeface,resources.getDrawable(R.drawable.hit_play_2), "", "Shawn Mendes, Camila Cabello"))
        categoryListType3.add(CategoryModel(typefaceLight,typeface,resources.getDrawable(R.drawable.hit_play_3), "", "DJ Snake, Selena Gomez"))
        val categoryAdapter3= CategoryAdapter(categoryListType3)
        categoryRecyclerView3.adapter = categoryAdapter3

        categoryTitleTextView4.text="Today's biggest hits"
        categoryTitleTextView4.typeface = typeface
        val categoryRecyclerView4:RecyclerView=view.findViewById(R.id.category_recycler_view4)
        categoryRecyclerView4.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        if(categoryListType4.isNotEmpty()){ categoryListType4.clear() }
        categoryListType4.add(CategoryModel(typefaceLight,typeface,resources.getDrawable(R.drawable.hit_play_1), "", "Selena Gomez, Justin Bieber"))
        categoryListType4.add(CategoryModel(typefaceLight,typeface,resources.getDrawable(R.drawable.hit_play_2), "", "Shawn Mendes, Camila Cabello"))
        categoryListType4.add(CategoryModel(typefaceLight,typeface,resources.getDrawable(R.drawable.hit_play_3), "", "DJ Snake, Selena Gomez"))
        val categoryAdapter4= CategoryAdapter(categoryListType4)
        categoryRecyclerView4.adapter = categoryAdapter4

        categoryTitleTextView5.text="New Music Friday"
        categoryTitleTextView5.typeface = typeface
        val categoryRecyclerView5:RecyclerView=view.findViewById(R.id.category_recycler_view5)
        categoryRecyclerView5.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        if(categoryListType5.isNotEmpty()){ categoryListType5.clear() }
        categoryListType5.add(CategoryModel(typefaceLight,typeface,resources.getDrawable(R.drawable.hit_play_1), "", "Selena Gomez, Justin Bieber"))
        categoryListType5.add(CategoryModel(typefaceLight,typeface,resources.getDrawable(R.drawable.hit_play_2), "", "Shawn Mendes, Camila Cabello"))
        categoryListType5.add(CategoryModel(typefaceLight,typeface,resources.getDrawable(R.drawable.hit_play_3), "", "DJ Snake, Selena Gomez"))
        val categoryAdapter5= CategoryAdapter(categoryListType5)
        categoryRecyclerView5.adapter = categoryAdapter5

        categoryTitleTextView6.text="Wrapped 2020"
        categoryTitleTextView6.typeface = typeface
        val categoryRecyclerView6:RecyclerView=view.findViewById(R.id.category_recycler_view6)
        categoryRecyclerView6.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        if(categoryListType6.isNotEmpty()){ categoryListType6.clear() }
        categoryListType6.add(CategoryModel(typefaceLight,typeface,resources.getDrawable(R.drawable.hit_play_1), "", "Selena Gomez, Justin Bieber"))
        categoryListType6.add(CategoryModel(typefaceLight,typeface,resources.getDrawable(R.drawable.hit_play_2), "", "Shawn Mendes, Camila Cabello"))
        categoryListType6.add(CategoryModel(typefaceLight,typeface,resources.getDrawable(R.drawable.hit_play_3), "", "DJ Snake, Selena Gomez"))
        val categoryAdapter6= CategoryAdapter(categoryListType6)
        categoryRecyclerView6.adapter = categoryAdapter6

    }
}