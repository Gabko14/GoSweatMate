package ch.bbcag.gosweatmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import ch.bbcag.gosweatmate.fragment.ExploreFragment;
import ch.bbcag.gosweatmate.fragment.CreatePlanFragment;
import ch.bbcag.gosweatmate.fragment.HistoryFragment;
import ch.bbcag.gosweatmate.fragment.HomeFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                Fragment selectedFragment = null;
                if (itemId == R.id.navigation_home) {
                    selectedFragment = HomeFragment.newInstance();
                } else if (itemId == R.id.navigation_explore) {
                    selectedFragment = ExploreFragment.newInstance();
                } else if (itemId == R.id.navigation_history) {
                    selectedFragment = HistoryFragment.newInstance();
                } else {
                    selectedFragment = HomeFragment.newInstance();
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, selectedFragment);
                transaction.commit();
                return true;
            }
        });
        if (savedInstanceState == null) {
//Manually displaying the first fragment - one time only
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, HomeFragment.newInstance());
            transaction.commit();
        }



    }

}