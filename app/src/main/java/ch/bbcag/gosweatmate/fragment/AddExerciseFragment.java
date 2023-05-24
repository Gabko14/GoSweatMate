package ch.bbcag.gosweatmate.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import ch.bbcag.gosweatmate.R;

public class AddExerciseFragment extends Fragment {
    public static AddExerciseFragment newInstance() {
        AddExerciseFragment fragment = new AddExerciseFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View result = inflater.inflate(R.layout.activity_add_exercise, container, false);
        AppCompatActivity activity = (AppCompatActivity)getActivity();
        ActionBar actionBar = activity.getSupportActionBar();
        return result;
    }
}