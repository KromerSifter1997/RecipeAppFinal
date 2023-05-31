package com.justin.recipeappfinal.viewmodel;

import android.app.Application;

import com.justin.recipeappfinal.model.Food;
import com.justin.recipeappfinal.repo.RecipeRepository;
import java.util.List;

public class RecipeListViewModel {

    private RecipeRepository recipeRepo;

    public RecipeListViewModel(Application application) {
        recipeRepo = RecipeRepository.getInstance(application.getApplicationContext());
    }

    public List<Food> getRecipes() {
        return recipeRepo.getSubjects();
    }

}