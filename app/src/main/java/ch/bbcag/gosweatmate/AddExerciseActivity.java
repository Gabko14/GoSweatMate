package ch.bbcag.gosweatmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

import ch.bbcag.gosweatmate.adapter.ExerciseGalleryAdapter;

public class AddExerciseActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<String> input = new ArrayList<>();


        String url = "https://wger.de/api/v2/exercise/";
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

                int id;
                String name;
                String resultsJsonArrayString = resultsJsonArray.toString();
                JSONArray array = null;
                try {
                    array = new JSONArray(resultsJsonArrayString);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                for (int i = 0; i < array.length(); i++) {
                    JSONObject row = null;
                    try {
                        row = array.getJSONObject(i);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        id = row.getInt("id");
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        name = row.getString("name");
                        input.add(name);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
                mAdapter = new ExerciseGalleryAdapter(input);
                recyclerView.setAdapter(mAdapter);

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