package ch.bbcag.gosweatmate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import ch.bbcag.gosweatmate.R;
import ch.bbcag.gosweatmate.helper.ExerciseModelStorage;

public class PlanDetailsAdapter extends RecyclerView.Adapter<PlanDetailsAdapter.ViewHolder> {
    private final List<Integer> exerciseIds;
    Context context;

    public PlanDetailsAdapter(List<Integer> exerciseIds, Context context) {
        this.exerciseIds = exerciseIds;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public ImageView imageView;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            imageView = (ImageView) v.findViewById(R.id.icon);
        }
    }

    public void add(int position, int item) {
        exerciseIds.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        exerciseIds.remove(position);
        notifyItemRemoved(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout_plan_details, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final Integer currentxerciseId = exerciseIds.get(position);

        String url = "https://wger.de/api/v2/exerciseinfo/" + currentxerciseId + "/?format=json";
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
                try {
                    System.out.println(jsonResponse.getString("name"));
                    holder.txtHeader.setText(jsonResponse.getString("name"));


                    try {
                        JSONArray imagesJsonArray = jsonResponse.getJSONArray("images");
                        if (!imagesJsonArray.isNull(0)) {
                            JSONObject imageObject = imagesJsonArray.getJSONObject(0);
                            if (imageObject.getString("image") != "" && imageObject.getString("image") != null) {
                                Picasso.get().load(imageObject.getString("image")).into(holder.imageView);
                            }

                        }
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


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
        return exerciseIds.size();
    }


}

