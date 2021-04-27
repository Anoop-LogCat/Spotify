package production.binarycoder.spotify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import production.binarycoder.spotify.adapters.AlbumListAdapter
import production.binarycoder.spotify.models.AlbumModel

class AlbumFragment : Fragment() {

    private lateinit var collapsingToolBar:CollapsingToolbarLayout
    private lateinit var appBarLayout: AppBarLayout

    private lateinit var closeButton:ImageView
    private lateinit var followButton:TextView
    private lateinit var titleAlbumAfterCollapsed:TextView
    private lateinit var moreButton:ImageView
    private lateinit var titleAlbumBeforeCollapsed:TextView
    private lateinit var subTitleAlbum:TextView
    private lateinit var playButton:FrameLayout
    private lateinit var albumRecyclerView:RecyclerView

    private var albumList=ArrayList<AlbumModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_album, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController:NavController=Navigation.findNavController(view)
        collapsingToolBar=view.findViewById(R.id.collapsingToolbar)

        closeButton=view.findViewById(R.id.closeButtonInAlbum)
        closeButton.setOnClickListener {
            navController.popBackStack()
        }

        titleAlbumBeforeCollapsed=view.findViewById(R.id.titleInAlbum)
        subTitleAlbum=view.findViewById(R.id.subInAlbum)
        titleAlbumAfterCollapsed=view.findViewById(R.id.titleTextViewInAlbum)
        titleAlbumBeforeCollapsed.text="Ritviz"
        titleAlbumAfterCollapsed.text="Ritviz"
        subTitleAlbum.text="2,421,353 MONTHLY LISTENERS"

        playButton=view.findViewById(R.id.playShuffleButton)
        playButton.setOnClickListener {
            Toast.makeText(context,"Play shuffle on",Toast.LENGTH_SHORT).show()
        }

        moreButton=view.findViewById(R.id.more_optionImageViewInAlbum)
        moreButton.setOnClickListener {
            Toast.makeText(context,"more clicked",Toast.LENGTH_SHORT).show()
        }

        followButton=view.findViewById(R.id.followButton)
        followButton.setOnClickListener {
            Toast.makeText(context,"follow clicked",Toast.LENGTH_SHORT).show()
        }

        appBarLayout=view.findViewById(R.id.appBarLayout)
        appBarLayout.addOnOffsetChangedListener(
            AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
                if (verticalOffset == 0) {
                    titleAlbumAfterCollapsed.visibility=View.GONE
                    followButton.background = resources.getDrawable(R.drawable.flowbackgrounddefaultstate)
                } else if(verticalOffset== -836){
                    titleAlbumAfterCollapsed.visibility=View.VISIBLE
                    followButton.background = resources.getDrawable(R.drawable.flowbackgroundhoverstate)
                }
            })

        albumRecyclerView=view.findViewById(R.id.albumRecyclerView)
        albumRecyclerView.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        if(albumList.isNotEmpty()){albumList.clear()}
        albumList.add(AlbumModel(resources.getColor(R.color.spotify_green),1,"Liggi","45,316,303",resources.getDrawable(R.drawable.liggi),moreFunc = {
            Toast.makeText(context,"More clicked",Toast.LENGTH_SHORT).show()
        },clickAction = {
            Toast.makeText(context,"clicked to play",Toast.LENGTH_SHORT).show()
        }))
        albumList.add(AlbumModel(resources.getColor(R.color.spotify_green),2,"Udd Gaye","35,316,303",resources.getDrawable(R.drawable.udd_gaye),moreFunc = {
            Toast.makeText(context,"More clicked",Toast.LENGTH_SHORT).show()
        },clickAction = {
            Toast.makeText(context,"clicked to play",Toast.LENGTH_SHORT).show()
        }))
        albumList.add(AlbumModel(resources.getColor(R.color.spotify_green),3,"Sage","25,334,303",resources.getDrawable(R.drawable.udd_gaye),moreFunc = {
            Toast.makeText(context,"More clicked",Toast.LENGTH_SHORT).show()
        },clickAction = {
            Toast.makeText(context,"clicked to play",Toast.LENGTH_SHORT).show()
        }))
        albumList.add(AlbumModel(resources.getColor(R.color.spotify_green),4,"Chalo Chalein","45,316,303",resources.getDrawable(R.drawable.jeet),moreFunc = {
            Toast.makeText(context,"More clicked",Toast.LENGTH_SHORT).show()
        },clickAction = {
            Toast.makeText(context,"clicked to play",Toast.LENGTH_SHORT).show()
        }))
        albumList.add(AlbumModel(resources.getColor(R.color.spotify_green),5,"Jeet","45,316,303",resources.getDrawable(R.drawable.liggi),moreFunc = {
            Toast.makeText(context,"More clicked",Toast.LENGTH_SHORT).show()
        },clickAction = {
            Toast.makeText(context,"clicked to play",Toast.LENGTH_SHORT).show()
        }))
        albumList.add(AlbumModel(resources.getColor(R.color.spotify_green),6,"Ved","45,316,303",resources.getDrawable(R.drawable.jeet),moreFunc = {
            Toast.makeText(context,"More clicked",Toast.LENGTH_SHORT).show()
        },clickAction = {
            Toast.makeText(context,"clicked to play",Toast.LENGTH_SHORT).show()
        }))
        albumList.add(AlbumModel(resources.getColor(R.color.spotify_green),7,"Barso","45,316,303",resources.getDrawable(R.drawable.liggi),moreFunc = {
            Toast.makeText(context,"More clicked",Toast.LENGTH_SHORT).show()
        },clickAction = {
            Toast.makeText(context,"clicked to play",Toast.LENGTH_SHORT).show()
        }))
        val adapter = AlbumListAdapter(albumList)
        albumRecyclerView.adapter=adapter


    }

}