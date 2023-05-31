package com.justin.recipeappfinal.model;


public class Recipe {

    private long mId;
    private String mText;
    private String mIngredients;

    public boolean mFav = false;
    private String mInstructions;
    private long mRecipeId;


    //id is refering to the listed order of the subjects
    public void setId(long id) {
        mId = id;
    }

    public long getId() {
        return mId;
    }


    //Text is the title
    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }


    //
    public String getIngredients() {
        return mIngredients;
    }

    public void setIngredients(String ingredientList) {
        mIngredients = ingredientList;
    }

    public String getInstructions() {
        return mInstructions;
    }

    public void setInstructions(String instructions) {mInstructions = instructions;}


    public long getRecipeId() {
        return mRecipeId;
    }

    public void setSubjectId(long recipeId) {
        mRecipeId = recipeId;
    }
}