package me.andyni;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NoteList implements Serializable {

    private static final long serialVersionUID = 5L;

    private List<Note> notes = new ArrayList<>();

    public void newNote(Note sourceNote) {
        Note note = new Note(sourceNote);
        notes.add(new Note());
        note.show();
    }

    public void newNote() {
        newNote(null);
    }

    public boolean openAll() {
        for (Note note : notes) {
            note.show();
        }
        return notes.size() > 0;
    }
}
