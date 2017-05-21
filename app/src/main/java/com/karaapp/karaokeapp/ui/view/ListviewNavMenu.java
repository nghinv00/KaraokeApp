package com.karaapp.karaokeapp.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;

import com.karaapp.karaokeapp.ui.activity.MainActivity;
import com.karaapp.karaokeapp.ui.fragment.DsYeuThichFragment;
import com.karaapp.karaokeapp.ui.fragment.GameAndAppFragment;
import com.karaapp.karaokeapp.mdl.NavMenuMdl;
import com.karaapp.karaokeapp.mdl.NavTittleHeader;
import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.ui.fragment.BillboardSongFragment;
import com.karaapp.karaokeapp.ui.adapter.NavMenuAdapter;
import com.karaapp.karaokeapp.data.Resource;
import com.karaapp.karaokeapp.ui.fragment.BxhDanhCaFragment;
import com.karaapp.karaokeapp.ui.fragment.CaiDatFragment;
import com.karaapp.karaokeapp.ui.fragment.QuetionOneLevelFragment;
import com.karaapp.karaokeapp.ui.fragment.RecordListAudioFragment;
import com.karaapp.karaokeapp.ui.fragment.RecordListVideoFragment;
import com.karaapp.karaokeapp.ui.fragment.RecordVideoFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.media.CamcorderProfile.get;

/**
 * Created by Nganq on 4/18/2017.
 */

public class ListviewNavMenu extends ExpandableListView {

    private MainActivity activity;
    List<NavTittleHeader> listDataHeader;
    HashMap<NavTittleHeader, List<NavMenuMdl>> listDataChild;

    public ListviewNavMenu(Context context) {
        super(context);
        this.activity = (MainActivity) context;
        init();
    }

    public ListviewNavMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.activity = (MainActivity) context;
        init();

    }

    public ListviewNavMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.activity = (MainActivity) context;
        init();

    }

    private void init() {
        listDataChild = new HashMap<NavTittleHeader, List<NavMenuMdl>>();

        listDataHeader = new ArrayList<>();
        listDataHeader.add(new NavTittleHeader(Resource.getInstance(activity).getString(R.string.person)));
        listDataHeader.add(new NavTittleHeader(Resource.getInstance(activity).getString(R.string.community)));
        listDataHeader.add(new NavTittleHeader(Resource.getInstance(activity).getString(R.string.app)));

        List<NavMenuMdl> listNavMenuPerson = new ArrayList();
        listNavMenuPerson.add(new NavMenuMdl(R.drawable.ic_menu_camera, Resource.getInstance(activity).getString(R.string.list_record_mp3)));
        listNavMenuPerson.add(new NavMenuMdl(R.drawable.ic_menu_camera, Resource.getInstance(activity).getString(R.string.list_record_vid)));
        listNavMenuPerson.add(new NavMenuMdl(R.drawable.ic_menu_camera, Resource.getInstance(activity).getString(R.string.list_like)));
        listNavMenuPerson.add(new NavMenuMdl(R.drawable.ic_settings_black_24dp, Resource.getInstance(activity).getString(R.string.action_settings)));

        List<NavMenuMdl> listNavMenuCommunity = new ArrayList();
        listNavMenuCommunity.add(new NavMenuMdl(R.drawable.ic_menu_bxhbaihat, Resource.getInstance(activity).getString(R.string.billboard_record)));
        listNavMenuCommunity.add(new NavMenuMdl(R.drawable.ic_mic_none_black_24dp, Resource.getInstance(activity).getString(R.string.billboard_singer)));
        listNavMenuCommunity.add(new NavMenuMdl(R.drawable.ic_people_outline_black_24dp, Resource.getInstance(activity).getString(R.string.community_fb)));

        List<NavMenuMdl> listNavMenuApp = new ArrayList();
        listNavMenuApp.add(new NavMenuMdl(R.drawable.ic_info_outline_black_24dp, Resource.getInstance(activity).getString(R.string.intro_app)));
        listNavMenuApp.add(new NavMenuMdl(R.drawable.ic_help_outline_black_24dp, Resource.getInstance(activity).getString(R.string.question)));

        listNavMenuApp.add(new NavMenuMdl(R.drawable.ic_menu_camera, Resource.getInstance(activity).getString(R.string.game_app)));
        listNavMenuApp.add(new NavMenuMdl(R.drawable.ic_menu_camera, Resource.getInstance(activity).getString(R.string.rule_call)));

        listDataChild.put(listDataHeader.get(0), listNavMenuPerson);
        listDataChild.put(listDataHeader.get(1), listNavMenuCommunity);
        listDataChild.put(listDataHeader.get(2), listNavMenuApp);
        NavMenuAdapter adapter = new NavMenuAdapter(activity, listDataHeader, listDataChild);
        setAdapter(adapter);
        for (int i = 0; i < adapter.getGroupCount(); i++) {
            expandGroup(i);
        }

        setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                if (groupPosition == 0) {
                    if (childPosition == 0) {
                        activity.callFragment(RecordListAudioFragment.newInstance());
                        activity.setTitle(Resource.getInstance(activity).getString(R.string.list_record_mp3));
                    }
                    if (childPosition == 1) {
                        activity.callFragment(RecordListVideoFragment.newInstance());
                        activity.setTitle(Resource.getInstance(activity).getString(R.string.list_record_vid));
                    }
                    if (childPosition == 2) {
                        activity.callFragment(DsYeuThichFragment.newInstance());
                        activity.setTitle(Resource.getInstance(activity).getString(R.string.list_like));
                    }
                    if (childPosition == 3) {
                        activity.callFragment(CaiDatFragment.newInstance());
                        activity.setTitle(Resource.getInstance(activity).getString(R.string.action_settings));
                    }
                }
                if (groupPosition == 1) {
                    if (childPosition == 0) {
                        activity.callFragment(BillboardSongFragment.newInstance());
                        activity.setTitle(Resource.getInstance(activity).getString(R.string.title_billboard_song));
                    }
                    if (childPosition == 1) {
                        activity.callFragment(BxhDanhCaFragment.newInstance());
                        activity.setTitle(Resource.getInstance(activity).getString(R.string.billboard_singer));
                    }
                    if (childPosition == 2) {

                    }
                }
                if (groupPosition == 2) {
                    if (childPosition == 0) {

                    }
                    if (childPosition == 1) {
                        activity.callFragment(QuetionOneLevelFragment.newInstance());
                        activity.setTitle(Resource.getInstance(activity).getString(R.string.question));
                    }
                    if (childPosition == 2) {
                        activity.callFragment(GameAndAppFragment.newInstance());
                        activity.setTitle(Resource.getInstance(activity).getString(R.string.game_app));
                    }
                    if (childPosition == 3) {

                    }
                }
                activity.drawerAction(null);
                return false;
            }

        });
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

}
