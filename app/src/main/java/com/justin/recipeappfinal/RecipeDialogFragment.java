package com.justin.recipeappfinal;


import android.content.Context;


import androidx.annotation.NonNull;

import androidx.fragment.app.DialogFragment;

public class RecipeDialogFragment extends DialogFragment {

    public interface OnSubjectEnteredListener {

    }

    private OnSubjectEnteredListener mListener;



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (OnSubjectEnteredListener) context;

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}