package com.karaapp.karaokeapp.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.data.Resource;
import com.karaapp.karaokeapp.mdl.RecordVidMdl;
import com.karaapp.karaokeapp.ui.activity.MainActivity;
import com.karaapp.karaokeapp.ui.adapter.RecordVideoInfoAdapter;
import com.karaapp.karaokeapp.ui.dialog.DeleteFileDialog;

import java.util.ArrayList;
import java.util.List;

public class RecordVideoInfoFragment extends BackFragment {

    private static final String ARG_videoId = "videoId";
    public static final String ARG_VideoName = "videoName";
    private String videoId, videoName;
    private TextView nameSong;
    private ImageView ivEditInfo, ivShareInfo, ivDeleteInfo;
    private RecyclerView recycler_info_video;
    private MainActivity activity;
    private YouTubePlayerSupportFragment currentFragment;
    private RecordVideoInfoAdapter adapter;
    private List<RecordVidMdl> listRecordVideos = new ArrayList<>();
    private final int COLUMN_GRIDLAYOUT = 2;
    TopRecordVideoInfoFragment top;
    BackFragment.BackPressLister backPressLister;

    public RecordVideoInfoFragment() {

    }

    public RecordVideoInfoFragment(BackFragment.BackPressLister backPressLister) {
        this.backPressLister = backPressLister;
    }

    public static RecordVideoInfoFragment newInstance(String videoId, String videoName) {
        RecordVideoInfoFragment fragment = new RecordVideoInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_videoId, videoId);
        args.putString(ARG_VideoName, videoName);
        fragment.setArguments(args);
        return fragment;
    }

    public static RecordVideoInfoFragment newInstance(BackFragment.BackPressLister backPressLister) {
        RecordVideoInfoFragment fragment = new RecordVideoInfoFragment(backPressLister);
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        activity = (MainActivity) getActivity();
        Bundle args = getArguments();

        if (savedInstanceState != null && getArguments().containsKey(ARG_videoId) && getArguments().containsKey(ARG_VideoName)) {
            videoId = savedInstanceState.getString(ARG_videoId);
            videoName = savedInstanceState.getString(ARG_VideoName);
        } else if (getArguments() != null && getArguments().containsKey(ARG_videoId) && getArguments().containsKey(ARG_VideoName)) {
            videoId = getArguments().getString(ARG_videoId);
            videoName = getArguments().getString(ARG_VideoName);
        }

        callFragment(TopRecordVideoInfoFragment.newInstance(videoId));

        if (listRecordVideos.size() == 0) {
            listRecordVideos.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
            listRecordVideos.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "Thời gian: 30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
            listRecordVideos.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "Thời gian: 30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
            listRecordVideos.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "Thời gian: 30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
            listRecordVideos.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "Thời gian: 30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
            listRecordVideos.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "Thời gian: 30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
            listRecordVideos.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "Thời gian: 30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
            listRecordVideos.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "Thời gian: 30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
            listRecordVideos.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "Thời gian: 30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
            listRecordVideos.add(new RecordVidMdl("04D8qRJlYRY", "https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg", "ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ", "Thời gian: 30/04/2017 22:30:15", "2.5", "100", "100", "04:15"));
        }

    }

    public void callFragment(Fragment fragment) {
        if (fragment instanceof YouTubePlayerSupportFragment) {
            currentFragment = (YouTubePlayerSupportFragment) fragment;
        } else {
            currentFragment = null;
        }

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragmentYoutubePlay, fragment);
        transaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        activity.setTitle(Resource.getInstance(getContext()).getString(R.string.list_record_info_vid));
        activity.setImageDrawer(R.drawable.ic_arrow_back_black_24dp);
        activity.setClickDrawer(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TopRecordVideoInfoFragment.isCheck = false;
                if (TopRecordVideoInfoFragment.isCheck) {
                    TopRecordVideoInfoFragment.isPlayer.pause();
                }
                activity.callFragment(RecordListVideoFragment.newInstance());
                activity.setTitle(Resource.getInstance(getContext()).getString(R.string.list_record_info_vid));
            }
        });
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_record_video_info, container, false);
        nameSong = (TextView) rootView.findViewById(R.id.nameSong);
        setTitle(videoName);
        ivEditInfo = (ImageView) rootView.findViewById(R.id.ivEditInfo);
        ivShareInfo = (ImageView) rootView.findViewById(R.id.ivShareInfo);
        ivDeleteInfo = (ImageView) rootView.findViewById(R.id.ivDeleteInfo);
        recycler_info_video = (RecyclerView) rootView.findViewById(R.id.recycler_info_video);
        adapter = new RecordVideoInfoAdapter(listRecordVideos);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), COLUMN_GRIDLAYOUT, GridLayoutManager.HORIZONTAL, false);
        // RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycler_info_video.setLayoutManager(gridLayoutManager);
        recycler_info_video.setItemAnimator(new DefaultItemAnimator());
        recycler_info_video.setAdapter(adapter);
        recycler_info_video.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
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

        adapter.setOnItemLickListener(new RecordVideoInfoAdapter.OnItemLickListener() {
            @Override
            public void onItemLick(View itemView, int position) {
                RecordVidMdl mdl = listRecordVideos.get(position);
                callFragment(TopRecordVideoInfoFragment.newInstance(mdl.getIdVideoRecord()));
                nameSong.setText(listRecordVideos.get(position).getmTittle());
            }

        });
        adapter.setOnLongItemListener(new RecordVideoInfoAdapter.OnLongClickListener() {
            @Override
            public boolean onLongItemClick(View itemview, int position) {
                Toast.makeText(getContext(), position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivShareInfo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(activity, "item share", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        ivShareInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 String pathSharing = "https://www.youtube.com/watch?v=jFVualFdYuQ";
                 Intent shareIntent = new Intent();
                 shareIntent.setAction(Intent.ACTION_SEND);
                 shareIntent.putExtra(Intent.EXTRA_TEXT, "Text");
                 shareIntent.putExtra(Intent.EXTRA_STREAM, pathSharing);
                 shareIntent.setType("video/*");
                 shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                 startActivity(Intent.createChooser(shareIntent, "send"));
                 */

                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/*");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "https://www.youtube.com/watch?v=jFVualFdYuQ");
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });
        ivEditInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ivDeleteInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteFileDialog dialog = new DeleteFileDialog(activity);
                dialog.show();
            }
        });

        return rootView;
    }

    public void setTitle(String title) {
        nameSong.setText(videoName);
    }

    @Override
    public void onSaveInstanceState(Bundle bdl) {
        super.onSaveInstanceState(bdl);
        bdl.putString(ARG_videoId, videoId);
        bdl.putString(ARG_VideoName, videoName);
    }

}
