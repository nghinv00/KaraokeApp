package com.karaapp.karaokeapp.ui.adapter;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.data.Resource;
import com.karaapp.karaokeapp.mdl.RecordVidMdl;
import com.karaapp.karaokeapp.ui.activity.MainActivity;
import com.karaapp.karaokeapp.ui.fragment.RecordAudioInfoFragment;

import java.util.List;

/**
 * Created package com.karaapp.karaokeapp.ui.adapter on 15/05/2017.
 * Author by NghiNV
 */

public class RecordAudioAdapter extends RecyclerView.Adapter<RecordAudioAdapter.RecordViewHolder> {


    private List<RecordVidMdl> listAudioRecord;
    private MainActivity activity;
    public static OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public RecordAudioAdapter(List<RecordVidMdl> listAudioRecord) {
        this.listAudioRecord = listAudioRecord;
    }

    @Override
    public RecordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_item_record_vid, parent, false);
        activity = (MainActivity) parent.getContext();
        return new RecordAudioAdapter.RecordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecordViewHolder holder, int position) {
        final RecordVidMdl recordVidMdl = listAudioRecord.get(position);
        holder.mTittle.setText(recordVidMdl.getmTittle());
        holder.mTime.setText(recordVidMdl.getmTime());
        holder.mSize.setText(recordVidMdl.getmSize());
        holder.mPoint.setText(recordVidMdl.getmPoint());
        holder.mLike.setText(recordVidMdl.getmLike());
        holder.mDurations.setText(recordVidMdl.getmDurations());
        Glide.with(holder.uriImage.getContext()).load(recordVidMdl.getUriImage())
                .placeholder(R.drawable.bxhbaihat).into(holder.uriImage);
        holder.btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v, recordVidMdl.getIdVideoRecord(), recordVidMdl.getmTittle());
            }
        });
    }

    private void showPopup(final View view, final String audioId, final String audioName) {
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_menu_record, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.open:
                        activity.callFragment(RecordAudioInfoFragment.newInstance(audioId, audioName));
                        activity.setTitle(Resource.getInstance(activity).getString(R.string.list_record_mp3));
                        return true;
                    case R.id.edit:
                        return true;
                    case R.id.share:
                        return true;
                    case R.id.delete:
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
        MenuPopupHelper menuHelper = new MenuPopupHelper(view.getContext(),
                (MenuBuilder) popupMenu.getMenu(), view);
        menuHelper.setForceShowIcon(true);
        menuHelper.show();
    }

    @Override
    public int getItemCount() {
        return listAudioRecord.size();
    }

    public class RecordViewHolder extends RecyclerView.ViewHolder {

        public ImageView uriImage;
        public TextView mTittle, mTime, mSize, mPoint, mLike, mDurations;
        Button btnPopup;

        public RecordViewHolder(View itemView) {
            super(itemView);
            btnPopup = (Button) itemView.findViewById(R.id.btnPopup);
            uriImage = (ImageView) itemView.findViewById(R.id.imageVideo);
            mTittle = (TextView) itemView.findViewById(R.id.titleVid);
            mTime = (TextView) itemView.findViewById(R.id.txtTime);
            mSize = (TextView) itemView.findViewById(R.id.size);
            mPoint = (TextView) itemView.findViewById(R.id.point);
            mLike = (TextView) itemView.findViewById(R.id.countLike);
            mDurations = (TextView) itemView.findViewById(R.id.txtdurations);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.OnItemClick(v, getAdapterPosition());
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void OnItemClick(View itemView, int position);
    }
}
