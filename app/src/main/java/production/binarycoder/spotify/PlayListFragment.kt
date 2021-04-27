package production.binarycoder.spotify

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import production.binarycoder.spotify.adapters.ItemMoveCallback
import production.binarycoder.spotify.adapters.PlayListViewAdapter
import production.binarycoder.spotify.models.PlayListViewModel


class PlayListFragment : Fragment() {

    private lateinit var closeButton:ImageView
    private lateinit var nowPlayAlbumImageView:ImageView
    private lateinit var nowPlayAlbumName:TextView
    private lateinit var nowPlayAlbumSinger:TextView
    private lateinit var nextPlayFromTextView:TextView
    private lateinit var artistNameTextView:TextView
    private lateinit var playFromTextView:TextView
    private lateinit var playListRecyclerViewInPlayListFragment:RecyclerView
    private lateinit var playButtonInPlayListWindow: CheckBox
    private lateinit var nextButtonInPlayListWindow:ImageView
    private lateinit var previousButtonInPlayListWindow:ImageView

    private var playArrayList=ArrayList<PlayListViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_play_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController:NavController=Navigation.findNavController(view)

        nowPlayAlbumImageView=view.findViewById(R.id.now_playingImageView)
        nowPlayAlbumName=view.findViewById(R.id.now_playingTextView_1)
        nowPlayAlbumSinger=view.findViewById(R.id.now_playingTextView_2)
        nextPlayFromTextView=view.findViewById(R.id.musicFromTextView)
        artistNameTextView=view.findViewById(R.id.artistNameTextViewInPlayList)
        playFromTextView=view.findViewById(R.id.playFromTextViewInPlayList)
        nowPlayAlbumImageView.setImageDrawable(resources.getDrawable(R.drawable.liggi))
        nowPlayAlbumName.text="Liggi"
        nowPlayAlbumSinger.text="Ritviz"
        nextPlayFromTextView.text="Next From:"
        playFromTextView.text="PLAYING FROM ARTIST"
        artistNameTextView.text="Ritviz"

        closeButton=view.findViewById(R.id.close_button_in_playlist)
        closeButton.setOnClickListener {
            navController.popBackStack()
        }

        playButtonInPlayListWindow=view.findViewById(R.id.play_buttonInPlaylist)
        playButtonInPlayListWindow.setOnCheckedChangeListener{ button, changed->
            if(changed&&button.isPressed){
                Toast.makeText(context, "Play", Toast.LENGTH_SHORT).show()
            }
            else if(!changed&&button.isPressed){
               Toast.makeText(context, "Pause", Toast.LENGTH_SHORT).show()
            }
        }

        nextButtonInPlayListWindow=view.findViewById(R.id.next_buttonInPlaylist)
        nextButtonInPlayListWindow.setOnClickListener {
            Toast.makeText(context, "next play", Toast.LENGTH_SHORT).show()
        }

        previousButtonInPlayListWindow=view.findViewById(R.id.previous_buttonInPlaylist)
        previousButtonInPlayListWindow.setOnClickListener {
            Toast.makeText(context, "previous play", Toast.LENGTH_SHORT).show()
        }

        playListRecyclerViewInPlayListFragment=view.findViewById(R.id.recyclerViewInPlayList)
        playListRecyclerViewInPlayListFragment.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        if(playArrayList.isNotEmpty()){ playArrayList.clear() }
        playArrayList.add(PlayListViewModel(resources, "Udd Gaye", "Ritviz", playAction = {
            Toast.makeText(requireContext(), "play clicked", Toast.LENGTH_SHORT).show()
        }))
        playArrayList.add(PlayListViewModel(resources, "Sage", "Ritviz", playAction = {
            Toast.makeText(context, "play clicked", Toast.LENGTH_SHORT).show()
        }))
        playArrayList.add(PlayListViewModel(resources, "Chalo Chalein", "Ritviz, Seedhe Maut", playAction = {
            Toast.makeText(context, "play clicked", Toast.LENGTH_SHORT).show()
        }))
        playArrayList.add(PlayListViewModel(resources, "Jeet", "Ritviz", playAction = {
            Toast.makeText(context, "play clicked", Toast.LENGTH_SHORT).show()
        }))
        playArrayList.add(PlayListViewModel(resources, "Thandi Hawa", "Ritviz", playAction = {
            Toast.makeText(context, "play clicked", Toast.LENGTH_SHORT).show()
        }))
        playArrayList.add(PlayListViewModel(resources, "Pran", "Ritviz", playAction = {
            Toast.makeText(context, "play clicked", Toast.LENGTH_SHORT).show()
        }))
        playArrayList.add(PlayListViewModel(resources, "Raahi", "Ritviz", playAction = {
            Toast.makeText(context, "play clicked", Toast.LENGTH_SHORT).show()
        }))
        playArrayList.add(PlayListViewModel(resources, "Sun Toh", "Ritviz", playAction = {
            Toast.makeText(context, "play clicked", Toast.LENGTH_SHORT).show()
        }))
        playArrayList.add(PlayListViewModel(resources, "Roshini", "Sickflip, Ritviz, Seedhe Maut", playAction = {
            Toast.makeText(context, "play clicked", Toast.LENGTH_SHORT).show()
        }))
        val playAdapter = PlayListViewAdapter(playArrayList)
        val callback: ItemTouchHelper.Callback = ItemMoveCallback(playAdapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(playListRecyclerViewInPlayListFragment)
        playListRecyclerViewInPlayListFragment.adapter = playAdapter


    }
}