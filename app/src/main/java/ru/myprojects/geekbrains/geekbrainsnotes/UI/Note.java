package ru.myprojects.geekbrains.geekbrainsnotes.UI;

public class Note {
    String headline;
    String mainPart;
    NoteStatus status;
    String date;

    public Note(String headline, String mainPart, NoteStatus status, String date) {
        this.headline = headline;
        this.mainPart = mainPart;
        this.status = status;
        this.date = date;
    }
}
