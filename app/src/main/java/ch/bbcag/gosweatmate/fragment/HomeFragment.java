package ch.bbcag.gosweatmate.fragment;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.util.List;

import ch.bbcag.gosweatmate.R;
import ch.bbcag.gosweatmate.dal.dao.WorkoutDao;
import ch.bbcag.gosweatmate.dal.database.AppDatabase;
import ch.bbcag.gosweatmate.dal.entities.Workout;
import ch.bbcag.gosweatmate.activity.CreatePlanActivity;

public class HomeFragment extends Fragment {

    private WorkoutDao workoutDao;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);


        Button createWorkoutButton = view.findViewById(R.id.createWorkouButton);
        createWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreatePlanActivity.class);

                startActivity(intent);
            }
        });

        workoutDao = AppDatabase.getInstance(getContext()).getWorkoutDao();


        insertWorkout("Push Workout 1.");
        insertWorkout("Pull Workout 2.");
        insertWorkout("Legs Workout 3.");

        List<Workout> allWorkouts = workoutDao.getAll();

        LinearLayout mainLinearLayout = view.findViewById(R.id.homeMainLinearLayout);

        for (Workout workout : allWorkouts) {
            Button btnTag = new Button(getContext());

            //To calculated the dps into pixels because it's only possible to set height in pixels
            Integer dpsHeight = 75;
            final float scale = getContext().getResources().getDisplayMetrics().density;
            int pixelsHeight = (int) (dpsHeight * scale + 0.5f);

            btnTag.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, pixelsHeight));
            btnTag.setText(workout.getName());
            btnTag.getBackground().setColorFilter(new BlendModeColorFilter(0xFFFFFFFF, BlendMode.MULTIPLY));
            btnTag.setTextColor(getResources().getColor(R.color.grey));


//            btnTag.setTextColor(R.color.white);

            mainLinearLayout.addView(btnTag);

            workoutDao.delete(workout);
        }


        return view;
    }

    private void insertWorkout(String workoutName) {
        Workout newWorkout = new Workout();

        newWorkout.setName(workoutName);
        workoutDao.insertAll(newWorkout);
    }
}
