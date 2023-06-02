package ch.bbcag.gosweatmate.fragment;

import android.content.Intent;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ch.bbcag.gosweatmate.R;
import ch.bbcag.gosweatmate.activity.PlanDetailsActivity;
import ch.bbcag.gosweatmate.dal.dao.LogDao;
import ch.bbcag.gosweatmate.dal.dao.WorkoutDao;
import ch.bbcag.gosweatmate.dal.dao.WorkoutHasExerciseDao;
import ch.bbcag.gosweatmate.dal.database.AppDatabase;
import ch.bbcag.gosweatmate.dal.entities.Log;
import ch.bbcag.gosweatmate.dal.entities.Workout;

public class HistoryFragment extends Fragment {

    private LogDao logDao;
    private WorkoutDao workoutDao;

    public static HistoryFragment newInstance() {
        HistoryFragment fragment = new HistoryFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history, container, false);

        logDao = AppDatabase.getInstance(getContext()).getLogDao();
        workoutDao = AppDatabase.getInstance(getContext()).getWorkoutDao();


//        insertWorkout("Push Workout 1.");
//        insertWorkout("Pull Workout 2.");
//        insertWorkout("Legs Workout 3.");
////
//        insertExerciseIntoWorkout(1, 345);
//        insertExerciseIntoWorkout(1, 2056);



        List<Log> allLogs = logDao.getAll();
        Collections.reverse(allLogs);

        LinearLayout mainLinearLayout = view.findViewById(R.id.homeMainLinearLayout);

        for (Log log : allLogs) {
            Button btnTag = new Button(getContext());

            //To calculated the dps into pixels because it's only possible to set height in pixels
            int dpsHeight = 75;
            final float scale = requireContext().getResources().getDisplayMetrics().density;
            int pixelsHeight = (int) (dpsHeight * scale + 0.5f);

            btnTag.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, pixelsHeight));
            btnTag.setText("Date: " + log.getDate() + "\nWorkout: " + workoutDao.getById((int) log.getWorkoutId()).getName());
            btnTag.getBackground().setColorFilter(new BlendModeColorFilter(0xFFFFFFFF, BlendMode.MULTIPLY));
            btnTag.setTextColor(getResources().getColor(R.color.grey));

            mainLinearLayout.addView(btnTag);
        }


        return view;
    }


}

