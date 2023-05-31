package com.justin.recipeappfinal.model;

import androidx.annotation.NonNull;

public class Favorites {



    private long mFavId;
    private String mText;

    public String mFavName;
    private long mUpdateTime;

    public Favorites(@NonNull String text) {
        mText = text;
        mUpdateTime = System.currentTimeMillis();
    }

    //the id is what is called when the app needs to know what recipe to show on the list.



    //same applies for Fav idea but for the favorite screen,
    // TODO: ONLY CALL WHEN favId IS NOT NULL (or ensure it can't be called when favId is null)
    public long getFavId() {
        return mFavId;
    }



    public void setFavId(long favId) {
        mFavId = favId;
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
