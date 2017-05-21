package com.karaapp.karaokeapp.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.data.Resource;
import com.karaapp.karaokeapp.ui.Mdl.ITrangCaNhan;
import com.karaapp.karaokeapp.ui.Mdl.TrangCaNhan;
import com.karaapp.karaokeapp.ui.activity.MainActivity;
import com.karaapp.karaokeapp.ui.adapter.TrangcanhanAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrangCaNhanFaceFragment extends BackFragment {

    private TrangcanhanAdapter trangcanhanAdapter;
    private MainActivity activity;
    private List<ITrangCaNhan> trangCaNhanList = new ArrayList<>();

    public static final TrangCaNhanFaceFragment newInstance(){
        TrangCaNhanFaceFragment f = new TrangCaNhanFaceFragment();
        Bundle bdl = new Bundle();
        f.setArguments(bdl);
        return f;
    }

    public TrangCaNhanFaceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();

        if(trangCaNhanList.size() == 0){
            trangCaNhanList.add(new TrangCaNhan("Mp3", 200, 200, 200, 200));
            trangCaNhanList.add(new TrangCaNhan("Video", 200, 200, 200, 200));
            trangCaNhanList.add(new TrangCaNhan("Mp3", 200, 200, 200, 200));
            trangCaNhanList.add(new TrangCaNhan("Video", 200, 200, 200, 200));
            trangCaNhanList.add(new TrangCaNhan("Mp3", 200, 200, 200, 200));
            trangCaNhanList.add(new TrangCaNhan("Video", 200, 200, 200, 200));
            trangCaNhanList.add(new TrangCaNhan("Mp3", 200, 200, 200, 200));
            trangCaNhanList.add(new TrangCaNhan("Video", 200, 200, 200, 200));
            trangCaNhanList.add(new TrangCaNhan("Mp3", 200, 200, 200, 200));
            trangCaNhanList.add(new TrangCaNhan("Video", 200, 200, 200, 200));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_trang_ca_nhan_face, container, false);

        activity.setTitle(Resource.getInstance(activity).getString(R.string.trang_ca_nhan));
        ListView listView = (ListView) v.findViewById(R.id.lv_thong_ke);
        TrangcanhanAdapter adapter = new TrangcanhanAdapter(activity, trangCaNhanList);
        listView.setAdapter(adapter);

        return v;
    }

}
