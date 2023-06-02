package ch.bbcag.gosweatmate.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ch.bbcag.gosweatmate.R;
import ch.bbcag.gosweatmate.adapter.AddExerciseGalleryAdapter;
import ch.bbcag.gosweatmate.adapter.CreatePlanExercisesAdapter;
import ch.bbcag.gosweatmate.dal.dao.WorkoutDao;
import ch.bbcag.gosweatmate.dal.dao.WorkoutHasExerciseDao;
import ch.bbcag.gosweatmate.dal.database.AppDatabase;
import ch.bbcag.gosweatmate.dal.entities.Workout;
import ch.bbcag.gosweatmate.dal.entities.WorkoutHasExercise;
import ch.bbcag.gosweatmate.helper.ExerciseModelStorage;


public class CreatePlanActivity extends AppCompatActivity {

    private EditText editText;
    private List<Integer> exerciseIds = new ArrayList();
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private WorkoutDao workoutDao;
    private WorkoutHasExerciseDao workoutHasExerciseDao;

    private List<ExerciseModelStorage> exerciseModels = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_plan);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView19);
        editText = findViewById(R.id.editText);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Intent currentIntent = getIntent();
        Bundle extras = currentIntent.getExtras();

        if (currentIntent.getStringExtra("workoutName") != null) {
            editText.setText(currentIntent.getStringExtra("workoutName"));
        }

        //Take all the extras that we got and put them into the new Intent so they dont get lost
        if (extras != null) {
            for (int i = 1; i < extras.size() + 1; i++) {
                if (extras.containsKey("ExerciseId" + i)) {
                    int exerciseId = extras.getInt("ExerciseId" + i);
                    exerciseIds.add(exerciseId);
                }
            }
        }

        for (Integer exerciseId : exerciseIds) {
            String url = "https://wger.de/api/v2/exerciseinfo/" + exerciseId + "/?format=json";
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    JSONObject jsonResponse;
                    try {
                        jsonResponse = new JSONObject(response);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }


                    JSONArray imagesJsonArray;
                    try {
                        imagesJsonArray = jsonResponse.getJSONArray("images");
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                    ExerciseModelStorage currentModel = null;
                    try {
                        currentModel = new ExerciseModelStorage(jsonResponse.getString("name"),
                                jsonResponse.getInt("id"));
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                    JSONObject imageObject = null;
                    try {
                        if (!imagesJsonArray.isNull(0)) {
                            imageObject = imagesJsonArray.getJSONObject(0);
                            currentModel.setImageLink(imageObject.getString("image"));

                        }
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                    exerciseModels.add(currentModel);


                    myAdapter = new CreatePlanExercisesAdapter(CreatePlanActivity.this, exerciseModels);
                    recyclerView.setAdapter(myAdapter);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // Handle error
                }
            });
            queue.add(stringRequest);

        }

        Button addExercise = findViewById(R.id.AddExerciseButton);
        addExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(getApplicationContext(), AddExerciseActivity.class);

                if (exerciseIds.size() != 0) {
                    for (int i = 0; i < exerciseIds.size(); i++) {
                        newIntent.putExtra("ExerciseId" + (i + 1), exerciseIds.get(i));
                    }
                }
                newIntent.putExtra("workoutName", editText.getText().toString());

                startActivity(newIntent);
            }
        });

        Button createWorkoutButton = findViewById(R.id.createWorkoutButton);
        workoutDao = AppDatabase.getInstance(getApplicationContext()).getWorkoutDao();
        workoutHasExerciseDao = AppDatabase.getInstance(getApplicationContext()).getWorkoutHasExerciseDao();

        createWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String givenWorkoutName = editText.getText().toString();
                insertWorkoutIntoDB(givenWorkoutName);
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


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

    private void insertWorkoutIntoDB(String workoutName) {
        Workout newWorkout = new Workout();

        newWorkout.setName(workoutName);
        workoutDao.insertAll(newWorkout);

        List<Workout> allWorkouts = workoutDao.getAll();
        Integer workoutId = Math.toIntExact(allWorkouts.get(allWorkouts.size() - 1).getId());

        for (Integer exerciseId : exerciseIds) {
            insertExerciseIntoWorkout(workoutId, exerciseId);
        }

    }

    private void insertExerciseIntoWorkout(Integer workoutId, Integer exerciseId) {
        WorkoutHasExercise workoutHasExercise = new WorkoutHasExercise();

        workoutHasExercise.setWorkoutId(workoutId);
        workoutHasExercise.setExerciseId(exerciseId);
        workoutHasExerciseDao.insertAll(workoutHasExercise);
    }


}