package com.karaapp.karaokeapp.ui.fragment;

import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.api.services.youtube.model.Video;
import com.google.gson.Gson;
import com.karaapp.karaokeapp.entity.callback.QueryCallback;
import com.karaapp.karaokeapp.entity.callback.QueryDuratioCallback;
import com.karaapp.karaokeapp.entity.durations.DurationsResponse;
import com.karaapp.karaokeapp.entity.id.ObjectResponse;
import com.karaapp.karaokeapp.mdl.VideoMdl;
import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.data.Config;
import com.karaapp.karaokeapp.ui.activity.MainActivity;
import com.karaapp.karaokeapp.ui.adapter.VideoAdapter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class SearchFragment extends BackFragment {
    private VideoAdapter mVideoAdapter;
    private static List<VideoMdl> mVideos = new ArrayList<>();
    private List<String> mVideos3 = new ArrayList<>();
    private List<Video> mVideos2 = new ArrayList<>();
    private RecyclerView mRecyclerViewVideo;
    private RecyclerView.LayoutManager linearLayoutManager;
    private String urlId, urlVideos, duration;
    private AsyncHttpClient client, client1;
    private RequestParams params, paramDuration;
    private SearchView searchView;
    private MainActivity activity;
    private View view;
    ProgressDialog dialog;
    RequestQueue requestQueue;
    ObjectResponse objectResponses;
    DurationsResponse durationsResponse;
    static List<String> durationList = new ArrayList<>();

    private static final int NUMBER_RESULT = 2;
    private StringBuilder builderVideoId = new StringBuilder();

    public SearchFragment() {
    }

    public static final SearchFragment newInstance() {
        SearchFragment f = new SearchFragment();
        Bundle bdl = new Bundle();
        f.setArguments(bdl);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
        dialog = new ProgressDialog(activity);
        dialog.setTitle("Thông báo");
        dialog.setTitle("Loading...");
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        requestQueue = Volley.newRequestQueue(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity.setImageDrawer(R.drawable.ic_view_headline_black_24dp);
        activity.setTitle("KaraOke Online");
        activity.setClickDrawer(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.drawerAction(null);
            }
        });
        if (activity.isOnline()) {
            view = inflater.inflate(R.layout.fragment_search, container, false);
            client = new AsyncHttpClient();
            params = new RequestParams();
            paramDuration = new RequestParams();
            client1 = new SyncHttpClient();
            searchView = (SearchView) getActivity().findViewById(R.id.layout_Seach);
            mRecyclerViewVideo = (RecyclerView) view.findViewById(R.id.rv_video);
            mVideoAdapter = new VideoAdapter(mVideos);
            int orientation = this.getResources().getConfiguration().orientation;
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                linearLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 2, GridLayoutManager.VERTICAL, false);
            } else
                linearLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 1, GridLayoutManager.VERTICAL, false);

            mRecyclerViewVideo.setLayoutManager(linearLayoutManager);
            mRecyclerViewVideo.setAdapter(mVideoAdapter);

            // final String querynhactre = query("karaoke lyrics:nhạc trẻ");
            query("karaoke lyrics:nhạc trẻ", new QueryCallback() {
                @Override
                public void callback(List<String> listId) {
                    for (String id : listId) {
                        if (builderVideoId.length() < 1) {
                            builderVideoId.append(id + "");
                        } else {
                            builderVideoId.append("," + id);
                        }
                    }
                    AsyncTaskDuration duration = new AsyncTaskDuration(new QueryDuratioCallback() {
                        @Override
                        public void callback(List<String> durations) {
                            // đến đây đã lấy được list duration
                            mVideos.add(new VideoMdl("1", "1", "1", "1"));
                        }
                    });
                    duration.execute(builderVideoId.toString());

                }
            });


            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String stringQuery) {
                    if (stringQuery.toString().length() <= 0)
                        searchView.onActionViewCollapsed();
                    if (stringQuery.toString().length() > 0) {
                        mVideos.clear();
//                        query("karaoke lyrics:" + stringQuery.toString(), new QueryCallback() {

                        activity.mTittle.setVisibility(View.VISIBLE);
                        searchView.onActionViewCollapsed();
                    }
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
            mVideoAdapter.setOnItemClickListener(new VideoAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View itemView, int position) {
                    VideoMdl mVideo = mVideos.get(position);
                    RecordVideoFragment fragment = RecordVideoFragment.newInstance(mVideo.getVideoId(), mVideo.getTitle());
                    getFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
                }
            });
        } else view = inflater.inflate(R.layout.empty_search_list, container, false);
        return view;
    }


    private void query(final String query, final QueryCallback callback) {
        
        params.put("part", "snippet");
        params.put("type", "video");
        params.put("order", "viewCount");
        params.put("key", Config.SEARCH_API_KEY);
        params.put("maxResults", NUMBER_RESULT);
        params.put("q", query);
        urlId = "https://www.googleapis.com/youtube/v3/search";

        client.get(urlId, params, new TextHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    JSONObject data = new JSONObject(responseString);
                    JSONArray array = data.getJSONArray("items");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject obj = array.getJSONObject(i);
                        JSONObject id = obj.getJSONObject("id");
                        String videoId = id.getString("videoId");
                        JSONObject snippet = obj.getJSONObject("snippet");
                        String title = snippet.getString("title");
                        JSONObject thumbnails = snippet.getJSONObject("thumbnails");
                        JSONObject default1 = thumbnails.getJSONObject("default");
                        String url = default1.getString("url");
                        mVideos3.add(videoId);  // Lấy id để phục vụ lần search lần thứ 2 -> duration
                        VideoMdl video = new VideoMdl(videoId, title, url, duration);
                        mVideos.add(video);
                        mVideoAdapter.notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                callback.callback(mVideos3);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(getActivity(), "Not found video you want", Toast.LENGTH_LONG);
            }
        });
    }

    public void queryDuration(String query, final QueryDuratioCallback duratioCallback) {
        paramDuration.put("id", query);
        paramDuration.put("part", "snippet,contentDetails,statistics");
        paramDuration.put("key", Config.SEARCH_API_KEY);

        urlVideos = "https://www.googleapis.com/youtube/v3/videos";

        client1.get(urlVideos, paramDuration, new TextHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    JSONObject object = new JSONObject(responseString);
                    JSONArray Item = object.getJSONArray("items");
                    for (int i = 0; i < Item.length(); i++){
                        JSONObject item = Item.getJSONObject(i);
                        JSONObject contentDetails = item.getJSONObject("contentDetails");
                        String duration = contentDetails.getString("duration");
                        durationList.add(duration);
                    }
                    duratioCallback.callback(durationList);


                } catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }
        });
    }

    public class AsyncTaskDuration extends AsyncTask<String, Void, String> {

        QueryDuratioCallback callback;

        public AsyncTaskDuration(QueryDuratioCallback callback) {
            this.callback = callback;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            callback.callback(durationList);

        }

        @Override
        protected String doInBackground(String... params) {
            queryDuration( params[0], new QueryDuratioCallback() {
                @Override
                public void callback(List<String> durations) {
                    durationList = durations;
                }
            });
            return null;
        }
    }

    private void showDialog() {
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }
    private void hideDialog() {
        if (!dialog.isShowing()) {
            dialog.hide();
        }
    }

}
