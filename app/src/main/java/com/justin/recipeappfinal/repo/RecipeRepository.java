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
        recipe.setId(3);
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
        food.setId(2);

        //This has been set to "true" to show that the favorites function itself works.
        if(toggleButtonState = true) {

            Favorites favorites = new Favorites("COOKIES");
            favorites.setFavId(2);
            addFavorites(favorites);

        }
        addRecipe(food);


        recipe = new Recipe();
        recipe.setId(1);
        recipe.setText("Sauce");
        recipe.setIngredients("Cookie Dough");
        recipe.setInstructions("Bake Cookiedough at 350F degrees in oven for 10 minutes");
        recipe.setSubjectId(2);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Serving");
        recipe.setIngredients("Cookies");
        recipe.setInstructions("Consume Cookies!");
        recipe.setSubjectId(2);
        addStep(recipe);


// ///////////////////////////////////////////////////////////////

        //        Steps for pancakes
        food = new Food("PANCAKES");
        food.setId(3);

        //This has been set to "true" to show that the favorites function itself works.
        if(toggleButtonState = true) {

            Favorites favorites = new Favorites("PANCAKES");
            favorites.setFavId(3);
            addFavorites(favorites);

        }


        addRecipe(food);


        recipe = new Recipe();
        recipe.setId(1);
        recipe.setText("batter");
        recipe.setIngredients("Flour & Sugar \n\n Milk & Butter \n\n 2 Eggs");
        recipe.setInstructions("Mix batter until it has the consistancy of sludge \n\n Pour onto pan or some heated cooking implement \n\n regularly flip until both sides are golden brown \n\n remove from pan and or heat ");
        recipe.setSubjectId(3);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Serving");
        recipe.setIngredients("Pancakes\n\nSyrup & Butter (if desired)");
        recipe.setInstructions("Place pancakes onto plate\n\nuse syrup or butter if desired\n\nEnjoy");
        recipe.setSubjectId(3);
        addStep(recipe);


 ///////////////////////////////////////////////////////////////


        //        Steps for Mac & Cheese
        // Mac and Cheese is a yellow color, perfect.
        food = new Food("Mac & Cheese");
        food.setId(4);

        //This has been set to "true" to show that the favorites function itself works.
        if(toggleButtonState = true) {

            Favorites favorites = new Favorites("Mac & Cheese");
            favorites.setFavId(4);
            addFavorites(favorites);

        }


        addRecipe(food);


        recipe = new Recipe();
        recipe.setId(1);
        recipe.setText("Roux");
        recipe.setIngredients("1/2 lb Shredded Cheddar cheese \n\n 2 Tbs of Butter \n\n 1 cup of milk");
        recipe.setInstructions("put cheese and butter into pot \"X\" allow both to cook at low temperature \n\n Mix together until congealed into mass \n\n quickly insert milk and increase heat \n\n Once all mixes into sauce, remove from heat");
        recipe.setSubjectId(4);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Pasta");
        recipe.setIngredients("2 cups of water\n\nSalt\n\n1/2 - 1 pound dry elbow pasta");
        recipe.setInstructions("pour 2 cups of water into large pot\n\n Throw a pinch of salt into water\n\n Heat water until boil\n\n Place pasta into water, boil for 4 minutes or until Al Dente \n\n Strain, and return to pot");
        recipe.setSubjectId(4);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(3);
        recipe.setText("Serving");
        recipe.setIngredients("Quarter Oz tomato sauce\n\nHalf pound spaghetti\n\nSalt & pepper (if desired)");
        recipe.setInstructions("Pour Roux over pasta\n\nImmediately serve\n\nEnjoy");
        recipe.setSubjectId(4);
        addStep(recipe);


// ///////////////////////////////////////////////////////////////

        //        Steps for pancakes
        food = new Food("Toast");
        food.setId(5);

        //This has been set to "true" to show that the favorites function itself works.
        if(toggleButtonState = true) {

            Favorites favorites = new Favorites("Toast");
            favorites.setFavId(5);
            addFavorites(favorites);

        }


        addRecipe(food);


        recipe = new Recipe();
        recipe.setId(1);
        recipe.setText("Toast");
        recipe.setIngredients("Toaster \n\n Bread");
        recipe.setInstructions("Toasters toast toast");
        recipe.setSubjectId(5);
        addStep(recipe);




// ///////////////////////////////////////////////////////////////
        //The actual content of the recipes wasn't done til near the very end.
        //I didn't really have the time to find and trim down so many recipes.

        //        Steps for Stirfry
        food = new Food("Veggie Stir-fry");
        food.setId(6);

        //This has been set to "true" to show that the favorites function itself works.
        if(toggleButtonState = true) {

            Favorites favorites = new Favorites("Veggie Stir-fry");
            favorites.setFavId(6);
            addFavorites(favorites);

        }


        addRecipe(food);


        recipe = new Recipe();
        recipe.setId(1);
        recipe.setText("Step 1");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(6);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Step 2");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(6);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(3);
        recipe.setText("Step 3");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(6);
        addStep(recipe);


// ///////////////////////////////////////////////////////////////

        //        Steps for Chocolate Mousse
        food = new Food("Chocolate Mousse");
        food.setId(7);

        //This has been set to "true" to show that the favorites function itself works.
        if(toggleButtonState = true) {

            Favorites favorites = new Favorites("Chocolate Mousse");
            favorites.setFavId(7);
            addFavorites(favorites);

        }


        addRecipe(food);


        recipe = new Recipe();
        recipe.setId(1);
        recipe.setText("Step 1");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(7);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Step 2");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(7);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(3);
        recipe.setText("Step 3");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(7);
        addStep(recipe);


// ///////////////////////////////////////////////////////////////

        //        Steps for Ice Cream
        food = new Food("Ice Cream");
        food.setId(8);

        //This has been set to "true" to show that the favorites function itself works.
        if(toggleButtonState = true) {

            Favorites favorites = new Favorites("Ice Cream");
            favorites.setFavId(8);
            addFavorites(favorites);

        }


        addRecipe(food);


        recipe = new Recipe();
        recipe.setId(1);
        recipe.setText("Step 1");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(8);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Step 2");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(8);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(3);
        recipe.setText("Step 3");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(8);
        addStep(recipe);


// ///////////////////////////////////////////////////////////////

        //        Steps for Shit on a Shingle (not kidding that's what its called)
        food = new Food("Chipped Beef");
        food.setId(9);


        if(toggleButtonState = false) {

            Favorites favorites = new Favorites("Chipped Beef");
            favorites.setFavId(9);
            addFavorites(favorites);

        }


        addRecipe(food);


        recipe = new Recipe();
        recipe.setId(1);
        recipe.setText("Step 1");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(9);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Step 2");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(9);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(3);
        recipe.setText("Step 3");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(9);
        addStep(recipe);


// ///////////////////////////////////////////////////////////////

        //        Steps for Brownies
        food = new Food("Brownies");
        food.setId(10);

        //This has been set to "true" to show that the favorites function itself works.
        if(toggleButtonState = true) {

            Favorites favorites = new Favorites("Brownies");
            favorites.setFavId(10);
            addFavorites(favorites);

        }


        addRecipe(food);


        recipe = new Recipe();
        recipe.setId(1);
        recipe.setText("Step 1");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(10);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Step 2");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(10);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(3);
        recipe.setText("Step 3");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(10);
        addStep(recipe);


// ///////////////////////////////////////////////////////////////

        //        Steps for Frìttuli (think like a italian pork stew)
        food = new Food("Frìttuli");
        food.setId(11);

        //This has been set to "true" to show that the favorites function itself works.
        if(toggleButtonState = true) {

            Favorites favorites = new Favorites("Frìttuli");
            favorites.setFavId(11);
            addFavorites(favorites);

        }


        addRecipe(food);


        recipe = new Recipe();
        recipe.setId(1);
        recipe.setText("Step 1");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(11);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Step 2");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(11);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(3);
        recipe.setText("Step 3");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(11);
        addStep(recipe);


// ///////////////////////////////////////////////////////////////

        //        Steps for Ham
        food = new Food("Ham");
        food.setId(12);


        if(toggleButtonState = false) {

            Favorites favorites = new Favorites("Ham");
            favorites.setFavId(12);
            addFavorites(favorites);

        }


        addRecipe(food);


        recipe = new Recipe();
        recipe.setId(1);
        recipe.setText("Step 1");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(12);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Step 2");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(12);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(3);
        recipe.setText("Step 3");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(12);
        addStep(recipe);


// ///////////////////////////////////////////////////////////////

        //        Steps for Grilled Cheese
        food = new Food("Grilled Cheese");
        food.setId(13);


        if(toggleButtonState = false) {

            Favorites favorites = new Favorites("Grilled Cheese");
            favorites.setFavId(13);
            addFavorites(favorites);

        }


        addRecipe(food);


        recipe = new Recipe();
        recipe.setId(1);
        recipe.setText("Step 1");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(13);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Step 2");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(13);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(3);
        recipe.setText("Step 3");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(13);
        addStep(recipe);


// ///////////////////////////////////////////////////////////////

        //        Steps for Grilled Chicken
        food = new Food("Grilled Chicken");
        food.setId(14);

        //This has been set to "true" to show that the favorites function itself works.
        if(toggleButtonState = true) {

            Favorites favorites = new Favorites("Grilled Chicken");
            favorites.setFavId(14);
            addFavorites(favorites);

        }


        addRecipe(food);


        recipe = new Recipe();
        recipe.setId(1);
        recipe.setText("Step 1");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(14);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Step 2");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(14);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(3);
        recipe.setText("Step 3");
        recipe.setIngredients("Ingredients here");
        recipe.setInstructions("Insert Instructions");
        recipe.setSubjectId(1);
        addStep(recipe);


 ///////////////////////////////////////////////////////////////
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


    public List<Food> getInstructions() {
        return mFoodList;
    }


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

