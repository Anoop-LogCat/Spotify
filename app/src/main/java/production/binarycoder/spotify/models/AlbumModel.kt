package production.binarycoder.spotify.models

import android.graphics.drawable.Drawable

data class AlbumModel(val color:Int,val siNo:Int,val albumTitle:String,val albumPlayerCount:String,val imageAlbum:Drawable,val moreFunc:()->Unit,val clickAction:()->Unit)