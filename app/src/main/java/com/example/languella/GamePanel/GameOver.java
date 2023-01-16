package com.example.languella.GamePanel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.content.ContextCompat;
import com.example.languella.*;

/**
 * Klasa sluzaca do wyswietlenia na ekranie tekstu o przegraniu
 */
public class GameOver {
    /** Atrybut klasy */
    private final Context context;

    /**
     * Konstruktor
     * @param context dostep do informacji o stanie aplikacji
     */
    public GameOver(Context context) {
        this.context = context;
    }

    /**
     * Metoda dzieki ktorej, wyswietlany jest teskt o przegranej i wyswietlenie informacji o przejsciu do menu glownego
     * @param canvas umozliwia rysowanie grafiki
     */
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.gameOver);
        paint.setColor(color);
        float textSize = 150;
        paint.setTextSize(textSize);
        canvas.drawText("GAME OVER", 625, 200,  paint);
        canvas.drawText("PROCEEDING TO MENU", 425, 400,  paint);
    }
}
