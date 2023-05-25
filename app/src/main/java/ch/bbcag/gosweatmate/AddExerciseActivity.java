package ch.bbcag.gosweatmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import ch.bbcag.gosweatmate.adapter.ExerciseGalleryAdapter;

public class AddExerciseActivity extends androidx.recyclerview.widget.RecyclerView.ViewHolder {

    TextView examName;
    TextView examMessage;
    TextView examDate;
    View view;

    AddExerciseActivity(View itemView) {
        super(itemView);
        examName = (TextView) itemView.findViewById(R.id.examName);
        examDate = (TextView) itemView.findViewById(R.id.examDate);
        examMessage = (TextView) itemView.findViewById(R.id.examMessage);

    }

    ExerciseGalleryAdapter adapter;
    RecyclerView recyclerView;


}