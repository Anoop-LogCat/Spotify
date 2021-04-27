package production.binarycoder.spotify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import production.binarycoder.spotify.adapters.MoreAdapter
import production.binarycoder.spotify.adapters.RecentAdapter
import production.binarycoder.spotify.models.MoreModel
import production.binarycoder.spotify.models.RecentlyPlayedModel

class MoreFragment : Fragment() {

    private lateinit var shuffleButton:LinearLayout
    private lateinit var repeatButton:LinearLayout
    private lateinit var queueButton:LinearLayout
    private lateinit var albumImage:ImageView
    private lateinit var songTextView:TextView
    private lateinit var artistTextView:TextView
    private lateinit var moreRecyclerView:RecyclerView

    private var moreList=ArrayList<MoreModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_more, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shuffleButton=view.findViewById(R.id.shuffleButtonInMore)
        repeatButton=view.findViewById(R.id.repeatButtonInMore)
        queueButton=view.findViewById(R.id.queueButtonInMore)
        albumImage=view.findViewById(R.id.imageViewInMore)
        songTextView=view.findViewById(R.id.songNameInMore)
        artistTextView=view.findViewById(R.id.artistNameInMore)
        moreRecyclerView=view.findViewById(R.id.recyclerInMore)

        val navController:NavController=Navigation.findNavController(view)

        shuffleButton.setOnClickListener {
            Toast.makeText(context,"shuffle clicked",Toast.LENGTH_SHORT).show()
        }

        repeatButton.setOnClickListener {
            Toast.makeText(context,"repeat clicked",Toast.LENGTH_SHORT).show()
        }

        queueButton.setOnClickListener {
            navController.navigate(R.id.action_moreFragment_to_playListFragment)
        }

        albumImage.setImageDrawable(resources.getDrawable(R.drawable.ritviz_background))
        songTextView.text = "Liggi"
        artistTextView.text="Ritviz"

        moreRecyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        if(moreList.isNotEmpty()){ moreList.clear() }
        moreList.add(MoreModel(resources.getDrawable(R.drawable.more_like_icon),"Like") {
            Toast.makeText(context, "Like Clicked", Toast.LENGTH_SHORT).show()
        })
        moreList.add(MoreModel(resources.getDrawable(R.drawable.more_add_play_icon),"Add to Playlist") {
            Toast.makeText(context, "Like Clicked", Toast.LENGTH_SHORT).show()
        })
        moreList.add(MoreModel(resources.getDrawable(R.drawable.more_add_queue_icon),"Add to Queue")  {
            Toast.makeText(context, "Like Clicked", Toast.LENGTH_SHORT).show()
        })
        moreList.add(MoreModel(resources.getDrawable(R.drawable.more_view_album_icon),"View Album") {
            Toast.makeText(context, "Like Clicked", Toast.LENGTH_SHORT).show()
        })
        moreList.add(MoreModel(resources.getDrawable(R.drawable.more_view_artist_icon),"View Artist") {
            Toast.makeText(context, "Like Clicked", Toast.LENGTH_SHORT).show()
        })
        moreList.add(MoreModel(resources.getDrawable(R.drawable.more_share_icon),"Share") {
            Toast.makeText(context, "Like Clicked", Toast.LENGTH_SHORT).show()
        })
        moreList.add(MoreModel(resources.getDrawable(R.drawable.more_sleep_icon),"Sleep Timer") {
            Toast.makeText(context, "Like Clicked", Toast.LENGTH_SHORT).show()
        })
        moreList.add(MoreModel(resources.getDrawable(R.drawable.more_show_credits_icon),"Show Credits") {
            Toast.makeText(context, "Like Clicked", Toast.LENGTH_SHORT).show()
        })
        val moreAdapter = MoreAdapter(moreList)
        moreRecyclerView.adapter = moreAdapter

    }

}