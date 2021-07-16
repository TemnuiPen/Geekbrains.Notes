package ru.myprojects.geekbrains.geekbrainsnotes.UI;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Note {
    String headline;
    String mainPart;
    NoteStatus status;
    String date;

    boolean favouriteListFlag = false;

    public Note(String headline, String mainPart, NoteStatus status, String date) {
        this.headline = headline;
        this.mainPart = mainPart;
        this.status = status;
        this.date = date;
    }

    public Note() {
        // empty slot
    }

    void checkLists(LinkedList<Note> allNotesList, LinkedList<Note> favouriteNotesList) {
        checkFullList(allNotesList, favouriteNotesList);
        checkFavouriteList(allNotesList, favouriteNotesList);
    }
    private void checkFullList(LinkedList<Note> allNotesList, LinkedList<Note> favouriteNotesList) {
        for (int i = 0; i < allNotesList.size(); i++) {
            favouriteListFlag = false;
            if(allNotesList.get(i).status.equals(NoteStatus.IS_IN_FAVOURITE)) {
                for (int j = 0; j < favouriteNotesList.size(); j++) {
                    if (allNotesList.get(i).equals(favouriteNotesList.get(j))) {
                        favouriteListFlag = true;
                        return;
                    }
                }
                if (!favouriteListFlag) {
                    favouriteNotesList.addFirst(allNotesList.get(i));
                }
            }
        }
    }

    private void checkFavouriteList
            (LinkedList<Note> allNotesList, LinkedList<Note> favouriteNotesList) {
        for (int i = 0; i < favouriteNotesList.size(); i++) {
            favouriteListFlag = false;
            for (int j = 0; j < allNotesList.size(); j++) {
                if (favouriteNotesList.get(i).equals(allNotesList.get(j))) {
                    favouriteListFlag = true;
                }
            }
            if (!favouriteListFlag) {
                allNotesList.addFirst(favouriteNotesList.get(i));
                favouriteListFlag = false;
            }
        }
    }
}
