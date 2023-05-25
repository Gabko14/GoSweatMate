package ch.bbcag.gosweatmate.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

import ch.bbcag.gosweatmate.AddExerciseActivity;
import ch.bbcag.gosweatmate.R;

public class ExerciseGalleryAdapter extends RecyclerView.Adapter<AddExerciseActivity> {

    Context context;

    TextView textView = findViewById(R.id.exercises);


    @NonNull
    @Override
    public AddExerciseActivity onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AddExerciseActivity holder, int position) {

        TextView textView = findViewById(R.id.exercises);

        String url = "https://wger.de/api/v2/exercise/";
        RequestQueue queue = Volley.newRequestQueue(context);

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
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }


//                textView.setText(firstResult);
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
    public int getItemCount() {
        return 0;
    }
}

