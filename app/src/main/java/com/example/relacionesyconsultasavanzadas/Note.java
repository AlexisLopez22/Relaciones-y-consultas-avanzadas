package com.example.relacionesyconsultasavanzadas;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes",
        foreignKeys = @ForeignKey(entity = Category.class,
                parentColumns = "category_id", childColumns = "category_id", onDelete = ForeignKey.CASCADE))
public class Note {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    public int noteId;

    @ColumnInfo(name = "note_title")
    public String noteTitle;

    @ColumnInfo(name = "note_content")
    public String noteContent;

    @ColumnInfo(name = "created_at")
    public long createdAt;

    @ColumnInfo(name = "category_id")
    public int categoryId;

    public Note(String noteTitle, String noteContent, int categoryId) {
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
        this.categoryId = categoryId;
        this.createdAt = System.currentTimeMillis();
    }

    @Override public String toString() { return noteTitle + " - " + noteContent; }
}