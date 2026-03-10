package com.example.rezerwacja_pokoi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.rezerwacja_pokoi.R;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_summary);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView textViewSummary = findViewById(R.id.textViewSummary);

        Intent intent = getIntent();

        String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
        int days = intent.getIntExtra(MainActivity.EXTRA_DAYS, 0);
        boolean breakfast = intent.getBooleanExtra(MainActivity.EXTRA_BREAKFAST, false);

        String breakfastText = breakfast ? "Tak" : "Nie";
        int cena = days * 250;
        if(breakfast) cena += days * 50;
        
        String summary = "Rezerwacja:\n\n"
                + "Imię i nazwisko: " + name + "\n"
                + "Ilość dni: " + days + "\n"
                + "Śniadanie: " + breakfastText + "\n"
                + "Cena: " + cena + "zł";

        textViewSummary.setText(summary);
    }
}