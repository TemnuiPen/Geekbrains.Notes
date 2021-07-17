package ru.myprojects.geekbrains.geekbrainsnotes.UI;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Collections;
import java.util.LinkedList;

import ru.myprojects.geekbrains.geekbrainsnotes.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteFragment extends Fragment implements View.OnClickListener {

    ImageButton btnBack;
    ImageButton btnConfirm;
    EditText noteHeadline;
    EditText noteTextBody;

    String keyIndex = "Index";
    String keyTitle = "Title";
    String keyMainPart = "MainPart";
    String keyStatus = "Status";
    String keyDate = "Date";

    String headline;
    String mainPart;
    String date;
    NoteStatus favouriteStatus;
    int index;

    NoteStatus editTextStatus;

    NotesListFragment notesListFragment;
    LinkedList<Note> newNote;
    Intent intent;

    public NoteFragment() {
        // Required empty public constructor
    }

    public static NoteFragment newInstance(int index, String headline, String mainPart,
                                           boolean status, String date) {
        NoteFragment fragment = new NoteFragment();
        Bundle arg = new Bundle();
        arg.putInt(fragment.keyIndex, index);
        arg.putString(fragment.keyTitle, headline);
        arg.putString(fragment.keyMainPart, mainPart);
        arg.putBoolean(fragment.keyStatus, status);
        arg.putString(fragment.keyDate, date);
        fragment.setArguments(arg);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean boolStatus;
        if(getArguments() != null) {
            headline = getArguments().getString(keyTitle);
            mainPart = getArguments().getString(keyMainPart);
            boolStatus = getArguments().getBoolean(keyStatus);
            favouriteStatus = toNoteStatus(boolStatus);
            date = getArguments().getString(keyDate);
            index = getArguments().getInt(keyIndex);
        }
    }

    private NoteStatus toNoteStatus(boolean status) {
        NoteStatus noteStatus = NoteStatus.IS_NOT_IN_FAVOURITE;
        if(status) {
            noteStatus = NoteStatus.IS_IN_FAVOURITE;
        }
        return noteStatus;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        checkStatus();
    }

    private void initView(View view) {
        btnBack = view.findViewById(R.id.btn_back);
        btnConfirm = view.findViewById(R.id.btn_confirm);
        noteHeadline = view.findViewById(R.id.headline_editText);
        noteTextBody = view.findViewById(R.id.note_text_body);

        btnBack.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);

    }


    private void checkStatus() {
        if (headline != null && mainPart != null) {
            noteHeadline.setText(headline);
            noteTextBody.setText(mainPart);

            if(noteHeadline == null && noteTextBody == null) {
                editTextStatus = NoteStatus.IS_EMPTY;
            }
            else editTextStatus = NoteStatus.IS_NOT_EMPTY;
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_back:
                //will be finished
            case R.id.btn_confirm:
                newNote = new LinkedList<>(Collections.singletonList(new Note
                        (noteHeadline.getText().toString(),noteTextBody.getText().toString(),
                                NoteStatus.IS_NOT_IN_FAVOURITE,"today")));
                notesListFragment.allNotesList.addAll(newNote);
        }
    }
}