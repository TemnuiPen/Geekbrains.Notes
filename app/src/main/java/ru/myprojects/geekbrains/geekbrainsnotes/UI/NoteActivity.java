package ru.myprojects.geekbrains.geekbrainsnotes.UI;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.myprojects.geekbrains.geekbrainsnotes.R;

public class NoteActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.fragment_note);

        //set arguments to fragment
        NoteFragment noteFragment = new NoteFragment();
        noteFragment.setArguments(getIntent().getExtras());
    }
}
