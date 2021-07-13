package ru.myprojects.geekbrains.geekbrainsnotes;

public class Note {
    String headline;
    String mainPart;
    NoteStatus status;
    int date;

    public Note(String headline, String mainPart, NoteStatus status, int date) {
        this.headline = headline;
        this.mainPart = mainPart;
        this.status = status;
        this.date = date;
    }
}
