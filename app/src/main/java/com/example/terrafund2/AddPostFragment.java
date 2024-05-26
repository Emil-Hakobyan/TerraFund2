// AddPostFragment.java
package com.example.terrafund2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.fragment.app.DialogFragment;

public class AddPostFragment extends DialogFragment {

    private EditText editTextTitle, editTextDescription, editTextBudget;
    private SeekBar seekBarBudget;
    private Button buttonSave;

    public AddPostFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_post, container, false);

        editTextTitle = view.findViewById(R.id.edit_text_title);
        editTextDescription = view.findViewById(R.id.edit_text_description);
        editTextBudget = view.findViewById(R.id.edit_text_budget);
        seekBarBudget = view.findViewById(R.id.seek_bar_budget);

        buttonSave = view.findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePost();
            }
        });

        return view;
    }

    private void savePost() {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        String budget = editTextBudget.getText().toString();
        int progress = seekBarBudget.getProgress();

        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).addPost(title, description, budget, progress);
        }

        dismiss();
    }
}
