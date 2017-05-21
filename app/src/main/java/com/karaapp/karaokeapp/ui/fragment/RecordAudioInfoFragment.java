package com.karaapp.karaokeapp.ui.fragment;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.ForwardingListener;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.data.Resource;
import com.karaapp.karaokeapp.mdl.RecordVidMdl;
import com.karaapp.karaokeapp.ui.activity.MainActivity;
import com.karaapp.karaokeapp.ui.adapter.RecordAudioInfoAdapter;

import java.util.ArrayList;
import java.util.List;


public class RecordAudioInfoFragment extends BackFragment {

    private static final String ARG_VIDEOID = "AudioId";
    private static final String ARG_VIDEONAME = "AudioName";
    private String videoId;
    private String videoName;
    private TextView nameSong;
    private ImageView ivShare, ivEdit, ivDelete;
    private RecyclerView recycleViewAudio;
    private List<RecordVidMdl> listRecordAudios = new ArrayList<>();
    private final int COLUMN_GRIDLAYOUT = 2;
    BackFragment.BackPressLister backPressLister;
    private MainActivity activity;
    YouTubePlayerSupportFragment currentFragment;
    RecordAudioInfoAdapter adapter;
    public RecordAudioInfoFragment() {
        // Required empty public constructor
    }

    public static RecordAudioInfoFragment newInstance(String param1, String param2) {
        RecordAudioInfoFragment fragment = new RecordAudioInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_VIDEOID, param1);
        args.putString(ARG_VIDEONAME, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public RecordAudioInfoFragment(BackFragment.BackPressLister backPressLister) {
        this.backPressLister = backPressLister;
    }

    public static RecordAudioInfoFragment newInstance(BackFragment.BackPressLister backPressLister) {
        RecordAudioInfoFragment fragment = new RecordAudioInfoFragment(backPressLister);
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
        Bundle args = getArguments();
        if (savedInstanceState != null && getArguments().containsKey(ARG_VIDEOID) && getArguments().containsKey(ARG_VIDEONAME)) {
            videoId = getArguments().getString(ARG_VIDEOID);
            videoName = getArguments().getString(ARG_VIDEONAME);
        } else if (getArguments() != null && getArguments().containsKey(ARG_VIDEONAME) && getArguments().containsKey(ARG_VIDEOID)) {
            videoId = getArguments().getString(ARG_VIDEOID);
            videoName = getArguments().getString(ARG_VIDEONAME);
        }

        if (listRecordAudios.size() == 0) {
            listRecordAudios.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
            listRecordAudios.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "Thời gian: 30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
            listRecordAudios.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "Thời gian: 30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
            listRecordAudios.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "Thời gian: 30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
            listRecordAudios.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "Thời gian: 30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
            listRecordAudios.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "Thời gian: 30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
            listRecordAudios.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "Thời gian: 30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
            listRecordAudios.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "Thời gian: 30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
            listRecordAudios.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "Thời gian: 30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
            listRecordAudios.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "Thời gian: 30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
        }
        callFragment(TopRecordAudioInfoFragment.newInstance(videoId));

    }
    public void callFragment(Fragment fragment) {
        if (currentFragment instanceof YouTubePlayerSupportFragment) {
            currentFragment = (YouTubePlayerSupportFragment) fragment;
        } else {
            currentFragment = null;
        }
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragmentYoutubePlay_Mp3, fragment);
        transaction.commit();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity.setTitle(Resource.getInstance(getContext()).getString(R.string.list_record_info_mp3));
        activity.setImageDrawer(R.drawable.ic_arrow_back_black_24dp);
        activity.setClickDrawer(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TopRecordAudioInfoFragment.isCheck = false;
                if (TopRecordAudioInfoFragment.isCheck) {
                    TopRecordAudioInfoFragment.isPlayer.pause();
                }
                activity.callFragment(RecordListAudioFragment.newInstance());
                activity.setTitle(Resource.getInstance(getContext()).getString(R.string.list_record_mp3));
            }
        });

        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_record_audio_info, container, false);
        nameSong = (TextView) view.findViewById(R.id.nameSong);
        setTitle(videoName);
        ivEdit = (ImageView) view.findViewById(R.id.ivEditInfo);
        ivShare = (ImageView) view.findViewById(R.id.ivShareInfo);
        ivDelete = (ImageView) view.findViewById(R.id.ivDeleteInfo);
        recycleViewAudio = (RecyclerView) view.findViewById(R.id.recycler_info_audio);
        adapter = new RecordAudioInfoAdapter(listRecordAudios);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), COLUMN_GRIDLAYOUT, GridLayoutManager.HORIZONTAL, false);
        recycleViewAudio.setLayoutManager(gridLayoutManager);
        recycleViewAudio.setItemAnimator(new DefaultItemAnimator());
        recycleViewAudio.setAdapter(adapter);
        recycleViewAudio.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
        adapter.setOnItemClickListener(new RecordAudioInfoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                callFragment(TopRecordAudioInfoFragment.newInstance(listRecordAudios.get(position).getIdVideoRecord()));
                nameSong.setText(listRecordAudios.get(position).getmTittle());
            }
        });
        return view;
    }

    public void setTitle(String title) {
        nameSong.setText(title);
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(ARG_VIDEOID, videoId);
        bundle.putString(ARG_VIDEONAME, videoName);
    }

}
