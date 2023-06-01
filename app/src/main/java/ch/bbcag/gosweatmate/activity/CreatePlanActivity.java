package ch.bbcag.gosweatmate.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import ch.bbcag.gosweatmate.R;


public class CreatePlanActivity extends AppCompatActivity {

    private TextView textViewTest;
    private List<Integer> exerciseIds = new ArrayList();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_plan);

        textViewTest = findViewById(R.id.textView50);

        Intent currentIntent = getIntent();
        Bundle extras = currentIntent.getExtras();

        //Take all the extras that we got and put them into the new Intent so they dont get lost
        if (extras != null) {
            for (int i = 1; i < extras.size() + 1; i++) {
                if (extras.containsKey("ExerciseId" + i)) {
                    int exerciseId = extras.getInt("ExerciseId" + i);
                    exerciseIds.add(exerciseId);
                }
            }
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

                startActivity(newIntent);

            }
        });


    }

}