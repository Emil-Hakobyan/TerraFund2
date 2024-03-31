package com.example.terrafund2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class create extends Fragment {


    private TextInputLayout titleInputLayout, descriptionInputLayout;
    private Button createButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_create, container, false);

        titleInputLayout = view.findViewById(R.id.title_input);
        descriptionInputLayout = view.findViewById(R.id.description_input);
        createButton = view.findViewById(R.id.create_button);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleInputLayout.getEditText().getText().toString();
                String description = descriptionInputLayout.getEditText().getText().toString();

                // Pass announcement details to activity
                ((MainActivity) getActivity()).createAnnouncement(title, description);
            }
        });

        return view;
    }


}

