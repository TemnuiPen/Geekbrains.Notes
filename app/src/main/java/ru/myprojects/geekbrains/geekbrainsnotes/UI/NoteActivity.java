package ru.myprojects.geekbrains.geekbrainsnotes.UI;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.myprojects.geekbrains.geekbrainsnotes.R;

public class NoteActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_activity);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            //set arguments to fragment
            NoteFragment noteFragment = new NoteFragment();
            noteFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.note_container, noteFragment).commit();
        }
        else {
            finish();
        }

    }
}
