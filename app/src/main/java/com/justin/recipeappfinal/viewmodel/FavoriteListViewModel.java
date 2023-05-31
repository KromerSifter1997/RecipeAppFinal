package com.justin.recipeappfinal.viewmodel;


import android.app.Application;


import com.justin.recipeappfinal.model.Favorites;
import com.justin.recipeappfinal.repo.RecipeRepository;
import java.util.List;

public class FavoriteListViewModel {
    private RecipeRepository RecipeRepo;




    public FavoriteListViewModel(Application application) {
        RecipeRepo = RecipeRepository.getInstance(application.getApplicationContext());

    }

    public List<Favorites> getRecipes() {
        return RecipeRepo.getFavorites();
    }
}
