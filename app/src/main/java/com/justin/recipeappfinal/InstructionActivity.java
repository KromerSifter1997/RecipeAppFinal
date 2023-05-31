package com.justin.recipeappfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.justin.recipeappfinal.model.Recipe;
import com.justin.recipeappfinal.model.Food;
import com.justin.recipeappfinal.viewmodel.InstructionListViewModel;
import java.util.List;

public class InstructionActivity extends AppCompatActivity {

    public static final String EXTRA_SUBJECT_ID = "com.zybooks.studyhelper.subject_id";
    public static final String EXTRA_SUBJECT_TEXT  = "com.zybooks.studyhelper.subject_text";


    private InstructionListViewModel mInstructionListViewModel;
    private Food mFood;
    private List<Recipe> mRecipeList;
    private TextView mAnswerLabelTextView;
    private TextView mAnswerTextView;
    private TextView mQuestionTextView;

    private TextView mInstructionLabelTextView;
    private TextView mInstructionTextView;
    private ViewGroup mShowQuestionLayout;
    //    private ViewGroup mNoQuestionLayout;
    private int mCurrentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        mQuestionTextView = findViewById(R.id.question_text_view);
        mAnswerLabelTextView = findViewById(R.id.answer_label_text_view);
        mAnswerTextView = findViewById(R.id.answer_text_view);
        mInstructionLabelTextView = findViewById(R.id.instruction_label_text_view);
        mInstructionTextView = findViewById(R.id.instruction_text_view);
        mShowQuestionLayout = findViewById(R.id.show_question_layout);



        // SubjectActivity should provide the subject ID and text
        Intent intent = getIntent();
        long subjectId = intent.getLongExtra(EXTRA_SUBJECT_ID, 0);
        String subjectText = intent.getStringExtra(EXTRA_SUBJECT_TEXT);
        mFood = new Food(subjectText);
        mFood.setId(subjectId);

        // Get all questions for this subject
        mInstructionListViewModel = new InstructionListViewModel(getApplication());
        mRecipeList = mInstructionListViewModel.getQuestions(subjectId);

        // Display question
        updateUI();
    }

    private void updateUI() {
        showRecipe(mCurrentQuestionIndex);
        mShowQuestionLayout.setVisibility(View.VISIBLE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.recipe_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //  Determine which app bar item was chosen
        if (item.getItemId() == R.id.previous) {
            showRecipe(mCurrentQuestionIndex - 1);
            return true;
        }
        else if (item.getItemId() == R.id.next) {
            showRecipe(mCurrentQuestionIndex + 1);
            return true;
        }
        else if (item.getItemId() == R.id.Favoriter) {
            addToFavorites();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }



    private void updateAppBarTitle() {

        // displays the steps of the recipe
        String title = getResources().getString(R.string.stepNumber,
                mFood.getText(), mCurrentQuestionIndex + 1,  mRecipeList.size());
        setTitle(title);
    }

    private void addToFavorites() {
        //This is where the favorites list has a recipe added
//        call mFav to check if its false to make it true, then call that into a method for saving to favorites in a file to save between
//        if( = false){
//            mFav = true;
//        }
        // if a recipe is alerady favorited it is unfavorited and the method of removing the object from the saved favorites file is called
//        else if( mFav = true)
//        {
//            mFav = false;
//        }

    }


    private void showRecipe(int questionIndex) {

        // Show question at the given index
        if (mRecipeList.size() > 0) {
            if (questionIndex < 0) {
                questionIndex = mRecipeList.size() - 1;
            }
            else if (questionIndex >= mRecipeList.size()) {
                questionIndex = 0;
            }

            mCurrentQuestionIndex = questionIndex;
            updateAppBarTitle();

            Recipe recipe = mRecipeList.get(mCurrentQuestionIndex);
            mQuestionTextView.setText(recipe.getText());
            mAnswerTextView.setText(recipe.getIngredients());
            mInstructionTextView.setText(recipe.getInstructions());
        }
        else {
            // No questions yet
            mCurrentQuestionIndex = -1;
        }
    }

    private void toggleAnswerVisibility() {
        if (mAnswerTextView.getVisibility() == View.VISIBLE) {
            mAnswerTextView.setVisibility(View.INVISIBLE);
            mAnswerLabelTextView.setVisibility(View.INVISIBLE);
        }
        else {
            mAnswerTextView.setVisibility(View.VISIBLE);
            mAnswerLabelTextView.setVisibility(View.VISIBLE);
        }
    }
}