package com.prank.sound.hair.cut.ps.pranksound.Activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.prank.sound.hair.cut.ps.pranksound.Adapter.VerticalFavoriteSoundAdapter;
import com.prank.sound.hair.cut.ps.pranksound.Adapter.VerticalSoundAdapter;
import com.prank.sound.hair.cut.ps.pranksound.R;
import com.prank.sound.hair.cut.ps.pranksound.Room.AppDatabase;
import com.prank.sound.hair.cut.ps.pranksound.Room.InsertPrankSound;
import com.prank.sound.hair.cut.ps.pranksound.Room.QueryClass;
import com.prank.sound.hair.cut.ps.pranksound.utils.Common;

import java.util.Collections;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {
    ImageView imgBack;
    QueryClass queryClass;
    List<InsertPrankSound> arrFavPrankSound;
    RecyclerView rvSound;
    TextView txtNoFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        AppDatabase db = Room.databaseBuilder(this,
                AppDatabase.class, "prank_sound").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        queryClass = db.queryClass();

        findView();
        clickEvent();
    }

    private void findView() {
        imgBack = findViewById(R.id.imgBack);
        rvSound = findViewById(R.id.rvSound);
        txtNoFound = findViewById(R.id.txtNoFound);

        RelativeLayout rl_banner = findViewById(R.id.rl_banner);
        TextView txtAds = findViewById(R.id.txtAds);

        //  bannerLoadAndShow(this,txtAds, rl_banner);
    }

    private void clickEvent() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getOnBackPressedDispatcher().onBackPressed();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        arrFavPrankSound = queryClass.getAllFavSound();
        if (arrFavPrankSound.size() > 0) {
            Collections.reverse(arrFavPrankSound);
            txtNoFound.setVisibility(View.GONE);
            rvSound.setVisibility(View.VISIBLE);
            VerticalFavoriteSoundAdapter verticalSoundAdapter = new VerticalFavoriteSoundAdapter(this, arrFavPrankSound);
            GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
            rvSound.setLayoutManager(layoutManager);
            rvSound.setAdapter(verticalSoundAdapter);
        } else {
            rvSound.setVisibility(View.GONE);
            txtNoFound.setVisibility(View.VISIBLE);
        }

    }
}