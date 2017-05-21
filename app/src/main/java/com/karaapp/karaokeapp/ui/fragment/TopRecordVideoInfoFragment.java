package com.karaapp.karaokeapp.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.data.Config;

/**
 * tại class YouTubePlayerFragment nếu extends YoutubePlayerFragment thì sẽ lỗi ép kiểu từ YoutubePlayerFragment sang FRagment
 * Còn với YouTubePlayerSupportFragment sẽ hỗ trợ ép kiểu từ YoutubePlayerFragment sang kiểu Fragment
 */
public class TopRecordVideoInfoFragment extends YouTubePlayerSupportFragment
        implements YouTubePlayer.OnInitializedListener, YouTubePlayer.PlaybackEventListener {

    private static final String ARG_VideoId = "videoId";
    private String videoId;
    YouTubePlayerView youtubePlayer_Top_InfoRecord;
    private final static int RECOVERY_DIALOG_REQUEST = 1;
    private FragmentActivity myContext;
    public static boolean isCheck = false;
    public static YouTubePlayer isPlayer;

    @Override
    public void onAttach(Activity activity) {
        if (activity instanceof FragmentActivity) {
            myContext = (FragmentActivity) activity;
        }
        super.onAttach(activity);
    }

    public TopRecordVideoInfoFragment() {
        // Required empty public constructor
    }

    public static TopRecordVideoInfoFragment newInstance(String param1) {
        TopRecordVideoInfoFragment fragment = new TopRecordVideoInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_VideoId, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Bundle arguments = getArguments();     // test dữ liệu trả về có đúng hay ko..

        if (savedInstanceState != null && getArguments().containsKey(ARG_VideoId)) {
            videoId = getArguments().getString(ARG_VideoId);
        } else if (getArguments() != null && getArguments().containsKey(ARG_VideoId)) {
            videoId = getArguments().getString(ARG_VideoId);
        }
        videoId = "nJ31sMmytHU";

        initialize(Config.YOUTUBE_API_KEY, this);

    }

    @Override
    public void onInitializationSuccess( YouTubePlayer.Provider provider,YouTubePlayer youTubePlayer, boolean b) {
        isPlayer = youTubePlayer;
        isCheck = true;
        isCheckStateFragment(youTubePlayer, b);
//        if (youTubePlayer != null && !b) {
//            youTubePlayer.loadVideo(videoId);
//        } else {
//            youTubePlayer.play();
//        }

        // youTubePlayer.cueVideo(videoId);
    }

    /***
     * Khi người dùng click vào image drawer thì sẽ tạm dùng bài hat lại
     * @param youTubePlayer
     * @param b
     */
    public void isCheckStateFragment(YouTubePlayer youTubePlayer, boolean b) {
        if (isCheck) {
            if (youTubePlayer != null && !b) {
                youTubePlayer.loadVideo(videoId);
            } else {
                youTubePlayer.play();
            }
        } else {
            youTubePlayer.pause();
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        // TODO Auto-generated method stub
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(myContext, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    "Lỗi khi kết nối mạng. Vui lòng kiểm tra lại",
                    youTubeInitializationResult.toString());
            Toast.makeText(myContext, errorMessage, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(ARG_VideoId, videoId);
    }

    @Override
    public void onPlaying() {

    }

    @Override
    public void onPaused() {
//        isPlayer.pause();
    }

    @Override
    public void onStopped(){
//        isPlayer.pause();
    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }

}
