package com.prank.sound.hair.cut.ps.pranksound.Adapter;



import static com.prank.sound.hair.cut.ps.pranksound.utils.AdsUtils.INSTANCE;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.air_horn;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.cate_name;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.count_down;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.fart;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.ghost;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.gun;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.hair_clipper;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.halloween;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.is_fav;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.music_name;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.snore;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.test_sound;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;


import com.dungvnhh98.percas.studio.admoblib.admob.AdmobManager;
import com.google.android.gms.ads.AdValue;
import com.prank.sound.hair.cut.ps.pranksound.Activity.SoundDetailActivity;
import com.prank.sound.hair.cut.ps.pranksound.Activity.SoundListActivity;
import com.prank.sound.hair.cut.ps.pranksound.R;
import com.prank.sound.hair.cut.ps.pranksound.utils.AdsUtils;

import org.jetbrains.annotations.NotNull;

import java.util.Random;


public class VerticalSoundAdapter extends Adapter<VerticalSoundAdapter.MyViewHolder> {

    private Activity context;
    String[] images;
    String strCateName;


    public VerticalSoundAdapter(Activity context, String[] images, String strCateName) {
        this.context = context;
        this.images = images;
        this.strCateName = strCateName;

    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    @RequiresApi(api = 16)
    public void onBindViewHolder(MyViewHolder myViewHolder, @SuppressLint("RecyclerView") int i) {

        int number = i + 1;
        final int min = 0;
        final int max = 8;
        final int random = new Random().nextInt((max - min) + 1) + min;
//        if (strCateName.equals(air_horn)) {
//            myViewHolder.imgCate.setImageResource(R.drawable.air_horn);
//        }else if (strCateName.equals(hair_clipper)) {
//            myViewHolder.imgCate.setImageResource(R.drawable.hair_clipper);
//        }else if (strCateName.equals(fart)) {
//            myViewHolder.imgCate.setImageResource(R.drawable.fart);
//        }else if (strCateName.equals(count_down)) {
//            myViewHolder.imgCate.setImageResource(R.drawable.burp);
//        }else if (strCateName.equals(ghost)) {
//            myViewHolder.imgCate.setImageResource(R.drawable.toilet_flushing);
//        }else if (strCateName.equals(halloween)) {
//            myViewHolder.imgCate.setImageResource(R.drawable.gun);
//        }else if (strCateName.equals(snore)) {
//            myViewHolder.imgCate.setImageResource(R.drawable.breaking);
//        }else if (strCateName.equals(gun)) {
//            myViewHolder.imgCate.setImageResource(R.drawable.car);
//        } else if (strCateName.equals(test_sound )) {
//            myViewHolder.imgCate.setImageResource(R.drawable.air_horn);
//        }





     //   myViewHolder.txtSoundName.setText(context.getString(R.string.sound) +" " + number);
        myViewHolder.txtSoundName.setText(soundName(images[i]));
//        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fullAdsLoadAndShow(context, new AdsClass.MyCallback() {
//                    @Override
//                    public void callbackCall() {
//                        int number = i + 1;
//                        Intent intent  = new Intent(context, SoundDetailActivity.class);
//                        intent.putExtra(is_fav, false);
//                      //  intent.putExtra(music_name,"Sound "+number);
//                        intent.putExtra(music_name,soundName(images[i]));
//                        intent.putExtra(cate_name,strCateName);
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
//                        Intent intent  = new Intent(context, SoundDetailActivity.class);
//                        intent.putExtra(is_fav, false);
//                        //  intent.putExtra(music_name,"Sound "+number);
//                        intent.putExtra(music_name,soundName(images[i]));
//                        intent.putExtra(cate_name,strCateName);
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
                        Log.d("check_show_ads","show in list sound");
                                                Intent intent  = new Intent(context, SoundDetailActivity.class);
                        intent.putExtra(is_fav, false);
                        //  intent.putExtra(music_name,"Sound "+number);
                        intent.putExtra(music_name,soundName(images[i]));
                        intent.putExtra(cate_name,strCateName);
                        context.startActivity(intent);

                    }

                    @Override
                    public void onAdFailed() {
                        Log.d("check_show_ads","not show in list sound");
                        Intent intent  = new Intent(context, SoundDetailActivity.class);
                        intent.putExtra(is_fav, false);
                        //  intent.putExtra(music_name,"Sound "+number);
                        intent.putExtra(music_name,soundName(images[i]));
                        intent.putExtra(cate_name,strCateName);
                        context.startActivity(intent);

                    }
                });


            }
        });

    }

    public String soundName(String sound){
        String[] sound_name = sound.split("\\.");
        return sound_name[0];
    }


    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {

        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_rcv, viewGroup, false));
    }

    public static class MyViewHolder extends ViewHolder {
        ImageView imgCate;
        TextView txtSoundName;
        LinearLayout cvBG;

        public MyViewHolder(View view) {
            super(view);
            imgCate = view.findViewById(R.id.imgCate);
            txtSoundName = view.findViewById(R.id.txtSoundName);
            cvBG = view.findViewById(R.id.cvBG);


        }
    }


}
