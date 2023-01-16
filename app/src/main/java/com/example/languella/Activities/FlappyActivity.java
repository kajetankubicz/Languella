package com.example.languella.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import com.example.languella.Game2.flyingCharacterLevel1;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Aktywnosc dla drugiej gry
 * Level 1
 */
public class FlappyActivity extends AppCompatActivity {
    /** Atrybuty klasy */
    private flyingCharacterLevel1 gameView;
    private Handler handler = new Handler();
    private final static long Interval = 30;

    /**
     * Metoda wykonywana od razu po utworzeniu powierzchni
     * @param savedInstanceState umozliwia przywrocic stan gry po zakonczeniu aktywnosci
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new flyingCharacterLevel1(this);
        setContentView(gameView);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        /** co 0.030 sekundy rysuje na nowo gameView */
                        gameView.invalidate();
                    }
                });
            }
        }, 0, Interval);
    }
}