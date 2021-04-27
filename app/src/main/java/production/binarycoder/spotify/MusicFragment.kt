package production.binarycoder.spotify

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs

class MusicFragment : Fragment() {

    private lateinit var favButtonInMusicWindow:CheckBox
    private lateinit var playButtonInMusicWindow:CheckBox

    private lateinit var exitButtonInMusicWindow:ImageView
    private lateinit var moreButtonInMusicWindow:ImageView
    private lateinit var nextButtonInMusicWindow:ImageView
    private lateinit var previousButtonInMusicWindow:ImageView
    private lateinit var repeatButtonInMusicWindow:ImageView
    private lateinit var shuffleButtonInMusicWindow:ImageView
    private lateinit var wirelessButtonInMusicWindow:ImageView
    private lateinit var playListButtonInMusicWindow:ImageView

    private lateinit var timeStartTextViewInMusicWindow:TextView
    private lateinit var timeEndTextViewInMusicWindow:TextView
    private lateinit var songNameTextViewInMusicWindow:TextView
    private lateinit var singerNameTextViewInMusicWindow:TextView
    private lateinit var playFromTextViewInMusicWindow:TextView
    private lateinit var artistNameTextViewInMusicWindow:TextView
    private lateinit var lyricsBox:TextView

    private lateinit var timeSlider:SeekBar
    private lateinit var lyricsCard:CardView

    private var timer: CountDownTimer?=null
    private var isLyricsExist:Boolean=false
    private val argsInMusicFragment: MusicFragmentArgs by navArgs()
    private var musicFromMinute=0
    private var musicFromSecond=0
    private var musicToMinute=0
    private var musicToSecond=0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController:NavController=Navigation.findNavController(view)
        timeStartTextViewInMusicWindow=view.findViewById(R.id.timeStartTextView)
        timeEndTextViewInMusicWindow=view.findViewById(R.id.timeEndTextView)
        lyricsBox=view.findViewById(R.id.lyricsTextView)
        lyricsCard=view.findViewById(R.id.lyricsLayoutCard)
        timeSlider=view.findViewById(R.id.bar)

        timeStartTextViewInMusicWindow.text=if(argsInMusicFragment.musicStartSecond<10){"${argsInMusicFragment.musicStartMinute}:0${argsInMusicFragment.musicStartSecond}"}else{"${argsInMusicFragment.musicStartMinute}:${argsInMusicFragment.musicStartSecond}"}
        timeEndTextViewInMusicWindow.text=if(argsInMusicFragment.musicEndSecond<10){"${argsInMusicFragment.musicEndMinute}:0${argsInMusicFragment.musicEndSecond}"}else{"${argsInMusicFragment.musicEndMinute}:${argsInMusicFragment.musicEndSecond}"}
        timeSlider.max = ((argsInMusicFragment.musicEndMinute*60)+argsInMusicFragment.musicEndSecond)
        timeSlider.progress = (argsInMusicFragment.musicStartMinute*60)+argsInMusicFragment.musicStartSecond

        isLyricsExist=true
        if(isLyricsExist){
            lyricsCard.visibility=View.VISIBLE
            lyricsBox.text=resources.getString(R.string.lyrics).replace("\\\n", System.getProperty("line.separator"))
            lyricsBox.isSelected=true
        }
        else{
            lyricsCard.visibility=View.GONE
        }

        favButtonInMusicWindow=view.findViewById(R.id.addFavButtonMusicPlayer)
        favButtonInMusicWindow.setOnCheckedChangeListener{ button, changed->
            if(changed&&button.isPressed){
                Toast.makeText(context, "Favourite On", Toast.LENGTH_SHORT).show()
            }
            else if(!changed&&button.isPressed){
                Toast.makeText(context, "Favourite Off", Toast.LENGTH_SHORT).show()
            }
        }

        playButtonInMusicWindow=view.findViewById(R.id.play_buttonInMusic)
        playButtonInMusicWindow.setOnCheckedChangeListener{ button, changed->
            if(changed&&button.isPressed){
                if(musicFromMinute==0&&musicFromSecond==0&&musicToMinute==0&&musicToSecond==0){
                    musicTimeShowingWithSlider(true,argsInMusicFragment.musicStartMinute, argsInMusicFragment.musicStartSecond, argsInMusicFragment.musicEndMinute, argsInMusicFragment.musicEndSecond)
                }
                else{
                    musicTimeShowingWithSlider(true,musicFromMinute,musicFromSecond,musicToMinute,musicToSecond)
                }
            }
            else if(!changed&&button.isPressed){
                musicTimeShowingWithSlider(false,musicFromMinute,musicFromSecond,musicToMinute,musicToSecond)
            }
        }

        exitButtonInMusicWindow=view.findViewById(R.id.exit_windowImageView)
        exitButtonInMusicWindow.setOnClickListener {
            navController.popBackStack()
        }

        moreButtonInMusicWindow=view.findViewById(R.id.more_optionImageView)
        moreButtonInMusicWindow.setOnClickListener {
            navController.navigate(R.id.action_musicFragment_to_moreFragment)
        }

        nextButtonInMusicWindow=view.findViewById(R.id.next_buttonInMusic)
        nextButtonInMusicWindow.setOnClickListener {
            Toast.makeText(context, "next song", Toast.LENGTH_SHORT).show()
            musicTimeShowingWithSlider(true,0, 0, 2, 30)
        }

        previousButtonInMusicWindow=view.findViewById(R.id.previous_buttonInMusic)
        previousButtonInMusicWindow.setOnClickListener {
            Toast.makeText(context, "previous song", Toast.LENGTH_SHORT).show()
            musicTimeShowingWithSlider(true,0, 0, 3, 15)
        }

        repeatButtonInMusicWindow=view.findViewById(R.id.repeat_buttonInMusic)
        repeatButtonInMusicWindow.setOnClickListener {
            Toast.makeText(context, "repeat song", Toast.LENGTH_SHORT).show()
        }

        shuffleButtonInMusicWindow=view.findViewById(R.id.shuffle_buttonInMusic)
        shuffleButtonInMusicWindow.setOnClickListener {
            Toast.makeText(context, "shuffle song", Toast.LENGTH_SHORT).show()
        }

        songNameTextViewInMusicWindow=view.findViewById(R.id.songNameTextViewMusicPlayer)
        songNameTextViewInMusicWindow.text="Liggi"
        if(songNameTextViewInMusicWindow.length()>30){songNameTextViewInMusicWindow.isSelected=true}

        singerNameTextViewInMusicWindow=view.findViewById(R.id.artistNameTextViewMusicPlayer)
        singerNameTextViewInMusicWindow.text="Ritviz"

        playFromTextViewInMusicWindow=view.findViewById(R.id.playFromTextView)
        playFromTextViewInMusicWindow.text="PLAYING FROM ARTIST"

        artistNameTextViewInMusicWindow=view.findViewById(R.id.artistNameTextView)
        artistNameTextViewInMusicWindow.text="Ritviz"

        wirelessButtonInMusicWindow=view.findViewById(R.id.wirelessConnectImageView)
        wirelessButtonInMusicWindow.setOnClickListener {
            navController.navigate(R.id.action_musicFragment_to_wirelessFragment)
        }

        playListButtonInMusicWindow=view.findViewById(R.id.playListViewImageView)
        playListButtonInMusicWindow.setOnClickListener {
            navController.navigate(R.id.action_musicFragment_to_playListFragment)
        }
    }

    private fun musicTimeShowingWithSlider(startPlayingFlag:Boolean,startMinute: Int, startSecond: Int, endMinute: Int, endSecond: Int){
        var startMinWith=0
        var startSecWith=0
        musicFromSecond=startSecond
        musicFromMinute=startMinute
        musicToMinute=endMinute
        musicToSecond=endSecond
        if(startMinute!=0||startSecond!=0){
            startMinWith = endMinute - startMinute
            startSecWith = endSecond - startSecond
        }
        else{
            startMinWith = endMinute
            startSecWith = endSecond
        }
        timer?.cancel()
        timeEndTextViewInMusicWindow.text=if(endSecond<10){"$endMinute:0$endSecond"}else{"$endMinute:$endSecond"}
        timeSlider.max = ((endMinute*60)+endSecond)
        if(startPlayingFlag){
            timer = object : CountDownTimer(((startMinWith * 60) + startSecWith) * 1000.toLong(), 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    if(musicFromSecond>59){
                        musicFromSecond=0
                        musicFromMinute++
                    }
                    timeStartTextViewInMusicWindow.text =if(musicFromSecond<10){ "$musicFromMinute:0$musicFromSecond" } else{ "$musicFromMinute:$musicFromSecond" }
                    timeSlider.progress = (musicFromMinute*60)+musicFromSecond
                    musicFromSecond++
                }
                override fun onFinish() {
                }
            }.start()
            timeSlider.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    musicTimeShowingWithSlider(true,seekBar.progress/60,seekBar.progress%60,endMinute,endSecond)
                }
                override fun onStartTrackingTouch(seekBar: SeekBar) { }
                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) { }
            })
        }
        else{
            timeStartTextViewInMusicWindow.text=if(startSecond<10){"$startMinute:0$startSecond"}else{"$startMinute:$startSecond"}
        }
    }
}