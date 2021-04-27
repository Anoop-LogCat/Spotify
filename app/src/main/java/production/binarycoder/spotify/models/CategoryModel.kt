package production.binarycoder.spotify.models

import android.graphics.Typeface
import android.graphics.drawable.Drawable

data class CategoryModel(val fontLight: Typeface,val fontBold:Typeface, val image:Drawable, val albumTitle: String, val albumSubTitle: String)