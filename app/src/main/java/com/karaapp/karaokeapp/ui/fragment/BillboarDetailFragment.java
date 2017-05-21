package com.karaapp.karaokeapp.ui.fragment;


import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.ui.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class BillboarDetailFragment extends BackFragment {


    public BillboarDetailFragment() {
        // Required empty public constructor
    }

    private TextView viewCount;
    private TextView viewComment;
    private TextView viewShare;
    private TextView viewLike;
    private static String TAG = BillboarDetailFragment.class.getSimpleName();
    private WebView mWebViewComments;
    boolean isLoading;
    private WebView mWebviewPop;
    private String postUrl,mVideoIdYoutube;
    private RelativeLayout mContainer;
    private MainActivity activity;
    private static final String KEY_VIDEO_ID = "KEY_VIDEO_ID";
    private static final String URL_SHARE = "KEY_VIDEO_ID";

    private static final int NUMBER_OF_COMMENTS = 5;

    public static final BillboarDetailFragment newInstance(String ID ,String url) {
        BillboarDetailFragment f = new BillboarDetailFragment();
        Bundle bdl = new Bundle();
        bdl.putString(KEY_VIDEO_ID, ID);
        bdl.putString(URL_SHARE, url);

        f.setArguments(bdl);
        return f;

    }
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
        activity.setImageDrawer(R.drawable.ic_arrow_back_black_24dp);
        activity.setClickDrawer(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.callFragment(SearchFragment.newInstance());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final Bundle arguments = getArguments();
        if (savedInstanceState != null && savedInstanceState.containsKey(KEY_VIDEO_ID)) {
            postUrl = savedInstanceState.getString(KEY_VIDEO_ID);
            mVideoIdYoutube = arguments.getString(KEY_VIDEO_ID);

        } else if (arguments != null && arguments.containsKey(KEY_VIDEO_ID)) {
            postUrl = arguments.getString(KEY_VIDEO_ID);
            mVideoIdYoutube = arguments.getString(URL_SHARE);

        }
        View view = inflater.inflate(R.layout.fragment_billboar_detail, container, false);

        viewCount = (TextView) view.findViewById(R.id.viewCount);
        viewComment = (TextView) view.findViewById(R.id.viewComment);
        viewShare = (TextView) view.findViewById(R.id.viewShare);
        viewLike = (TextView) view.findViewById(R.id.viewLike);
        mContainer = (RelativeLayout) view.findViewById(R.id.webview_frame);
        mWebViewComments = (WebView) view.findViewById(R.id.commentsView);
        postUrl = "https://www.facebook.com/lienloi33/posts/1672816796358135?pnref=story";

        if (TextUtils.isEmpty(postUrl)) {
            Toast.makeText(getActivity(), "The web url shouldn't be empty", Toast.LENGTH_LONG).show();
        }
        YouTubeFragment youtubefragment = YouTubeFragment.newInstance(mVideoIdYoutube);
        getFragmentManager().beginTransaction().replace(R.id.fragment, youtubefragment).commit();

        viewCount.setText("500");
        viewComment.setText("500");
        viewShare.setText("500");
        viewLike.setText("500");
        setLoading(true);
        loadComments();

        return view;
    }

    private void loadComments() {
        mWebViewComments.setWebViewClient(new BillboarDetailFragment.UriWebViewClient());
        mWebViewComments.setWebChromeClient(new BillboarDetailFragment.UriChromeClient());
        mWebViewComments.getSettings().setJavaScriptEnabled(true);
        mWebViewComments.getSettings().setAppCacheEnabled(true);
        mWebViewComments.getSettings().setDomStorageEnabled(true);
        mWebViewComments.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebViewComments.getSettings().setSupportMultipleWindows(true);
        mWebViewComments.getSettings().setSupportZoom(false);
        mWebViewComments.getSettings().setBuiltInZoomControls(false);
        CookieManager.getInstance().setAcceptCookie(true);
        if (Build.VERSION.SDK_INT >= 21) {
            mWebViewComments.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
            CookieManager.getInstance().setAcceptThirdPartyCookies(mWebViewComments, true);
        }

        // facebook comment widget including the article url
        String html = "<!doctype html> <html lang=\"en\"> <head></head> <body> " +
                "<div id=\"fb-root\"></div> <script>(function(d, s, id) { var js, fjs = d.getElementsByTagName(s)[0]; if (d.getElementById(id)) return; js = d.createElement(s); js.id = id; js.src = \"//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.6\"; fjs.parentNode.insertBefore(js, fjs); }(document, 'script', 'facebook-jssdk'));</script> " +
                "<div class=\"fb-comments\" data-href=\"" + postUrl + "\" " +
                "data-numposts=\"" + NUMBER_OF_COMMENTS + "\" data-order-by=\"reverse_time\">" +
                "</div> </body> </html>";

        mWebViewComments.loadDataWithBaseURL("http://www.nothing.com", html, "text/html", "UTF-8", null);
        mWebViewComments.setMinimumHeight(200);
    }

    private void setLoading(boolean isLoading) {
        this.isLoading = isLoading;
    }

    private class UriWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            String host = Uri.parse(url).getHost();

            return !host.equals("m.facebook.com");

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            String host = Uri.parse(url).getHost();
            setLoading(false);
            if (url.contains("/plugins/close_popup.php?reload")) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Do something after 100ms
                        mContainer.removeView(mWebviewPop);
                        loadComments();
                    }
                }, 600);
            }
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler,
                                       SslError error) {
            setLoading(false);
        }
    }

    class UriChromeClient extends WebChromeClient {

        @Override
        public boolean onCreateWindow(WebView view, boolean isDialog,
                                      boolean isUserGesture, Message resultMsg) {
            mWebviewPop = new WebView(getActivity());
            mWebviewPop.setVerticalScrollBarEnabled(false);
            mWebviewPop.setHorizontalScrollBarEnabled(false);
            mWebviewPop.setWebViewClient(new BillboarDetailFragment.UriWebViewClient());
            mWebviewPop.setWebChromeClient(this);
            mWebviewPop.getSettings().setJavaScriptEnabled(true);
            mWebviewPop.getSettings().setDomStorageEnabled(true);
            mWebviewPop.getSettings().setSupportZoom(false);
            mWebviewPop.getSettings().setBuiltInZoomControls(false);
            mWebviewPop.getSettings().setSupportMultipleWindows(true);
            mWebviewPop.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            mContainer.addView(mWebviewPop);
            WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
            transport.setWebView(mWebviewPop);
            resultMsg.sendToTarget();

            return true;
        }

        @Override
        public boolean onConsoleMessage(ConsoleMessage cm) {
            Log.i(TAG, "onConsoleMessage: " + cm.message());
            return true;
        }

        @Override
        public void onCloseWindow(WebView window) {
        }
    }


}
