package com.example.languella.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.example.languella.Game1.Game;

/**
 * Aktywnosc dla pierwszej gry
 */
public class MainActivity extends AppCompatActivity {
    /** Atrybuty klasy */
    private Game game;

    /**
     * Metoda wykonywana od razu po utworzeniu powierzchni
     * @param savedInstanceState umozliwia przywrocic stan gry po zakonczeniu aktywnosci
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainActivity.java", "onCreate()");
        super.onCreate(savedInstanceState);

        /** Ustawienie okna gry na pelny ekran*/
        Window windows = getWindow();
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        game = new Game(this);

        /** Ustawienie zawartosci gry na klase Game, by obiekty z Game się wyswietlaly*/
        setContentView(new Game(this));
    }
}