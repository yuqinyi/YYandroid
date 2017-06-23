package com.yuqinyidev.android.yyandroid.ui.dto;

/**
 * Created by RDX64 on 2017/6/23.
 */

public class AppIcon {
    private String name;
    private int imageId;

    public AppIcon(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

}
