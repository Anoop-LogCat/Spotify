package production.binarycoder.spotify.models

import android.graphics.Typeface
import android.graphics.drawable.Drawable

data class RecentlyPlayedModel(val font:Typeface,val name:String, val image:Drawable,val clickAction:()->Unit)