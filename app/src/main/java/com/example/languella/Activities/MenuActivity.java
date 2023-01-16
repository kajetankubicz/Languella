package com.example.languella.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.languella.R;

/**
 * Aktywnosc dla menu glownego
 */
public class MenuActivity extends AppCompatActivity {
    /** Atrybuty klasy */
    private Button buttonStart;
    private Button buttonQuit;
    private Button buttonInstruction;

    /**
     * Metoda wykonywana od razu po utworzeniu powierzchni
     * @param savedInstanceState umozliwia przywrocic stan gry po zakonczeniu aktywnosci
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buttonStart = findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        buttonInstruction = findViewById(R.id.buttonInstruction);
        buttonInstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivityInstruction();
            }
        });

        buttonQuit = findViewById(R.id.buttonQuit);
        buttonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

    /**Metoda do otwierania nowej aktywnosci*/
    public void openActivityInstruction(){
        Intent intent = new Intent(this, InstructionActivity.class);
        startActivity(intent);
    }

}