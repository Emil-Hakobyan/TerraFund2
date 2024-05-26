package com.example.terrafund2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.terrafund2.R;

public class DescriptionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Post post = (Post) getIntent().getSerializableExtra("post");

        // Find your views
        TextView textViewTitle = findViewById(R.id.title);
        TextView textViewDescription = findViewById(R.id.description);

        // Populate your views with the post data
        textViewTitle.setText(post.getTitle());
        textViewDescription.setText(post.getDescription());

    }
}