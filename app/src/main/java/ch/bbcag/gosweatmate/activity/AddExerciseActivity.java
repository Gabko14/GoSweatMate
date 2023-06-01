package ch.bbcag.gosweatmate.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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

public class AddExerciseActivity extends AppCompatActivity {

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

        List<ExerciseModelStorage> input = new ArrayList<>();


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
                        int id = exerciseObject.getInt("id");

                        ExerciseModelStorage currentModel = new ExerciseModelStorage(exerciseObject.getString("name"), exerciseObject.getInt("id"));
                        input.add(currentModel);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }

                myAdapter = new AddExerciseGalleryAdapter(input);
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


}