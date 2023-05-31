package com.justin.recipeappfinal.repo;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.justin.recipeappfinal.R;
import com.justin.recipeappfinal.model.Favorites;
import com.justin.recipeappfinal.model.Food;
import com.justin.recipeappfinal.model.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecipeRepository extends AppCompatActivity {

    private static RecipeRepository mRecipeRepo;
    private final List<Food> mFoodList;

    private final List<Favorites> mFavoritesList;
    private final HashMap<Long, List<Recipe>> mRecipeList;

    private final HashMap<Long, List<Favorites>> mHashFavList;

    private String favName;

    private boolean toggleButtonState;

    //Solely exists to pull a check for the favorite star
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_items);

        //this saves the current state of the toggle as a true or false
        ToggleButton simpleToggleButton = (ToggleButton) findViewById(R.id.toggleButton); // initiate a toggle button

        ToggleButton btn = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButtonState = simpleToggleButton.isChecked();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStarterData();

            }
        });
        ///////////////////////////////////////////////////////////////

//        simpleToggleButton.setOnClickListener(new View.OnClickListener() {
//
//            //TODO: This isnt working, fix it
//            @Override
//            public void onClick(View arg0) {
//                if(simpleToggleButton.isChecked()){
////
////                    setFavorites(favName);
//                }
//                else {
//
//
//                }
//            }
//        });
//// //////////////////////////////////////////////////////////////////////////////////////////



    }

    public static RecipeRepository getInstance(Context context) {
        if (mRecipeRepo == null) {
            mRecipeRepo = new RecipeRepository(context);
        }
        return mRecipeRepo;
    }

    private RecipeRepository(Context context) {

        mFoodList = new ArrayList<>();
        mFavoritesList = new ArrayList<>();
        mRecipeList = new HashMap<>();
        mHashFavList = new HashMap<>();




        addStarterData();
    }



    // adds items to list
    private void addStarterData() {
//        Steps for Spaghetti
        // start subject to create new recipe
        Food food = new Food("SPAGHETTI");
        food.setId(1);


        // TODO: create an if that checks whether the star has been toggled
        //The Favorited status won't immediately update, but since it will be called again when you go into the favorites menu this isn't an issue

        //ok heres the main issue, basically the favorites function works. But i cannot get a toggle button click listener or statecheck on toggle to work to save my life.
        //if you change this variable to true, the item will appear in favorites, which is
        // technically the favorites system is functional. Rather being able to favorite an item doesn't work.
        if(toggleButtonState = false) {

            Favorites favorites = new Favorites("SPAGHETTI");
            favorites.setFavId(1);
            addFavorites(favorites);

        }


        addRecipe(food);

        //recipe new recipe creates individual steps
        Recipe recipe = new Recipe();
        recipe.setId(1);

        recipe.setText("Sauce");
        recipe.setIngredients("4 Roma tomatoes \n\n 1/2 clove of garlic \n\n 1 tablespoon of oregano");
        recipe.setInstructions("slice the skin of the tomato in a \"X\" pattern \n\n boil them for 1 minute \n\n peel then dice tomato flesh\n\n Sautee with seasonings for 3 minutes ");
        recipe.setSubjectId(1);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Pasta");
        recipe.setIngredients("2 cups of water\n\nSalt\n\n1/2 - 1 pound dry spaghetti");
        recipe.setInstructions("pour 2 cups of water into large pot\n\n Throw a pinch of salt into water\n\n Heat water until boil\n\n Place pasta into water, boil for 4 minutes or until Al Dente \n\n Serve and enjoy!");
        recipe.setSubjectId(1);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Serving");
        recipe.setIngredients("Quarter Oz tomato sauce\n\nHalf pound spaghetti\n\nSalt & pepper (if desired)");
        recipe.setInstructions("Place pasta into bowl or place\n\nPour sauce over pasta\n\nAdd salt and pepper if desired");
        recipe.setSubjectId(1);
        addStep(recipe);



// ///////////////////////////////////////////////////////////////

//        Steps for cookies
        // only need to do Subject subject = new subject() once
        //after just do subject = new subject()
        food = new Food("COOKIES");
        food.setId(1);
        if(toggleButtonState = true) {

            Favorites favorites = new Favorites("COOKIES");
            favorites.setFavId(1);
            addFavorites(favorites);

        }
        addRecipe(food);

        //recipe new recipe creates individual steps
        recipe = new Recipe();
        recipe.setId(1);
        recipe.setText("Sauce");
        recipe.setIngredients("4 Roma tomatoes \n\n 1/2 clove of garlic \n\n 1 tablespoon of oregano");
        recipe.setInstructions("slice the skin of the tomato in a \"X\" pattern \n\n boil them for 1 minute \n\n peel then dice tomato flesh\n\n Sautee with seasonings for 3 minutes ");
        recipe.setSubjectId(1);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Pasta");
        recipe.setIngredients("2 cups of water\n\nSalt\n\n1/2 - 1 pound dry spaghetti");
        recipe.setInstructions("pour 2 cups of water into large pot\n\n Throw a pinch of salt into water\n\n Heat water until boil\n\n Place pasta into water, boil for 4 minutes or until Al Dente \n\n Serve and enjoy!");
        recipe.setSubjectId(1);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Serving");
        recipe.setIngredients("Quarter Oz tomato sauce\n\nHalf pound spaghetti\n\nSalt & pepper (if desired)");
        recipe.setInstructions("Place pasta into bowl or place\n\nPour sauce over pasta\n\nAdd salt and pepper if desired");
        recipe.setSubjectId(1);
        addStep(recipe);

// ///////////////////////////////////////////////////////////////

        //        Steps for pancakes
        food = new Food("PANCAKES");
        food.setId(1);

        //
        if(toggleButtonState = true) {

            Favorites favorites = new Favorites("PANCAKES");
            favorites.setFavId(2);
            addFavorites(favorites);

        }


        addRecipe(food);

        //recipe new recipe creates individual steps
        recipe = new Recipe();
        recipe.setId(1);
        recipe.setText("Sauce");
        recipe.setIngredients("4 Roma tomatoes \n\n 1/2 clove of garlic \n\n 1 tablespoon of oregano");
        recipe.setInstructions("slice the skin of the tomato in a \"X\" pattern \n\n boil them for 1 minute \n\n peel then dice tomato flesh\n\n Sautee with seasonings for 3 minutes ");
        recipe.setSubjectId(1);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Pasta");
        recipe.setIngredients("2 cups of water\n\nSalt\n\n1/2 - 1 pound dry spaghetti");
        recipe.setInstructions("pour 2 cups of water into large pot\n\n Throw a pinch of salt into water\n\n Heat water until boil\n\n Place pasta into water, boil for 4 minutes or until Al Dente \n\n Serve and enjoy!");
        recipe.setSubjectId(1);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Serving");
        recipe.setIngredients("Quarter Oz tomato sauce\n\nHalf pound spaghetti\n\nSalt & pepper (if desired)");
        recipe.setInstructions("Place pasta into bowl or place\n\nPour sauce over pasta\n\nAdd salt and pepper if desired");
        recipe.setSubjectId(1);
        addStep(recipe);


// ///////////////////////////////////////////////////////////////
    }


    public void addRecipe(Food food) {
        mFoodList.add(food);
        List<Recipe> recipeList = new ArrayList<>();
        mRecipeList.put(food.getId(), recipeList);
    }

    //calls favorites, similar to how items are called normally via addStep
    public void addFavorites(Favorites favorites) {
        //  REMINDER: If this doesn't play nice, nest in an if statement to make it skip.

        mFavoritesList.add(favorites);
        List<Favorites> favoritesList = new ArrayList<>();
        mHashFavList.put(favorites.getFavId(), favoritesList);
    }

    public Food getRecipe(long subjectId) {
        for (Food food : mFoodList) {
            if (food.getId() == subjectId) {
                return food;
            }
        }

        return null;
    }

    public List<Food> getSubjects() {
        return mFoodList;
    }




//    public void setFavorites(String favName){
//        Favorites favorites = new Favorites("SPAGHETTI");
//        favorites.setFavId(1);
//        addFavorites(favorites);
//
//    }

    //same logic as List food
    public List<Favorites> getFavorites() {
        return mFavoritesList;
    }

    public void addStep(Recipe recipe) {

        List<Recipe> recipeList = mRecipeList.get(recipe.getRecipeId());
        if (recipeList != null) {
            recipeList.add(recipe);
        }
    }

    public List<Recipe> getStep(long subjectId) {
        return mRecipeList.get(subjectId);
    }
}

