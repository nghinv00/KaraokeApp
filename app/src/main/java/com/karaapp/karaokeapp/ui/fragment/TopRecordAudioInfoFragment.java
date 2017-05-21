package com.karaapp.karaokeapp.ui.fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.karaapp.karaokeapp.data.Config;

/**
 * Created package com.karaapp.karaokeapp.ui.fragment on 16/05/2017.
 * Author by NghiNV
 */

public class TopRecordAudioInfoFragment extends YouTubePlayerSupportFragment
            implements YouTubePlayer.OnInitializedListener {

    private static final String ARG_VIDEOID = "videoId";
    private String videoId;
    YouTubePlayerView youtubePlayer_Top_InfoRecord;
    private final static int RECOVERY_DIALOG_REQUEST = 1;
    public static boolean isCheck = false;
    public static YouTubePlayer isPlayer;

    public TopRecordAudioInfoFragment() {
    }

    public static TopRecordAudioInfoFragment newInstance(String videoId){
        TopRecordAudioInfoFragment fragment = new TopRecordAudioInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_VIDEOID, videoId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

        if ( saveInstanceState!= null && getArguments().containsKey(ARG_VIDEOID)){
            videoId = getArguments().getString(ARG_VIDEOID);
        } else if ( getArguments() != null && getArguments().containsKey(ARG_VIDEOID)){
            videoId = getArguments().getString(ARG_VIDEOID);
        }
        videoId = "nJ31sMmytHU";
        initialize(Config.YOUTUBE_API_KEY, this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        isCheck = true;
        isPlayer = youTubePlayer;
        isCheckStateFragment(youTubePlayer, b);
    }

    private void isCheckStateFragment(YouTubePlayer youTubePlayer, boolean b) {
        if (isCheck) {
            if (youTubePlayer != null && !b){
                youTubePlayer.loadVideo(videoId);
            } else {
                youTubePlayer.play();
            }
        } else {
            youTubePlayer.cueVideo(videoId);
        }
    }


    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(getActivity(), RECOVERY_DIALOG_REQUEST);
        } else {
            String errorMessage= String.format(
                    "Lỗi khi kết nối mạng. Vui lòng kiểm tra lại",
                    youTubeInitializationResult.toString());
            Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
    }

}
