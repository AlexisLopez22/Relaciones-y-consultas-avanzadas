package com.example.relacionesyconsultasavanzadas;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface AppDao {
    @Insert
    void insertCategory(Category category);

    @Insert
    void insertNote(Note note);

    @Query("SELECT * FROM categories")
    List<Category> getAllCategories();

    @Query("SELECT * FROM notes WHERE category_id = :id")
    List<Note> getNotesByCategory(int id);

    @Query("SELECT * FROM notes WHERE note_title LIKE '%' || :search || '%' OR note_content LIKE '%' || :search || '%'")
    List<Note> searchNotes(String search);
}