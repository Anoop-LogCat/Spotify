package production.binarycoder.spotify.models

import android.content.res.Resources

data class PlayListViewModel (val resources:Resources,val songName:String,val artistName:String,val playAction:()->Unit)