package com.justin.recipeappfinal.viewmodel;


import android.app.Application;
import com.justin.recipeappfinal.model.Recipe;
import com.justin.recipeappfinal.repo.RecipeRepository;

import java.util.List;

public class InstructionListViewModel {

    private RecipeRepository studyRepo;

    public InstructionListViewModel(Application application) {
        studyRepo = RecipeRepository.getInstance(application.getApplicationContext());
    }

    public List<Recipe> getQuestions(long subjectId) {
        return studyRepo.getStep(subjectId);
    }
}

