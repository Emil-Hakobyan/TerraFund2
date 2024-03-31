package com.example.terrafund2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.terrafund2.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private home homeFragment;
    private profile profileFragment;
    private create create;
    private LinearLayout cardContainer;
    private Button addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new home();
        profileFragment = new profile();
        create = new create();



        getSupportFragmentManager().beginTransaction()
                .replace(R.id.cont, homeFragment)
                .commit();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;

        if (item.getItemId() == R.id.navigation_home) {
            selectedFragment = homeFragment;
        } else if (item.getItemId() == R.id.navigation_profile) {
            selectedFragment = profileFragment;
        } else if (item.getItemId() == R.id.add) {
            selectedFragment = create;
        }

        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.cont, selectedFragment)
                    .commit();
            return true;
        }
        return false;
    }

    public void createAnnouncement(String title, String description) {
        // Create a new CardView
        CardView cardView = new CardView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(0, 16, 0, 0);
        cardView.setLayoutParams(layoutParams);
        cardView.setContentPadding(16, 16, 16, 16);
        cardView.setCardBackgroundColor(getResources().getColor(android.R.color.white));
        cardView.setRadius(16);

        // Create TextViews for title and description
        TextView titleTextView = new TextView(this);
        titleTextView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        titleTextView.setText(title);
        titleTextView.setTextSize(18);

        TextView descriptionTextView = new TextView(this);
        descriptionTextView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        descriptionTextView.setText(description);

        cardView.addView(titleTextView);
        cardView.addView(descriptionTextView);

        cardContainer.addView(cardView);
    }

}
