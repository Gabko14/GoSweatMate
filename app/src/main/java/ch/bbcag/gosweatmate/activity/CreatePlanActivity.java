package ch.bbcag.gosweatmate.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import ch.bbcag.gosweatmate.R;

public class CreatePlanActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_plan);


//        ActionBar actionBar = activity.getSupportActionBar();

        Button addExercise = findViewById(R.id.AddExerciseButton);
        addExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), AddExerciseActivity.class);

                startActivity(intent);


            }
        });


    }

}