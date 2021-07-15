package ru.myprojects.geekbrains.geekbrainsnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Collections;
import java.util.LinkedList;

import ru.myprojects.geekbrains.geekbrainsnotes.UI.Note;
import ru.myprojects.geekbrains.geekbrainsnotes.UI.NoteStatus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}