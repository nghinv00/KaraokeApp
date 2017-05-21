package com.karaapp.karaokeapp.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.data.Resource;
import com.karaapp.karaokeapp.ui.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CaiDatFragment extends BackFragment {

    public static final CaiDatFragment newInstance() {
        CaiDatFragment f = new CaiDatFragment();
        Bundle bdl = new Bundle();
        f.setArguments(bdl);
        return f;
    }

    public CaiDatFragment() {
        // Required empty public constructor
    }

    private MainActivity activity;
    private BackFragment.BackPressLister backPressLister;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cai_dat, container, false);

        activity.setImageDrawer(R.drawable.ic_arrow_back_black_24dp);
        activity.setClickDrawer(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.callFragment(SearchFragment.newInstance());

            }
        });

        TextView tatQuangCao = (TextView) v.findViewById(R.id.tatquangcao);

        tatQuangCao.setText(Html.fromHtml(Resource.getInstance(getActivity()).getString(R.string.quang_cao)
                + "<font color=\"#0033ff\"> "
                + Resource.getInstance(getActivity()).getString(R.string.phi) + " </font>"));
        return v;
    }

}
