package ch.bbcag.gosweatmate.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import ch.bbcag.gosweatmate.R;
import ch.bbcag.gosweatmate.adapter.PlanDetailsAdapter;
import ch.bbcag.gosweatmate.dal.dao.WorkoutDao;
import ch.bbcag.gosweatmate.dal.dao.WorkoutHasExerciseDao;
import ch.bbcag.gosweatmate.dal.database.AppDatabase;
import ch.bbcag.gosweatmate.dal.entities.WorkoutHasExercise;
import ch.bbcag.gosweatmate.fragment.HomeFragment;

public class PlanDetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private WorkoutHasExerciseDao workoutHasExerciseDao;
    private WorkoutDao workoutDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_details);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView11);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<Integer> exerciseIds = new ArrayList<>();

        Intent intent = getIntent();
        int workoutId = intent.getIntExtra("workoutId", 0);

        workoutHasExerciseDao = AppDatabase.getInstance(getApplicationContext()).getWorkoutHasExerciseDao();
        workoutDao = AppDatabase.getInstance(getApplicationContext()).getWorkoutDao();

        List<WorkoutHasExercise> allWorkoutHasExercise = workoutHasExerciseDao.getAll();

        for (WorkoutHasExercise workoutHasExercise : allWorkoutHasExercise) {
            long currentWorkoutId = workoutHasExercise.getWorkoutId();
            long exerciseId = workoutHasExercise.getExerciseId();

            if (workoutId == currentWorkoutId) {
                System.out.println("WorkoutId: " + currentWorkoutId + " exerciseId: " + exerciseId);
                exerciseIds.add((int) exerciseId);
            }
        }
        myAdapter = new PlanDetailsAdapter(exerciseIds, getApplicationContext());
        recyclerView.setAdapter(myAdapter);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Button deleteWorkoutButton = findViewById(R.id.deleteWorkoutButton);

        deleteWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workoutDao.deleteById(workoutId);

                Fragment selectedFragment = HomeFragment.newInstance();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, selectedFragment);
                transaction.commit();

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);


    }
}