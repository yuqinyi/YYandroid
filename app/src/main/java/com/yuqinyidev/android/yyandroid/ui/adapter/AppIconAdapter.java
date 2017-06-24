package com.yuqinyidev.android.yyandroid.ui.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yuqinyidev.android.yyandroid.R;
import com.yuqinyidev.android.yyandroid.fw.app.YYApp;
import com.yuqinyidev.android.yyandroid.login.LoginActivity;
import com.yuqinyidev.android.yyandroid.testmvp.view.CheckVersionActivity;
import com.yuqinyidev.android.yyandroid.trainingdiary.TrainingDiaryActivity;
import com.yuqinyidev.android.yyandroid.ui.dto.AppIcon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RDX64 on 2017/6/23.
 */

public class AppIconAdapter extends RecyclerView.Adapter<AppIconAdapter.ViewHolder> {
    private List<AppIcon> mAppIconList = new ArrayList<>();

    public AppIconAdapter(List<AppIcon> appIconList) {
        mAppIconList = appIconList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_home_recycler, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.appIconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                AppIcon fruit = mAppIconList.get(position);
                Toast.makeText(v.getContext(), "You clicked view: " + fruit.getName(), Toast.LENGTH_SHORT).show();

                LoginActivity.start();
            }
        });
//        holder.appIconImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//                AppIcon fruit = mAppIconList.get(position);
//                Toast.makeText(v.getContext(), "You clicked image: " + fruit.getName(), Toast.LENGTH_SHORT).show();
////                TrainingDiaryActivity.startAction(YYApp.getContext());
//            }
//        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AppIcon appIcon = mAppIconList.get(position);
        holder.appIconImage.setImageResource(appIcon.getImageId());
        holder.appIconName.setText(appIcon.getName());
    }

    @Override
    public int getItemCount() {
        return mAppIconList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View appIconView;
        ImageView appIconImage;
        TextView appIconName;

        public ViewHolder(View view) {
            super(view);
            appIconView = view;
            appIconImage = (ImageView) view.findViewById(R.id.appicon_image);
            appIconName = (TextView) view.findViewById(R.id.appicon_name);
        }
    }
}
