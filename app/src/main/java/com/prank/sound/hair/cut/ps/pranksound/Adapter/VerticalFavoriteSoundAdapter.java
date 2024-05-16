package com.prank.sound.hair.cut.ps.pranksound.Adapter;



import static com.prank.sound.hair.cut.ps.pranksound.utils.AdsUtils.INSTANCE;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.cate_name;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.image_sound;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.is_fav;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.music_name;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.sound_path;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;
import com.dungvnhh98.percas.studio.admoblib.admob.AdmobManager;
import com.google.android.gms.ads.AdValue;
import com.prank.sound.hair.cut.ps.pranksound.Activity.SoundDetailActivity;
import com.prank.sound.hair.cut.ps.pranksound.Activity.SoundListActivity;
import com.prank.sound.hair.cut.ps.pranksound.R;
import com.prank.sound.hair.cut.ps.pranksound.Room.InsertPrankSound;
import com.prank.sound.hair.cut.ps.pranksound.utils.AdsUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class VerticalFavoriteSoundAdapter extends Adapter<VerticalFavoriteSoundAdapter.MyViewHolder> {

    private Activity context;
    List<InsertPrankSound> arrFavPrankSound;


    public VerticalFavoriteSoundAdapter(Activity context, List<InsertPrankSound> arrFavPrankSound) {
        this.context = context;
        this.arrFavPrankSound = arrFavPrankSound;

    }

    @Override
    public int getItemCount() {
        return arrFavPrankSound.size();
    }


    @RequiresApi(api = 16)
    public void onBindViewHolder(MyViewHolder myViewHolder, @SuppressLint("RecyclerView") int i) {


        String strCateName = arrFavPrankSound.get(i).folder_name;
        String imagePath = arrFavPrankSound.get(i).image_path;
        Log.d("Img Path", imagePath);
        if(!imagePath.contains("png")){
            int resourceId = Integer.parseInt(imagePath);
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
            Glide.with(context).load(bitmap).into(myViewHolder.imgCate);
            Log.d("Img Path", "drawable");
        }else {
            Glide.with(context).load("file:///android_asset/" + imagePath).into( myViewHolder.imgCate);
            Log.d("Img Path", "asset");
        }
     //   Glide.with(context).load("file:///android_asset/" + imagePath).into( myViewHolder.imgCate);




        myViewHolder.cvBG.setBackgroundResource(R.drawable.bg_sound);

        myViewHolder.txtSoundName.setText(arrFavPrankSound.get(i).sound_name.replace("Sound",context.getString(R.string.sound)));

//        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fullAdsLoadAndShow(context, new AdsClass.MyCallback() {
//                    @Override
//                    public void callbackCall() {
//                        Intent intent = new Intent(context, SoundDetailActivity.class);
//                        intent.putExtra(is_fav, true);
//                        intent.putExtra(music_name, arrFavPrankSound.get(i).sound_name);
//                        intent.putExtra(cate_name, arrFavPrankSound.get(i).folder_name);
//                        intent.putExtra(image_sound,arrFavPrankSound.get(i).image_path);
//                        intent.putExtra(sound_path,arrFavPrankSound.get(i).sound_path);
//                        context.startActivity(intent);
//                    }
//                });
//
//            }
//        });

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AdmobManager.showInterstitialAd(context, INSTANCE.getInterAdHolder(), new AdmobManager.ShowAdCallBack() {
//                    @Override
//                    public void onAdShowed() {
//
//                    }
//
//                    @Override
//                    public void onAdFailed(@NonNull String s) {
//
//                    }
//
//                    @Override
//                    public void onAdClosed() {
//                        Intent intent = new Intent(context, SoundDetailActivity.class);
//                        intent.putExtra(is_fav, true);
//                        intent.putExtra(music_name, arrFavPrankSound.get(i).sound_name);
//                        intent.putExtra(cate_name, arrFavPrankSound.get(i).folder_name);
//                        intent.putExtra(image_sound,arrFavPrankSound.get(i).image_path);
//                        intent.putExtra(sound_path,arrFavPrankSound.get(i).sound_path);
//                        context.startActivity(intent);
//                    }
//
//                    @Override
//                    public void onAdPaid(@NonNull AdValue adValue, @NonNull String s) {
//
//                    }
//                });

                INSTANCE.loadAndShowInterstitialAd(context, INSTANCE.getInterAdHolder(), new AdsUtils.loadAndShow() {
                    @Override
                    public void onAdClose() {
                        Log.d("check_show_ads","show in verticalFav");
                        Intent intent = new Intent(context, SoundDetailActivity.class);
                        intent.putExtra(is_fav, true);
                        intent.putExtra(music_name, arrFavPrankSound.get(i).sound_name);
                        intent.putExtra(cate_name, arrFavPrankSound.get(i).folder_name);
                        intent.putExtra(image_sound, arrFavPrankSound.get(i).image_path);
                        intent.putExtra(sound_path, arrFavPrankSound.get(i).sound_path);
                        context.startActivity(intent);
                    }

                    @Override
                    public void onAdFailed() {
                        Log.d("check_show_ads","not show in verticalFav");
                        Intent intent = new Intent(context, SoundDetailActivity.class);
                        intent.putExtra(is_fav, true);
                        intent.putExtra(music_name, arrFavPrankSound.get(i).sound_name);
                        intent.putExtra(cate_name, arrFavPrankSound.get(i).folder_name);
                        intent.putExtra(image_sound, arrFavPrankSound.get(i).image_path);
                        intent.putExtra(sound_path, arrFavPrankSound.get(i).sound_path);
                        context.startActivity(intent);
                    }
                });

            }
        });

    }


    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {

        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_rcv, viewGroup, false));
    }

    public static class MyViewHolder extends ViewHolder {
        ImageView imgCate;
        TextView txtSoundName;
        RelativeLayout cvBG;

        public MyViewHolder(View view) {
            super(view);
            imgCate = view.findViewById(R.id.imgCate);
            txtSoundName = view.findViewById(R.id.txtSoundName);
            cvBG = view.findViewById(R.id.cvBG);


        }
    }


}
