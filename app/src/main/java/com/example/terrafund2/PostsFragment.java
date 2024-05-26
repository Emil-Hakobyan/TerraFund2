package com.example.terrafund2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PostsFragment extends Fragment {

    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private List<Post> postList = new ArrayList<>();
    private TextView textViewNoPosts;

    public PostsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posts, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        textViewNoPosts = view.findViewById(R.id.text_view_no_posts);

        // Initialize RecyclerView and adapter
        adapter = new PostAdapter(getContext(), postList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        // Check if there are no posts to display
        if (postList.isEmpty()) {
            textViewNoPosts.setVisibility(View.VISIBLE);
        } else {
            textViewNoPosts.setVisibility(View.GONE);
        }

        return view;
    }

    // Method to add a new post
    public void addPost(Post post) {
        // Add the post to the list of posts
        postList.add(post);
        // Notify the adapter that the data set has changed
        adapter.notifyDataSetChanged();

        // Hide the "No posts available" message
        textViewNoPosts.setVisibility(View.GONE);
    }
}
