package com.karaapp.karaokeapp.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.karaapp.karaokeapp.mdl.NavMenuMdl;
import com.karaapp.karaokeapp.mdl.NavTittleHeader;
import com.karaapp.karaokeapp.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by laptop88 on 4/18/2017.
 */

public class NavMenuAdapter extends BaseExpandableListAdapter {
    private Context _context;
    List<NavTittleHeader> _listDataHeader;
    HashMap<NavTittleHeader, List<NavMenuMdl>> _listDataChild;

    public NavMenuAdapter(Context _context, List<NavTittleHeader> _listDataHeader, HashMap<NavTittleHeader, List<NavMenuMdl>> _listDataChild) {
        this._context = _context;
        this._listDataHeader = _listDataHeader;
        this._listDataChild = _listDataChild;
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        NavTittleHeader headerTitle = (NavTittleHeader) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.nav_menu_adapter, null);
        }

        TextView lblListHeader = (TextView) convertView.findViewById(R.id.textTittle);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle.getTextHeader());
        lblListHeader.setBackgroundColor(Color.parseColor("#CDCDC1"));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final NavMenuMdl childText = (NavMenuMdl) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_nav_item, null);
        }
        TextView txtListChild = (TextView) convertView.findViewById(R.id.text);
        ImageView icListChild = (ImageView) convertView.findViewById(R.id.drawable_icon);

        txtListChild.setText(childText.getText());
        txtListChild.setTextColor(Color.parseColor("#4527A0"));
        icListChild.setImageResource(childText.getDrawableResource());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
