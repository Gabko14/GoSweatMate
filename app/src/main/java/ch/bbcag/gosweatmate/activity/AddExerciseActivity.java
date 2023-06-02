package ch.bbcag.gosweatmate.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

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
import ch.bbcag.gosweatmate.helper.ExerciseModelStorage;
import ch.bbcag.gosweatmate.helper.SelectListener;

public class AddExerciseActivity extends AppCompatActivity implements SelectListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<ExerciseModelStorage> exerciseModels = new ArrayList<>();


        String url = "https://wger.de/api/v2/exercise/?format=json&limit=80&offset=0&language=2";
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


                JSONArray resultsJsonArray;
                try {
                    resultsJsonArray = jsonResponse.getJSONArray("results");
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


                for (int i = 0; i < resultsJsonArray.length(); i++) {
                    try {
                        JSONObject exerciseObject = resultsJsonArray.getJSONObject(i);


                        ExerciseModelStorage currentModel = new ExerciseModelStorage(exerciseObject.getString("name"), exerciseObject.getInt("id"));
                        exerciseModels.add(currentModel);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }


                myAdapter = new AddExerciseGalleryAdapter(AddExerciseActivity.this, exerciseModels, AddExerciseActivity.this);
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


    @Override
    public void onItemClicked(ExerciseModelStorage exerciseModelStorage) {


        Intent newIntent = new Intent(getApplicationContext(), CreatePlanActivity.class);
        Intent currentIntent = getIntent();

        Bundle extras = currentIntent.getExtras();

        //Take all the extras that we got and put them into the new Intent so they dont get lost
        if (extras != null) {
            for (int i = 1; i < extras.size() + 1; i++) {
                if (extras.containsKey("ExerciseId" + i)) {
                    newIntent.putExtra("ExerciseId" + i, extras.getInt("ExerciseId" + i));
                }
            }
            newIntent.putExtra("ExerciseId" + (extras.size() + 1), exerciseModelStorage.getId());
        } else {
            newIntent.putExtra("ExerciseId" + 1, exerciseModelStorage.getId());
        }

        startActivity(newIntent);

    }


}