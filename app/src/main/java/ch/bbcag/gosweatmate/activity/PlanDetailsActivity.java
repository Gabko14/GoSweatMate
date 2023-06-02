package ch.bbcag.gosweatmate.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
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
import ch.bbcag.gosweatmate.dal.dao.LogDao;
import ch.bbcag.gosweatmate.dal.dao.LogEntriesDao;
import ch.bbcag.gosweatmate.dal.dao.WorkoutDao;
import ch.bbcag.gosweatmate.dal.dao.WorkoutHasExerciseDao;
import ch.bbcag.gosweatmate.dal.database.AppDatabase;
import ch.bbcag.gosweatmate.dal.entities.Log;
import ch.bbcag.gosweatmate.dal.entities.LogEntrie;
import ch.bbcag.gosweatmate.dal.entities.WorkoutHasExercise;

public class PlanDetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button deleteWorkoutButton;
    private Button finishedWorkoutButton;
    private WorkoutHasExerciseDao workoutHasExerciseDao;
    private WorkoutDao workoutDao;
    private LogDao logDao;
    private LogEntriesDao logEntriesDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_details);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView11);
        deleteWorkoutButton = (Button) findViewById(R.id.deleteWorkoutButton);
        finishedWorkoutButton = (Button) findViewById(R.id.finishButton);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<Integer> exerciseIds = new ArrayList<>();

        Intent intent = getIntent();
        int workoutId = intent.getIntExtra("workoutId", 0);

        workoutHasExerciseDao = AppDatabase.getInstance(getApplicationContext()).getWorkoutHasExerciseDao();
        workoutDao = AppDatabase.getInstance(getApplicationContext()).getWorkoutDao();
        logDao = AppDatabase.getInstance(getApplicationContext()).getLogDao();
        logEntriesDao = AppDatabase.getInstance(getApplicationContext()).getLogEntriesDao();

        List<WorkoutHasExercise> allWorkoutHasExercise = workoutHasExerciseDao.getAll();

        for (WorkoutHasExercise workoutHasExercise : allWorkoutHasExercise) {
            long currentWorkoutId = workoutHasExercise.getWorkoutId();
            long exerciseId = workoutHasExercise.getExerciseId();

            if (workoutId == currentWorkoutId) {
                exerciseIds.add((int) exerciseId);
            }
        }
        myAdapter = new PlanDetailsAdapter(exerciseIds, getApplicationContext());
        recyclerView.setAdapter(myAdapter);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        deleteWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workoutDao.deleteById(workoutId);

                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(myIntent);
            }
        });

        finishedWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log newLog = new Log();
                newLog.setWorkoutId(workoutId);
                newLog.setWorkoutName(workoutDao.getById(workoutId).getName());
                newLog.setDate(String.valueOf(java.time.LocalDate.now()));

                logDao.insertAll(newLog);

                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(myIntent);
                //This will get used once the user is able the Log every singgle Exercise in a plan
//                List<Log> allLogs = logDao.getAll();
//                LogEntrie newLogEntrie = new LogEntrie();
//                newLogEntrie.setLogId(allLogs.size() - 1);
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