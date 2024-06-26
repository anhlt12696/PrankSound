package com.prank.sound.hair.cut.ps.pranksound.Activity;


import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dungvnhh98.percas.studio.admoblib.admob.AdmobManager;
import com.facebook.ads.Ad;
import com.facebook.ads.AdSettings;
import com.google.android.gms.ads.AdValue;
import com.prank.sound.hair.cut.ps.pranksound.R;
import com.prank.sound.hair.cut.ps.pranksound.Room.QueryClass;
import com.prank.sound.hair.cut.ps.pranksound.fragment.CreateFragment;
import com.prank.sound.hair.cut.ps.pranksound.fragment.FavoritesFragment;
import com.prank.sound.hair.cut.ps.pranksound.fragment.HomeFragment;
import com.prank.sound.hair.cut.ps.pranksound.fragment.LeaderBoardFragment;
import com.prank.sound.hair.cut.ps.pranksound.fragment.SettingFragment;
import com.prank.sound.hair.cut.ps.pranksound.utils.AdsUtils;
import com.prank.sound.hair.cut.ps.pranksound.utils.BaseActivity;
import com.prank.sound.hair.cut.ps.pranksound.utils.Common;
import com.prank.sound.hair.cut.ps.pranksound.utils.Gdpr;
import com.prank.sound.hair.cut.ps.pranksound.utils.RemoteConfig;

import java.util.List;

public class MainActivity extends BaseActivity {
    CardView cvAirHorn, cvHairClipper, cvFant, cvBurp, cvToiletFlushing, cvGun, cvBreaking, cvCar, cvMeme;
    ImageView imgFav, imgGift, imgHome, imgCreate, imgFavorites, imgLeaderboard, imgSetting;
    RecyclerView rcv_cate;
    List<String> cate;
    FragmentManager fragmentManager;

    LinearLayout ll_home, ll_create, ll_favorites, ll_leaderboard, ll_setting;
    String navTab = "home";
    TextView tv_title, tv_home, tv_create, tv_favorites, tv_leaderboard, tv_setting;

    FrameLayout fl_banner;
    View view_line;


    QueryClass queryClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdSettings.setDebugBuild(Boolean.parseBoolean(getString(R.string.facebook_ads_debug)));

        findView();
        clickEvent();
        LoadAndShowAds();

        fragmentManager = getSupportFragmentManager();
        bottomNavigationClick();
        String get_record = getIntent().getStringExtra("from_record");

        if (get_record != null) {
            changeFragment("create");
        } else {
            changeFragment("home");
        }


    }

    private void changeFragment(String tab) {
        switch (tab) {
            case "home":
                fragmentManager.beginTransaction().replace(R.id.fragmentMain, new HomeFragment()).commit();
                tv_title.setText(R.string.home);

                imgHome.setBackgroundResource(R.drawable.ic_home_selected);
                tv_home.setTextColor(getResources().getColor(R.color.bottom_nav_text_color_selected));

                imgCreate.setBackgroundResource(R.drawable.ic_create);
                tv_create.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));

                imgFavorites.setBackgroundResource(R.drawable.ic_favorite);
                tv_favorites.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));

                imgLeaderboard.setBackgroundResource(R.drawable.ic_leader_board);
                tv_leaderboard.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));

                imgSetting.setBackgroundResource(R.drawable.ic_setting);
                tv_setting.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));


                break;

            case "create":
                fragmentManager.beginTransaction().replace(R.id.fragmentMain, new CreateFragment()).commit();
                tv_title.setText(R.string.create_sound);

                imgHome.setBackgroundResource(R.drawable.ic_home);
                tv_home.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));

                imgCreate.setBackgroundResource(R.drawable.ic_create_selected);
                tv_create.setTextColor(getResources().getColor(R.color.bottom_nav_text_color_selected));

                imgFavorites.setBackgroundResource(R.drawable.ic_favorite);
                tv_favorites.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));

                imgLeaderboard.setBackgroundResource(R.drawable.ic_leader_board);
                tv_leaderboard.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));

                imgSetting.setBackgroundResource(R.drawable.ic_setting);
                tv_setting.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));

                break;

            case "favorites":
                fragmentManager.beginTransaction().replace(R.id.fragmentMain, new FavoritesFragment()).commit();
                tv_title.setText(R.string.favorites);

                imgHome.setBackgroundResource(R.drawable.ic_home);
                tv_home.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));

                imgCreate.setBackgroundResource(R.drawable.ic_create);
                tv_create.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));

                imgFavorites.setBackgroundResource(R.drawable.ic_favorite_selected);
                tv_favorites.setTextColor(getResources().getColor(R.color.bottom_nav_text_color_selected));

                imgLeaderboard.setBackgroundResource(R.drawable.ic_leader_board);
                tv_leaderboard.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));

                imgSetting.setBackgroundResource(R.drawable.ic_setting);
                tv_setting.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));

                break;

            case "leaderboard":
                fragmentManager.beginTransaction().replace(R.id.fragmentMain, new LeaderBoardFragment()).commit();
                tv_title.setText(R.string.leaderboard);

                imgHome.setBackgroundResource(R.drawable.ic_home);
                tv_home.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));

                imgCreate.setBackgroundResource(R.drawable.ic_create);
                tv_create.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));

                imgFavorites.setBackgroundResource(R.drawable.ic_favorite);
                tv_favorites.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));

                imgLeaderboard.setBackgroundResource(R.drawable.ic_leader_board_selected);
                tv_leaderboard.setTextColor(getResources().getColor(R.color.bottom_nav_text_color_selected));

                imgSetting.setBackgroundResource(R.drawable.ic_setting);
                tv_setting.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));

                break;

            case "setting":
                fragmentManager.beginTransaction().replace(R.id.fragmentMain, new SettingFragment()).commit();
                tv_title.setText(R.string.setting);

                imgHome.setBackgroundResource(R.drawable.ic_home);
                tv_home.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));

                imgCreate.setBackgroundResource(R.drawable.ic_create);
                tv_create.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));

                imgFavorites.setBackgroundResource(R.drawable.ic_favorite);
                tv_favorites.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));

                imgLeaderboard.setBackgroundResource(R.drawable.ic_leader_board);
                tv_leaderboard.setTextColor(getResources().getColor(R.color.bottom_nav_text_color));

                imgSetting.setBackgroundResource(R.drawable.ic_setting_selected);
                tv_setting.setTextColor(getResources().getColor(R.color.bottom_nav_text_color_selected));

                break;

        }
    }

    private void bottomNavigationClick() {
        ll_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navTab = "home";
                changeFragment(navTab);
                Log.d("Change_fragment", "Home fragment");
            }
        });

        ll_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navTab = "create";
                changeFragment(navTab);
                Log.d("Change_fragment", "Create fragment");
            }
        });

        ll_favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navTab = "favorites";
                changeFragment(navTab);
                Log.d("Change_fragment", "Favorites fragment");
            }
        });

        ll_leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navTab = "leaderboard";
                changeFragment(navTab);
                Log.d("Change_fragment", "Leaderboard fragment");
            }
        });

        ll_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navTab = "setting";
                changeFragment(navTab);
                Log.d("Change_fragment", "Setting fragment");
            }
        });

    }

    private void findView() {

        imgFav = findViewById(R.id.imgFav);
        imgGift = findViewById(R.id.imgGift);

        rcv_cate = findViewById(R.id.rcv_cate);

        ll_home = findViewById(R.id.ll_home);
        ll_create = findViewById(R.id.ll_create);
        ll_favorites = findViewById(R.id.ll_favorites);
        ll_leaderboard = findViewById(R.id.ll_leaderboard);
        ll_setting = findViewById(R.id.ll_setting);

        tv_title = findViewById(R.id.tv_title);

        imgHome = findViewById(R.id.img_home);
        imgCreate = findViewById(R.id.img_create);
        imgFavorites = findViewById(R.id.img_favorites);
        imgLeaderboard = findViewById(R.id.img_leaderboard);
        imgSetting = findViewById(R.id.img_setting);

        tv_home = findViewById(R.id.tv_home);
        tv_create = findViewById(R.id.tv_create);
        tv_favorites = findViewById(R.id.tv_favorites);
        tv_leaderboard = findViewById(R.id.tv_leaderboard);
        tv_setting = findViewById(R.id.tv_setting);

        fl_banner = findViewById(R.id.ads_banner);
        view_line = findViewById(R.id.line);

        new Gdpr().make(this);


        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                showExitDialog();
            }
        });
    }
    private void clickEvent() {
        imgFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavoriteActivity.class);
                startActivity(intent);
            }
        });

        imgGift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(), "Coming Soon", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void showExitDialog() {
        Dialog dialogCustomExit = new Dialog(MainActivity.this);
        dialogCustomExit.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogCustomExit.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialogCustomExit.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialogCustomExit.setContentView(R.layout.exit_dialog_layout);
        dialogCustomExit.setCancelable(true);
        dialogCustomExit.show();
        dialogCustomExit.getWindow().setAttributes(lp);

        TextView btnNegative = dialogCustomExit.findViewById(R.id.btnNegative);
        TextView btnPositive = dialogCustomExit.findViewById(R.id.btnPositive);

        btnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCustomExit.dismiss();
                finishAffinity();

            }
        });
        btnNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCustomExit.dismiss();

            }
        });
    }
    private void LoadAndShowAds() {
        RemoteConfig remoteConfig = new RemoteConfig();
        AdsUtils.INSTANCE.RemoteBanner(this,AdsUtils.INSTANCE.getADS_BANNER().toString(),true,fl_banner,view_line);
        AdsUtils.INSTANCE.loadInterstitialAd(this, AdsUtils.INSTANCE.getInterAdHolder());
    }
}