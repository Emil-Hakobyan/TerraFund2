// MainActivity.java
package com.example.terrafund2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private AddPostFragment addPostFragment = new AddPostFragment();
    private home homeFragment = new home();
    private profile profileFragment = new profile();
    private FloatingActionButton addButton;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        addButton = findViewById(R.id.floatingActionButton);

        // Set default fragment
        loadFragment(homeFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    loadFragment(homeFragment);
                    return true;
                } else if (item.getItemId() == R.id.profile) {
                    loadFragment(profileFragment);
                    return true;
                }
                return false;
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(addPostFragment);
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    // Method to add a new post
    public void addPost(String title, String description, String budget, int progress) {
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("posts").child(userId);
        String postId = databaseReference.push().getKey();
        Post post = new Post(postId, userId, title, description, budget, progress);

        databaseReference.child(postId).setValue(post);
        Toast.makeText(this, "Post added successfully", Toast.LENGTH_SHORT).show();

        // After adding the post, switch back to the HomeFragment
        loadFragment(homeFragment);
    }
}
