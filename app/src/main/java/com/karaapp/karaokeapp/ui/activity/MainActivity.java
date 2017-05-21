package com.karaapp.karaokeapp.ui.activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.SearchView;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.data.Resource;
import com.karaapp.karaokeapp.mdl.OnClick;
import com.karaapp.karaokeapp.ui.dialog.ShutdowKaraDialog;
import com.karaapp.karaokeapp.ui.fragment.BackFragment;
import com.karaapp.karaokeapp.ui.fragment.RecordVideoFragment;
import com.karaapp.karaokeapp.ui.fragment.SearchFragment;
import com.karaapp.karaokeapp.ui.fragment.TrangCaNhanFaceFragment;
import com.karaapp.karaokeapp.ui.view.BadgeCircle;
import com.karaapp.karaokeapp.ui.view.IvDrawerBadge;
import com.karaapp.karaokeapp.ui.view.ProfilePictureBadge;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private static BackFragment currentFragment;
    private CallbackManager callbackManager;
    private LoginButton btnLogin;
    private TextView tvNameFace;
    private ProfilePictureBadge profilePictureView;
    private SearchView searchView;
    private TextView title;
    public static IvDrawerBadge mIconDrawer;
    public TextView mTittle;
    public LinearLayout mActionRecord;
    private RecordVideoFragment recordVideoFragment;
    private NavigationView navigationView;
    private ImageButton invite;
    private ImageView imageViewMenu;
    private MainActivity activity;
    private BadgeCircle badgeCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        invite = (ImageButton) findViewById(R.id.tbMoiBanBe);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View hView = navigationView.getHeaderView(0);
        btnLogin = (LoginButton) findViewById(R.id.loginface);
        tvNameFace = (TextView) findViewById(R.id.id_user);
        title = (TextView) findViewById(R.id.title);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        profilePictureView = (ProfilePictureBadge) findViewById(R.id.avata);

        badgeCircle = (BadgeCircle) findViewById(R.id.badge_circle);
        badgeCircle.setVisibility(View.GONE);
        imageViewMenu = (ImageView) findViewById(R.id.imageViewMenu);

        imageViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, imageViewMenu);

                popupMenu.getMenuInflater().inflate(R.menu.menumain, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        invite.setVisibility(View.GONE);
        profilePictureView.setNumberBadge(99);
        btnLogin.setReadPermissions(Arrays.asList("public_profile, email, user_birthday"));
        callbackManager = CallbackManager.Factory.create();
        // call registration
        btnLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                Log.v("Main", response.toString());
                                setProfileToView(object);
                            }
                        });
                Bundle paramaters = new Bundle();
                paramaters.putString("fields", "id,name");
                request.setParameters(paramaters);
                request.executeAsync();

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(MainActivity.this, "error to Login Facebook", Toast.LENGTH_SHORT).show();
            }
        });
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        searchView = (SearchView) findViewById(R.id.layout_Seach);
        mIconDrawer = (IvDrawerBadge) findViewById(R.id.iv_drawer);
        mTittle = (TextView) findViewById(R.id.title);

        EditText searchEditText = (EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(Color.parseColor("#FFFFFF"));
        searchEditText.setHintTextColor(Color.parseColor("#FFFFFF"));
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mIconDrawer.setVisibility(View.GONE);
                mTittle.setVisibility(View.GONE);
                SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
                searchView.setFocusable(true);
                searchView.setFocusableInTouchMode(true);
                searchView.onActionViewExpanded();
                searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.setQuery("", false);
                searchView.clearFocus();
                searchView.setIconified(true);
                searchView.setSubmitButtonEnabled(true);
                mIconDrawer.setVisibility(View.VISIBLE);
                mTittle.setVisibility(View.VISIBLE);
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        int orientation=this.getResources().getConfiguration().orientation;
        if(orientation== Configuration.ORIENTATION_LANDSCAPE){
            mActionRecord=(LinearLayout)findViewById(R.id.layout_record);
            mActionRecord.setVisibility(View.GONE);
            mTittle.setVisibility(View.VISIBLE);
            if(mActionRecord.getVisibility()==View.VISIBLE)
            {
                TextView recordButton= (TextView) findViewById(R.id.record_actionbar);
                recordButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        recordVideoFragment.showPopupMenu(v);
                    }
                });
            }
        }

        callFragment(SearchFragment.newInstance());

        showHashKey(this);
    }


    public static void showHashKey(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    "com.karaapp.karaokeapp", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.i("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
        } catch (NoSuchAlgorithmException e) {
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void callFragment(Fragment fragment) {
        if (fragment instanceof BackFragment) {
            currentFragment = (BackFragment) fragment;
        } else {
            currentFragment = null;
        }
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick
    public void drawerAction(View v) {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (currentFragment != null) {
                currentFragment.onBack();
            } else {
                ShutdowKaraDialog shutdowKaraDialog = new ShutdowKaraDialog(MainActivity.this);
                shutdowKaraDialog.setTitle(Resource.getInstance(MainActivity.this).getString(R
                        .string.tat_ung_dung));
                shutdowKaraDialog.show();
            }
        }
    }

    private void setProfileToView(JSONObject jsonObject) {
        try {
            tvNameFace.setText(jsonObject.getString("name"));
            profilePictureView.setProfileId(jsonObject.getString("id"));
            invite.setVisibility(View.VISIBLE);
            btnLogin.setVisibility(View.GONE);

            // vào trang cá nhân face
            profilePictureView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callFragment(TrangCaNhanFaceFragment.newInstance());
                    drawerAction(null);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setTitle(String title) {
        mTittle.setText(title);
    }

    public void setClickDrawer(View.OnClickListener onClick) {
        mIconDrawer.setOnClickListener(onClick);
    }

    public void setImageDrawer(int drawer) {
        mIconDrawer.setImageDrawer(drawer);
    }
    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null &&
                cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
