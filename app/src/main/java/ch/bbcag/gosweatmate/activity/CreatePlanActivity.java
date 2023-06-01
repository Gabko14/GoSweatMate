package ch.bbcag.gosweatmate.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ch.bbcag.gosweatmate.R;


public class CreatePlanActivity extends AppCompatActivity {

    private TextView textViewTest;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_plan);

        textViewTest = findViewById(R.id.textView50);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {
            if (extras.containsKey("ExerciseIds")) {
                int exerciseId = extras.getInt("ExerciseIds");

                textViewTest.setText(String.valueOf(exerciseId));
            }
        }



    Button addExercise = findViewById(R.id.AddExerciseButton);
        addExercise.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){

        Intent intent = new Intent(getApplicationContext(), AddExerciseActivity.class);

        startActivity(intent);


    }
    });


}

}