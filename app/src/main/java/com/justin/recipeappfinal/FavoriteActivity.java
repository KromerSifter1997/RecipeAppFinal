package com.justin.recipeappfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.justin.recipeappfinal.model.Favorites;
import com.justin.recipeappfinal.viewmodel.FavoriteListViewModel;

import java.util.List;





public class FavoriteActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private int[] mSubjectColors;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        //reminder, make sure this says the correct layout else it duplicates the layout specified (might be useful in the future...)
        setContentView(R.layout.activity_favorite);


        FavoriteListViewModel mFavoriteListViewModel = new FavoriteListViewModel(getApplication());

        mSubjectColors = getResources().getIntArray(R.array.subjectColors);



        // Create 2 grid layout columns
        mRecyclerView = findViewById(R.id.Favorite_recycler_view);
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);





        // Show the subjects
        updateUI(mFavoriteListViewModel.getRecipes());



    }



    public void updateUI(List<Favorites> favoritesList) {
        FavoriteAdapter mFavAdapter = new FavoriteAdapter(favoritesList);
        mRecyclerView.setAdapter(mFavAdapter);

    }





    private class FavoritesHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {


        private Favorites mFavorites;
        private final TextView mFavoriteTextView;

        public FavoritesHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.favorite_view_items, parent, false));
            itemView.setOnClickListener(this);
            mFavoriteTextView = itemView.findViewById(R.id.favorite_text_view);
        }



        public void bindFav(Favorites favorites, int position) {
            mFavorites = favorites;
            mFavoriteTextView.setText(favorites.getText());

            // Make the background color dependent on the length of the subject string
            int colorIndex = favorites.getText().length() % mSubjectColors.length;
            mFavoriteTextView.setBackgroundColor(mSubjectColors[colorIndex]);
        }

        @Override
        public void onClick(View view) {
            // Start QuestionActivity with the selected subject
            Intent intent = new Intent(FavoriteActivity.this, InstructionActivity.class);
            intent.putExtra(InstructionActivity.EXTRA_SUBJECT_ID, mFavorites.getFavId());
            intent.putExtra(InstructionActivity.EXTRA_SUBJECT_TEXT, mFavorites.getText());

            startActivity(intent);
        }
    }

    //takes advantage of the same card setup the recipe activity uses but uses the favorites layout.
    private class FavoriteAdapter extends RecyclerView.Adapter<FavoritesHolder> {

        private final List<Favorites> mFavoriteList;

        public FavoriteAdapter(List<Favorites> foods) {
            mFavoriteList = foods;
        }

        @NonNull
        @Override
        public FavoritesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            return new FavoritesHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(FavoritesHolder holder, int position) {
            holder.bindFav(mFavoriteList.get(position), position);
        }

        @Override
        public int getItemCount() {
            return mFavoriteList.size();
        }
    }

}