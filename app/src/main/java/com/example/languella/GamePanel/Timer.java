package com.example.languella.GamePanel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.content.ContextCompat;
import com.example.languella.Game1.GameLoop;
import com.example.languella.*;
import java.text.DecimalFormat;

/**
 * Klasa ktora sluzy do wyswietlenia na ekranie czasu do konca gry
 */
public class Timer{
    /** Atrybuty klasy */
    private final Context context;
    float time;

    /**
     * Konstruktor - uzywany do umieszczenia tekstu z czasem gry
     * @param context dostep do informacji o stanie aplikacji
     */
    public Timer(Context context) {
        this.context = context;
    }

    /**
     * Rysowanie tekstu z czasem gry na ekranie
     * @param canvas umozliwia rysowanie grafiki
     */
    public void drawTimer(Canvas canvas) {
        DecimalFormat df = new DecimalFormat("##0");
        time = Integer.parseInt(df.format((Math.round(GameLoop.getTime() * 100.0) / 100000.0)));
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.magenta);
        paint.setColor(color );
        paint.setTextSize(50);
        canvas.drawText("Czas: "+ time, 100, 300, paint);
    }

    /**
     * Pobranie czasu z klasy GameLoop gdzie jest metoda z timerem
     * @return zwraca czas do konca gry
     */
    public int getTime() {
        return (int) time;
    }

}
