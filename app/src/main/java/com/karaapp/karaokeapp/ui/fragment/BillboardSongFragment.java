package com.karaapp.karaokeapp.ui.fragment;


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

import com.karaapp.karaokeapp.mdl.BillboardSong;
import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.ui.activity.MainActivity;
import com.karaapp.karaokeapp.ui.adapter.BillboardSongAdapter;

import java.util.ArrayList;
import java.util.List;


public class BillboardSongFragment extends BackFragment {
    private MainActivity activity;
    private List<BillboardSong> songTopMdls = new ArrayList<>();
    private RecyclerView.LayoutManager linearLayoutManager;
    private RecyclerView mRecyclerViewSong;

    public static final BillboardSongFragment newInstance() {
        BillboardSongFragment f = new BillboardSongFragment();
        Bundle bdl = new Bundle();
        f.setArguments(bdl);
        return f;
    }

    public BillboardSongFragment() {
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
        if (songTopMdls.size() == 0) {
            songTopMdls.add(new BillboardSong("P3OhQDl4L70","Tên facebook", "Nội dung chia sẻ \uD83D\uDE18", R.drawable.bxhbaihat, "ĐÊM NGÀY XA EM -KARAOKE NHẠC TRẺ - HÁT KARAOKE ONLINE", "500k", "500k", "500k", "500k", "2 phút trước"));
            songTopMdls.add(new BillboardSong("P3OhQDl4L70","Tên facebook", "Nội dung chia sẻ \uD83D\uDE18", R.drawable.bxhbaihat, "ĐÊM NGÀY XA EM -KARAOKE NHẠC TRẺ - HÁT KARAOKE ONLINE", "500k", "500k", "500k", "500k", "2 phút trước"));
            songTopMdls.add(new BillboardSong("P3OhQDl4L70","Tên facebook", "Nội dung chia sẻ \uD83D\uDE18", R.drawable.bxhbaihat, "ĐÊM NGÀY XA EM -KARAOKE NHẠC TRẺ - HÁT KARAOKE ONLINE", "500k", "500k", "500k", "500k", "2 phút trước"));
            songTopMdls.add(new BillboardSong("P3OhQDl4L70","Tên facebook", "Nội dung chia sẻ \uD83D\uDE18", R.drawable.bxhbaihat, "ĐÊM NGÀY XA EM -KARAOKE NHẠC TRẺ - HÁT KARAOKE ONLINE", "500k", "500k", "500k", "500k", "2 phút trước"));
            songTopMdls.add(new BillboardSong("P3OhQDl4L70","Tên facebook", "Nội dung chia sẻ \uD83D\uDE18", R.drawable.bxhbaihat, "ĐÊM NGÀY XA EM -KARAOKE NHẠC TRẺ - HÁT KARAOKE ONLINE", "500k", "500k", "500k", "500k", "2 phút trước"));
            songTopMdls.add(new BillboardSong("P3OhQDl4L70","Tên facebook", "Nội dung chia sẻ \uD83D\uDE18", R.drawable.bxhbaihat, "ĐÊM NGÀY XA EM -KARAOKE NHẠC TRẺ - HÁT KARAOKE ONLINE", "500k", "500k", "500k", "500k", "2 phút trước"));
            songTopMdls.add(new BillboardSong("P3OhQDl4L70","Tên facebook", "Nội dung chia sẻ \uD83D\uDE18", R.drawable.bxhbaihat, "ĐÊM NGÀY XA EM -KARAOKE NHẠC TRẺ - HÁT KARAOKE ONLINE", "500k", "500k", "500k", "500k", "2 phút trước"));
            songTopMdls.add(new BillboardSong("P3OhQDl4L70","Tên facebook", "Nội dung chia sẻ \uD83D\uDE18", R.drawable.bxhbaihat, "ĐÊM NGÀY XA EM -KARAOKE NHẠC TRẺ - HÁT KARAOKE ONLINE", "500k", "500k", "500k", "500k", "2 phút trước"));
            songTopMdls.add(new BillboardSong("P3OhQDl4L70","Tên facebook", "Nội dung chia sẻ \uD83D\uDE18", R.drawable.bxhbaihat, "ĐÊM NGÀY XA EM -KARAOKE NHẠC TRẺ - HÁT KARAOKE ONLINE", "500k", "500k", "500k", "500k", "2 phút trước"));
            songTopMdls.add(new BillboardSong("P3OhQDl4L70","Tên facebook", "Nội dung chia sẻ \uD83D\uDE18", R.drawable.bxhbaihat, "ĐÊM NGÀY XA EM -KARAOKE NHẠC TRẺ - HÁT KARAOKE ONLINE", "500k", "500k", "500k", "500k", "2 phút trước"));

        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_billboard_song, container, false);

        activity.setImageDrawer(R.drawable.ic_arrow_back_black_24dp);
        activity.setClickDrawer(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.callFragment(SearchFragment.newInstance());
            }
        });
        mRecyclerViewSong = (RecyclerView) rootView.findViewById(R.id.lvSongTop);
        BillboardSongAdapter adapter = new BillboardSongAdapter(songTopMdls);
        linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerViewSong.setLayoutManager(linearLayoutManager);
        mRecyclerViewSong.setHasFixedSize(true);
        mRecyclerViewSong.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        mRecyclerViewSong.setItemAnimator(new DefaultItemAnimator());
        mRecyclerViewSong.setAdapter(adapter);
        adapter.setOnItemClickListener(new BillboardSongAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                BillboardSong mBillboardVideo = songTopMdls.get(position);
                RecordVideoFragment fragment = RecordVideoFragment.newInstance(mBillboardVideo.getID(),mBillboardVideo.getTittle());
                getFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
            }
        });
        return rootView;
    }

}
