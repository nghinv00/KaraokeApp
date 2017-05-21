package com.karaapp.karaokeapp.ui.fragment;


import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.data.Resource;
import com.karaapp.karaokeapp.mdl.RecordVidMdl;
import com.karaapp.karaokeapp.ui.activity.MainActivity;
import com.karaapp.karaokeapp.ui.adapter.RecordAudioAdapter;
import com.karaapp.karaokeapp.ui.adapter.RecordVideoAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */

    public class RecordListAudioFragment extends BackFragment {
    private RecordAudioAdapter mAudioAdapter;
    private List<RecordVidMdl> mAudio = new ArrayList<>();
    private MainActivity activity;
    private RecyclerView recyclerView;
    private RecordVideoAdapter recordVideoAdapter;
    private BackFragment.BackPressLister backPressLister;


        public static final RecordListAudioFragment newInstance() {
            RecordListAudioFragment f = new RecordListAudioFragment();
            Bundle bdl = new Bundle();
            f.setArguments(bdl);
            return f;
        }
        public RecordListAudioFragment(BackFragment.BackPressLister backPressListener) {
            this.backPressLister = backPressListener;
        }
        public static final RecordListAudioFragment newInstance(BackFragment.BackPressLister backPressListener) {
            RecordListAudioFragment f = new RecordListAudioFragment(backPressListener);
            Bundle bdl = new Bundle();
            f.setArguments(bdl);
            return f;
        }
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            activity = (MainActivity) getActivity();
            if(mAudio.size() ==0){
                mAudio.add(new RecordVidMdl("nJ31sMmytHU","R.drawable.bxhbaihat","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","30/04/2017 22:30:15","2.5","100","100","04:15"));
                mAudio.add(new RecordVidMdl("nJ31sMmytHU","R.drawable.bxhbaihat","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","Thời gian: 30/04/2017 22:30:15","2.5","100","100","04:15"));
                mAudio.add(new RecordVidMdl("nJ31sMmytHU","R.drawable.bxhbaihat","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","Thời gian: 30/04/2017 22:30:15","2.5","100","100","04:15"));
                mAudio.add(new RecordVidMdl("nJ31sMmytHU","R.drawable.bxhbaihat","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","Thời gian: 30/04/2017 22:30:15","2.5","100","100","04:15"));
                mAudio.add(new RecordVidMdl("nJ31sMmytHU","R.drawable.bxhbaihat","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","Thời gian: 30/04/2017 22:30:15","2.5","100","100","04:15"));
                mAudio.add(new RecordVidMdl("nJ31sMmytHU","R.drawable.bxhbaihat","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","Thời gian: 30/04/2017 22:30:15","2.5","100","100","04:15"));
                mAudio.add(new RecordVidMdl("nJ31sMmytHU","R.drawable.bxhbaihat","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","Thời gian: 30/04/2017 22:30:15","2.5","100","100","04:15"));
                mAudio.add(new RecordVidMdl("nJ31sMmytHU","R.drawable.bxhbaihat","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","Thời gian: 30/04/2017 22:30:15","2.5","100","100","04:15"));
                mAudio.add(new RecordVidMdl("nJ31sMmytHU","R.drawable.bxhbaihat","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","Thời gian: 30/04/2017 22:30:15","2.5","100","100","04:15"));
                mAudio.add(new RecordVidMdl("nJ31sMmytHU","R.drawable.bxhbaihat","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","Thời gian: 30/04/2017 22:30:15","2.5","100","100","04:15"));

            }
        }

        public RecordListAudioFragment() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            activity.setTitle(Resource.getInstance(getContext()).getString(R.string.list_record_mp3));
            activity.setImageDrawer(R.drawable.ic_arrow_back_black_24dp);
            activity.setClickDrawer(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.callFragment(SearchFragment.newInstance());
                }
            });
            View v=inflater.inflate(R.layout.fragment_record_audio, container, false);
            recyclerView = (RecyclerView) v.findViewById(R.id.rv_RecordAudio);
            mAudioAdapter = new RecordAudioAdapter(mAudio);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAudioAdapter);
            recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
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

            mAudioAdapter.setOnItemClickListener(new RecordAudioAdapter.OnItemClickListener() {
                @Override
                public void OnItemClick(View itemView, int position) {
                    RecordVidMdl mdl = mAudio.get(position);
                    activity.callFragment(RecordAudioInfoFragment.newInstance(mdl.getIdVideoRecord(), mdl.getmTittle()));
                }
            });
            return v;
        }

    }
