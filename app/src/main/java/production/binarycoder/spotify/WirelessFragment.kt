package production.binarycoder.spotify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.navigation.Navigation

class WirelessFragment : Fragment() {

    private lateinit var closeButton:ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_wireless, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        closeButton=view.findViewById(R.id.close_button_in_wireless)
        val navController:NavController=Navigation.findNavController(view)
        closeButton.setOnClickListener {
            navController.popBackStack()
        }
    }
}