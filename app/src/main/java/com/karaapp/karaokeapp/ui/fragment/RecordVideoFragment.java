package com.karaapp.karaokeapp.ui.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.mdl.VideoMdl;
import com.karaapp.karaokeapp.ui.activity.MainActivity;
import com.karaapp.karaokeapp.ui.activity.SplashScreenActivity;
import com.karaapp.karaokeapp.ui.adapter.VideoHorizontalAdapter;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecordVideoFragment extends BackFragment {
    private List<VideoMdl> videoYoutube = new ArrayList<>();
    private RecyclerView rcYoutube;
    private RecyclerView.LayoutManager gridLayoutManager;
    MainActivity activity;
    private static final String KEY_VIDEO_ID = "KEY_VIDEO_ID";
    private static final String KEY_TITTLE_ID = "KEY_TITLE_ID";
    private String tittle;
    private String mVideoId;
    private TextView record, txtTittle;
    private RelativeLayout relativeLayout;
    private PopupWindow mPopupWindow;
    private LayoutInflater layoutInflater;
    private TextView txtcancel, txtSave, txtPoint;
    private YouTubeFragment youtubefragment;

    public static final RecordVideoFragment newInstance() {
        RecordVideoFragment f = new RecordVideoFragment();
        Bundle bdl = new Bundle();
        f.setArguments(bdl);
        return f;
    }

    public static RecordVideoFragment newInstance(final String videoId, String tittle) {
        final RecordVideoFragment recordVideoFragment = new RecordVideoFragment();
        final Bundle bundle = new Bundle();
        bundle.putString(KEY_VIDEO_ID, videoId);
        bundle.putString(KEY_TITTLE_ID, tittle);
        recordVideoFragment.setArguments(bundle);
        return recordVideoFragment;
    }

    public RecordVideoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();


        //setRetainInstance(true);
        if (videoYoutube.size() == 0) {
            videoYoutube.add(new VideoMdl("nJ31sMmytHU", "Tiêu đề video karaoke you...", "https://i.ytimg.com/vi/nJ31sMmytHU/mqdefault.jpg", "04:18"));
            videoYoutube.add(new VideoMdl("nJ31sMmytHU", "Tiêu đề video karaoke you...", "https://i.ytimg.com/vi/nJ31sMmytHU/mqdefault.jpg", "04:18"));
            videoYoutube.add(new VideoMdl("nJ31sMmytHU", "Tiêu đề video karaoke you...", "https://i.ytimg.com/vi/nJ31sMmytHU/mqdefault.jpg", "04:18"));
            videoYoutube.add(new VideoMdl("nJ31sMmytHU", "Tiêu đề video karaoke you...", "https://i.ytimg.com/vi/nJ31sMmytHU/mqdefault.jpg", "04:18"));
            videoYoutube.add(new VideoMdl("nJ31sMmytHU", "Tiêu đề video karaoke you...", "https://i.ytimg.com/vi/nJ31sMmytHU/mqdefault.jpg", "04:18"));
            videoYoutube.add(new VideoMdl("nJ31sMmytHU", "Tiêu đề video karaoke you...", "https://i.ytimg.com/vi/nJ31sMmytHU/mqdefault.jpg", "04:18"));
            videoYoutube.add(new VideoMdl("nJ31sMmytHU", "Tiêu đề video karaoke you...", "https://i.ytimg.com/vi/nJ31sMmytHU/mqdefault.jpg", "04:18"));
            videoYoutube.add(new VideoMdl("nJ31sMmytHU", "Tiêu đề video karaoke you...", "https://i.ytimg.com/vi/nJ31sMmytHU/mqdefault.jpg", "04:18"));
            videoYoutube.add(new VideoMdl("nJ31sMmytHU", "Tiêu đề video karaoke you...", "https://i.ytimg.com/vi/nJ31sMmytHU/mqdefault.jpg", "04:18"));
            videoYoutube.add(new VideoMdl("nJ31sMmytHU", "Tiêu đề video karaoke you...", "https://i.ytimg.com/vi/nJ31sMmytHU/mqdefault.jpg", "04:18"));

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_yo, container, false);
        txtTittle = (TextView) v.findViewById(R.id.txtTitleVideo);
        final Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey(KEY_VIDEO_ID) && arguments.containsKey(KEY_TITTLE_ID)) {
            mVideoId = arguments.getString(KEY_VIDEO_ID);
            tittle = arguments.getString(KEY_TITTLE_ID);
        } else if (arguments != null && arguments.containsKey(KEY_VIDEO_ID) && arguments.containsKey(KEY_TITTLE_ID)) {
            mVideoId = arguments.getString(KEY_VIDEO_ID);
            tittle = arguments.getString(KEY_TITTLE_ID);
        }

        txtTittle.setText(tittle);
        relativeLayout = (RelativeLayout) v.findViewById(R.id.wrap_fragment);
        int orientation = this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            activity.mTittle.setVisibility(View.GONE);
            activity.mActionRecord.setVisibility(View.VISIBLE);
        } else {

        }
        record = (TextView) v.findViewById(R.id.record);
        youtubefragment = YouTubeFragment.newInstance(mVideoId);
        getFragmentManager().beginTransaction().replace(R.id.wrap_fragment, youtubefragment).addToBackStack(null).commit();
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
        rcYoutube = (RecyclerView) v.findViewById(R.id.rv_play_youtube);
        VideoHorizontalAdapter mVideoAdapter = new VideoHorizontalAdapter(videoYoutube);
        gridLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 2, GridLayoutManager.HORIZONTAL, false);
        rcYoutube.setLayoutManager(gridLayoutManager);
        rcYoutube.setAdapter(mVideoAdapter);
        activity.setImageDrawer(R.drawable.ic_arrow_back_black_24dp);
        activity.setClickDrawer(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.callFragment(SearchFragment.newInstance());
            }
        });
        return v;
    }

    public void showPopupMenu(final View view) {
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_box_record, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                int id = item.getItemId();
                switch (id) {
                    case R.id.record_mp3:
                        changeColorRecord();
                        return true;
                    case R.id.record_video:
                        changeColorRecord();
                        return true;
                    case R.id.share_video:
                        return true;
                    case R.id.like:
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();

        MenuPopupHelper menuHelper = new MenuPopupHelper(view.getContext(), (MenuBuilder) popupMenu.getMenu(), view);
        menuHelper.setForceShowIcon(true);
        menuHelper.show();
    }

    public void changeColorRecord() {
        record.setTextColor(Color.parseColor("#F44336"));
        record.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_micro_red, 0, R.drawable.ic_drop_down_right_red, 0);
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        record.setTextColor(Color.parseColor("#000000"));
                        record.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_micro_black, 0, R.drawable.ic_drop_down_right_blue, 0);
                        popUpPoint();
                    }
                });
            }
        };
        thread.start();
    }

    private void popUpPoint() {
        layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.popup_point, null);
        mPopupWindow = new PopupWindow(container, 800, 460, true);
        mPopupWindow.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, 10, 150);
        txtcancel = (TextView) container.findViewById(R.id.cancel);
        txtSave = (TextView) container.findViewById(R.id.save);
        txtPoint = (TextView) container.findViewById(R.id.txtPoint);

        txtcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
            }
        });
        txtSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(KEY_VIDEO_ID, mVideoId);
        savedInstanceState.putString(KEY_TITTLE_ID, tittle);
        super.onSaveInstanceState(savedInstanceState);

    }
}
