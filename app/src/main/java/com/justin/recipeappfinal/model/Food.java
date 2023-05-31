package com.justin.recipeappfinal.model;

import androidx.annotation.NonNull;

public class Food {

    private long mId;

    private String mText;
    private long mUpdateTime;

    public Food(@NonNull String text) {
        mText = text;
        mUpdateTime = System.currentTimeMillis();
    }

    //the id is what is called when the app needs to know what recipe to show on the list.

    public long getId() {
        return mId;
    }



    public void setId(long id) {
        mId = id;
    }



    public String getText() {
        return mText;
    }

    public void setText(String subject) {
        mText = subject;
    }

    public long getUpdateTime() {
        return mUpdateTime;
    }

    public void setUpdateTime(long updateTime) {
        mUpdateTime = updateTime;
    }
}