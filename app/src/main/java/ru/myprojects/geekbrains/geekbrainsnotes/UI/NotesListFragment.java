package ru.myprojects.geekbrains.geekbrainsnotes.UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Collections;
import java.util.LinkedList;

import ru.myprojects.geekbrains.geekbrainsnotes.R;
import ru.myprojects.geekbrains.geekbrainsnotes.UI.Note;

public class NotesListFragment extends Fragment {
    EditText searchForNotes;
    ImageButton settings;
    RecyclerView recyclerView;

    String keyIndex = "Index";
    String keyTitle = "Title";
    String keyMainPart = "MainPart";
    String keyStatus = "Status";
    String keyDate = "Date";

    ItemAdapter adapterForFullList = null;

    Note note;

    public NotesListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        note = new Note();
        return inflater.inflate(R.layout.fragment_notes_list, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        note.checkLists(allNotesList, favouriteNotesList);
    }

    private void initView(View view) {
        searchForNotes = view.findViewById(R.id.search_notes);
        settings = view.findViewById(R.id.btn_settings);
        recyclerView = view.findViewById(R.id.note_list_recyclerView);
        initAdapter();
    }

    private void initAdapter() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapterForFullList = new ItemAdapter(allNotesList);
        recyclerView.setAdapter(adapterForFullList);

        adapterForFullList.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(),NoteActivity.class);
                intent.putExtra(keyIndex, position);
                intent.putExtra(keyTitle,allNotesList.get(position).headline);
                intent.putExtra(keyMainPart,allNotesList.get(position).mainPart);
                intent.putExtra(keyStatus,allNotesList.get(position).status);
                intent.putExtra(keyDate,allNotesList.get(position).date);
                startActivity(intent);
            }
        });
    }
    LinkedList<Note> allNotesList = new LinkedList<>(Collections.singletonList
            (new Note("Hello world", "Hello world!!",
                    NoteStatus.IS_NOT_IN_FAVOURITE, "today")));

    LinkedList<Note> favouriteNotesList = new LinkedList<>(Collections.singletonList
            (new Note("Hello favourites!", "Hello favourites!!",
                    NoteStatus.IS_IN_FAVOURITE, "tonight")));

}