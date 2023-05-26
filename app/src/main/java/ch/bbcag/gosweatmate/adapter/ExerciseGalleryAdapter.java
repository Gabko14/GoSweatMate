package ch.bbcag.gosweatmate.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
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

import java.util.List;

import ch.bbcag.gosweatmate.AddExerciseActivity;
import ch.bbcag.gosweatmate.R;

public class ExerciseGalleryAdapter extends RecyclerView.Adapter<ExerciseGalleryAdapter.ViewHolder> {
    private List<String> values;
    Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;
        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }
    }
    public void add(int position, String item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public ExerciseGalleryAdapter(List<String> myDataset){
        values = myDataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final String name = values.get(position);
        holder.txtHeader.setText(name);

        holder.txtFooter.setText("Footer: " + name);


//        String url = "https://wger.de/api/v2/exercise/";
//        RequestQueue queue = Volley.newRequestQueue(context);
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                JSONObject jsonResponse;
//                try {
//                    jsonResponse = new JSONObject(response);
//
//                } catch (JSONException e) {
//                    throw new RuntimeException(e);
//                }
//
//                JSONArray resultsJsonArray;
//                try {
//                    resultsJsonArray = jsonResponse.getJSONArray("results");
//                } catch (JSONException e) {
//                    throw new RuntimeException(e);
//                }
//
//                int id;
//                String name;
//                String resultsJsonArrayString = resultsJsonArray.toString();
//                JSONArray array = null;
//                try {
//                    array = new JSONArray(resultsJsonArrayString);
//                } catch (JSONException e) {
//                    throw new RuntimeException(e);
//                }
//                for (int i = 0; i < array.length(); i++) {
//                    JSONObject row = null;
//                    try {
//                        row = array.getJSONObject(i);
//                    } catch (JSONException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        id = row.getInt("id");
//                    } catch (JSONException e) {
//                        throw new RuntimeException(e);
//                    }
//                    try {
//                        name = row.getString("name");
//                    } catch (JSONException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                // Handle error
//            }
//        });
//        queue.add(stringRequest);
    }



    @Override
    public int getItemCount() {
        return values.size();
    }


}

