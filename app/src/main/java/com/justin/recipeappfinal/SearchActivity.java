package com.justin.recipeappfinal;

import androidx.appcompat.app.AppCompatActivity;
import com.justin.recipeappfinal.repo.RecipeRepository;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {


    //todo: insert a search function, look into filtering arrays using a filter() function
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ListView list = (ListView) findViewById(R.id.searchView);

        //Todo: make array list <Recipes> or <Food> after importing/extending it into this class
        ArrayList<String> Recipes = new ArrayList<>();
        //right now its going to just be text, what i want to do is move the private array names into a public array, bring it over here and then load that into it from there.
        Recipes.add("Spaghetti");
        Recipes.add("Cookies");
        Recipes.add("Pancakes");
        Recipes.add("Mac & Cheese");
        Recipes.add("Toast");
        Recipes.add("Veggie Stir-fry");
        Recipes.add("Chocolate Mousse");
        Recipes.add("Ice Cream");
        Recipes.add("Chipped Beef");
        Recipes.add("Brownies");
        Recipes.add("Fr");

    }


    //this is what gives us the search bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        return true;
    }
}