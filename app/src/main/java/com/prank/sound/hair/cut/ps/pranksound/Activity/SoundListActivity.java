package com.prank.sound.hair.cut.ps.pranksound.Activity;


import static com.prank.sound.hair.cut.ps.pranksound.utils.AdsUtils.INSTANCE;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.air_horn;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.cate_name;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.count_down;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.fart;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.ghost;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.gun;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.hair_clipper;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.halloween;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.image_sound;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.is_fav;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.music_name;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.snore;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.sound_path;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.test_sound;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dungvnhh98.percas.studio.admoblib.admob.AdmobManager;
import com.google.android.gms.ads.AdValue;
import com.prank.sound.hair.cut.ps.pranksound.Adapter.VerticalSoundAdapterTest;
import com.prank.sound.hair.cut.ps.pranksound.R;
import com.prank.sound.hair.cut.ps.pranksound.model.Sound;
import com.prank.sound.hair.cut.ps.pranksound.utils.AdsUtils;
import com.prank.sound.hair.cut.ps.pranksound.utils.BaseActivity;
import com.prank.sound.hair.cut.ps.pranksound.utils.ImageLoader;
import com.prank.sound.hair.cut.ps.pranksound.utils.RemoteConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SoundListActivity extends BaseActivity {
    ImageView imgBack;
    RecyclerView rvSound;

    TextView txtTitle;

    List<String> imageList;

    FrameLayout fl_banner;
    View view_line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_list);

        findView();

    }
    private void findView() {
        imgBack = findViewById(R.id.imgBack);
        rvSound = findViewById(R.id.rvSound);
        txtTitle = findViewById(R.id.txtTitle);

        fl_banner = findViewById(R.id.ads_banner);
        view_line = findViewById(R.id.line);

        RelativeLayout rl_banner = findViewById(R.id.rl_banner);
        TextView txtAds = findViewById(R.id.txtAds);

        LoadAndShowAds();

        String strCateName = getIntent().getStringExtra(cate_name);

        try {
            if (strCateName != null) {
                if (strCateName.equals(air_horn)) {
                    txtTitle.setText(getString(R.string.air_horn));
                } else if (strCateName.equals(hair_clipper)) {
                    txtTitle.setText(getString(R.string.hair_clipper));
                } else if (strCateName.equals(fart)) {
                    txtTitle.setText(getString(R.string.fart));
                } else if (strCateName.equals(count_down)) {
                    txtTitle.setText(getString(R.string.count_down));
                } else if (strCateName.equals(gun)) {
                    txtTitle.setText(getString(R.string.gun));
                } else if (strCateName.equals(ghost)) {
                    txtTitle.setText(getString(R.string.ghost));
                } else if (strCateName.equals(halloween)) {
                    txtTitle.setText(getString(R.string.halloween));
                } else if (strCateName.equals(snore)) {
                    txtTitle.setText(getString(R.string.snore));
                } else if (strCateName.equals(test_sound)) {
                    txtTitle.setText("Test Sound");
                }

                // lấy hình ảnh từ file asset
                String[] images = getAssets().list("prank_sound/" + strCateName);
                List<Sound> listSound = new ArrayList<>();
                assert images != null;

                //list đường dẫn đến hình ảnh ở list asset
                List<String> imageList = ImageLoader.getImageListFromAssets(this, "prank_image/" + strCateName);
                Log.d("list_image", "prank_image/" + strCateName);
                Log.d("list_image", String.valueOf(imageList.size()));
                Log.d("list_image", imageList.get(0));

                for (int i = 0; i < images.length; i++) {
                    Sound sound;
                    if (i >= 10) {
                        sound = new Sound(strCateName, imageList.get(i), images[i], 0, true, false);
                    } else {
                        sound = new Sound(strCateName, imageList.get(i), images[i], 0, false, false);
                    }
                    listSound.add(sound);

                }
                VerticalSoundAdapterTest verticalSoundAdapter = new VerticalSoundAdapterTest(this, listSound);
                GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
                rvSound.setLayoutManager(layoutManager);
                rvSound.setAdapter(verticalSoundAdapter);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                INSTANCE.loadAndShowInterstitialAd(SoundListActivity.this, INSTANCE.getInterAdHolder(), new AdsUtils.loadAndShow() {
                    @Override
                    public void onAdClose() {
                        Log.d("check_show_ads", "show in back sound list");
                        startActivity(new Intent(SoundListActivity.this, MainActivity.class));
                    }

                    @Override
                    public void onAdFailed() {
                        Log.d("check_show_ads", "not show in back sound list");
                        startActivity(new Intent(SoundListActivity.this, MainActivity.class));
                    }
                });

            }
        });
    }

    private void LoadAndShowAds() {
        RemoteConfig remoteConfig = new RemoteConfig();
        AdsUtils.INSTANCE.RemoteBanner(this,AdsUtils.INSTANCE.getADS_BANNER().toString(),true,fl_banner,view_line);
        AdsUtils.INSTANCE.loadInterstitialAd(this, AdsUtils.INSTANCE.getInterAdHolder());

    }
}