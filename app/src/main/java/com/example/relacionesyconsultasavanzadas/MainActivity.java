package com.example.relacionesyconsultasavanzadas;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;
    Spinner spinner;
    ListView listView;
    EditText inputObj, etSearch;
    Category currentCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.get(this);
        inputObj = findViewById(R.id.inputObj);
        etSearch = findViewById(R.id.etSearch);
        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.listView);

        findViewById(R.id.btnAddCat).setOnClickListener(v -> {
            String txt = inputObj.getText().toString();
            if (!txt.isEmpty()) {
                db.dao().insertCategory(new Category(txt));
                inputObj.setText("");
                refreshCategories();
                Toast.makeText(this, "Categoría Guardada", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnAddNote).setOnClickListener(v -> {
            if (currentCategory == null) {
                Toast.makeText(this, "Selecciona una categoría", Toast.LENGTH_SHORT).show();
                return;
            }
            String txt = inputObj.getText().toString();
            if (!txt.isEmpty()) {
                db.dao().insertNote(new Note(txt, "", currentCategory.categoryId));
                inputObj.setText("");
                refreshNotes();
                Toast.makeText(this, "Nota Guardada", Toast.LENGTH_SHORT).show();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> p, View v, int pos, long id) {
                currentCategory = (Category) p.getItemAtPosition(pos);
                refreshNotes();
            }
            public void onNothingSelected(AdapterView<?> p) {}
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                List<Note> res = db.dao().searchNotes(s.toString());
                updateList(res);
            }
            public void beforeTextChanged(CharSequence s, int start, int c, int a) {}
            public void onTextChanged(CharSequence s, int start, int b, int c) {}
        });

        refreshCategories();
    }

    void refreshCategories() {
        List<Category> cats = db.dao().getAllCategories();
        if (cats == null) cats = new ArrayList<>();
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cats));
    }

    void refreshNotes() {
        if (currentCategory == null) return;
        List<Note> notes = db.dao().getNotesByCategory(currentCategory.categoryId);
        updateList(notes);
    }

    void updateList(List<Note> notes) {
        if (notes == null) notes = new ArrayList<>();
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes));
    }
}