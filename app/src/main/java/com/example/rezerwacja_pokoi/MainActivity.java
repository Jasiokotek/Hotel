package com.example.rezerwacja_pokoi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.rezerwacja_pokoi.R;
import com.example.rezerwacja_pokoi.SummaryActivity;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "EXTRA_NAME";
    public static final String EXTRA_DAYS = "EXTRA_DAYS";
    public static final String EXTRA_BREAKFAST = "EXTRA_BREAKFAST";

    private EditText editTextName;
    private EditText editTextDays;
    private CheckBox checkBoxBreakfast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editTextName = findViewById(R.id.editTextName);
        editTextDays = findViewById(R.id.editTextDays);
        checkBoxBreakfast = findViewById(R.id.checkBoxBreakfast);
        Button buttonNext = findViewById(R.id.buttonNext);

        buttonNext.setOnClickListener(v -> openSummary());
    }
    private void openSummary() {

        String name = editTextName.getText().toString().trim();
        String roomsText = editTextDays.getText().toString().trim();

        if (name.isEmpty()) {
            editTextName.setError("Podaj imię i nazwisko");
            return;
        }

        if (roomsText.isEmpty()) {
            editTextDays.setError("Podaj ilość pokoi");
            return;
        }

        int rooms = Integer.parseInt(roomsText);
        boolean breakfast = checkBoxBreakfast.isChecked();

        Intent intent = new Intent(this, SummaryActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_DAYS, rooms);
        intent.putExtra(EXTRA_BREAKFAST, breakfast);
        startActivity(intent);
    }
}