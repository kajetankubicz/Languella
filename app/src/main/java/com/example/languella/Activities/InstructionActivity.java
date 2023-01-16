package com.example.languella.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.languella.R;

/**
 * Aktywnosc dla instrukcji w menu
 * Level 1
 */
public class InstructionActivity extends AppCompatActivity {
    /** Atrybuty klasy */
    private Button buttonQuitInstruction;

    /**
     * Metoda wykonywana od razu po utworzeniu powierzchni
     * @param savedInstanceState umozliwia przywrocic stan gry po zakonczeniu aktywnosci
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intruction);

        buttonQuitInstruction = findViewById(R.id.buttonQuitInstruction);
        buttonQuitInstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivityMenu();
            }
        });
    }

    /**Metoda do otwierania nowej aktywnosci*/
    public void openActivityMenu(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}