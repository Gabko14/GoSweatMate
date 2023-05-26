package ch.bbcag.gosweatmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
        for (int i = 0; i < 100; i++) {
            input.add("Test" + i);
        }// define an adapter
        mAdapter = new ExerciseGalleryAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }


//    AddExerciseActivity(View itemView) {
//        super(itemView);
//        nameView = itemView.findViewById(R.id.exercises);
//
//
//    }




}