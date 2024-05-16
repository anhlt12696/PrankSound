package com.prank.sound.hair.cut.ps.pranksound.Adapter;


import static com.prank.sound.hair.cut.ps.pranksound.utils.AdsUtils.INSTANCE;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.cate_name;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.image_sound;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.is_fav;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.music_name;
import static com.prank.sound.hair.cut.ps.pranksound.utils.KeyClass.sound_path;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dungvnhh98.percas.studio.admoblib.admob.AdmobManager;
import com.google.android.gms.ads.AdValue;
import com.prank.sound.hair.cut.ps.pranksound.Activity.SoundDetailActivity;
import com.prank.sound.hair.cut.ps.pranksound.Activity.SoundListActivity;
import com.prank.sound.hair.cut.ps.pranksound.R;
import com.prank.sound.hair.cut.ps.pranksound.model.Record;
import com.prank.sound.hair.cut.ps.pranksound.utils.AdsUtils;

import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder> {

    private List<Record> recordList;
    private  Activity context;

    public RecordAdapter(Activity context, List<Record> recordList) {
        this.context = context;
        this.recordList = recordList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_record, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Record record = recordList.get(position);
        holder.textViewName.setText(record.getName());
        holder.textViewTime.setText(record.getTime());
       // holder.imageView.setImageResource(record.getImage());

        Glide.with(context).load(record.getImage()).into( holder.imageView);




//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fullAdsLoadAndShow(context, new AdsClass.MyCallback() {
//                    @Override
//                    public void callbackCall() {
//                        Log.d("List_record","sound_path_in_adapter: " + record.getFilePath());
//                        Intent intent  = new Intent(context, SoundDetailActivity.class);
//                        intent.putExtra(is_fav, false);
//                        intent.putExtra(music_name,record.getName());
//                        intent.putExtra(image_sound,record.getImage());
//                        intent.putExtra(cate_name,"Record");
//                        intent.putExtra(sound_path, record.getFilePath());
//
//                        context.startActivity(intent);
//                    }
//                });
//            }
//        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
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
//                        Log.d("List_record","sound_path_in_adapter: " + record.getFilePath());
//                        Intent intent  = new Intent(context, SoundDetailActivity.class);
//                        intent.putExtra(is_fav, false);
//                        intent.putExtra(music_name,record.getName());
//                        intent.putExtra(image_sound,record.getImage());
//                        intent.putExtra(cate_name,"Record");
//                        intent.putExtra(sound_path, record.getFilePath());
//
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
                        Log.d("check_show_ads","show in record");
                        Intent intent = new Intent(context, SoundDetailActivity.class);
                        intent.putExtra(is_fav, false);
                        intent.putExtra(music_name, record.getName());
                        intent.putExtra(image_sound, record.getImage());
                        intent.putExtra(cate_name, "Record");
                        intent.putExtra(sound_path, record.getFilePath());

                        context.startActivity(intent);
                    }

                    @Override
                    public void onAdFailed() {
                        Log.d("check_show_ads","not show in record");
                        Intent intent = new Intent(context, SoundDetailActivity.class);
                        intent.putExtra(is_fav, false);
                        intent.putExtra(music_name, record.getName());
                        intent.putExtra(image_sound, record.getImage());
                        intent.putExtra(cate_name, "Record");
                        intent.putExtra(sound_path, record.getFilePath());

                        context.startActivity(intent);
                    }
                });

            }
        });
    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewTime;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewTime = itemView.findViewById(R.id.textViewTime);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

}
