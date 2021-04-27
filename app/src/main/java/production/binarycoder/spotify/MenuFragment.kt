package production.binarycoder.spotify

import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import production.binarycoder.spotify.adapters.SongDescriptionAdapter
import production.binarycoder.spotify.models.SongDescriptionModel


class MenuFragment : Fragment() {

    private var descriptionList=ArrayList<SongDescriptionModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNavigation:BottomNavigationView=view.findViewById(R.id.bottom_nav)
        val navController:  NavController= activity?.let { Navigation.findNavController(it, R.id.fragment2) }!!
        NavigationUI.setupWithNavController(bottomNavigation, navController)

        val musicPlayerBar:LinearLayout=view.findViewById(R.id.musicFragmentSwitcher)
        if(musicPlayerBar.isVisible){
            musicPlayerBar.setOnClickListener {
                val navController2=Navigation.findNavController(view)
                val action = MenuFragmentDirections.actionMenuFragmentToMusicFragment()
                action.musicStartMinute=1
                action.musicStartSecond=30
                action.musicEndMinute=3
                action.musicEndSecond=10
                navController2.navigate(action)
            }
            val albumImage:ImageView=view.findViewById(R.id.albumImageViewAtSwitcher)
            val favButton:CheckBox=view.findViewById(R.id.addFavButton)
            val musicController:CheckBox=view.findViewById(R.id.playButton)
            val descriptionRecyclerView: RecyclerView =view.findViewById(R.id.songDescriptionRecycler)

            descriptionRecyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            descriptionRecyclerView.setHasFixedSize(false)
            if(descriptionList.isNotEmpty()){ descriptionList.clear() }
            descriptionList.add(SongDescriptionModel("Liggi", "Ritviz"))
            descriptionList.add(SongDescriptionModel("Malayalam", "Shakira"))
            val songDescriptionAdapter= SongDescriptionAdapter(descriptionList)
            descriptionRecyclerView.adapter = songDescriptionAdapter
            albumImage.setImageDrawable(resources.getDrawable(R.drawable.liggi))

            favButton.setOnCheckedChangeListener{ button, changed->
                if(changed&&button.isPressed){
                    Toast.makeText(context, "Favourite On", Toast.LENGTH_SHORT).show()
                }
                else if(!changed&&button.isPressed){
                    Toast.makeText(context, "Favourite Off", Toast.LENGTH_SHORT).show()
                }
            }
            musicController.setOnCheckedChangeListener{ button, changed->
                if(changed&&button.isPressed){
                    Toast.makeText(context, "pause", Toast.LENGTH_SHORT).show()
                }
                else if(!changed&&button.isPressed){
                    Toast.makeText(context, "play", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}