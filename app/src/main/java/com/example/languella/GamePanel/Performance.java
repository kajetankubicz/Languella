package com.example.languella.GamePanel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.content.ContextCompat;
import com.example.languella.Game1.GameLoop;
import com.example.languella.*;

/**
 * Klasa sluzaca do wyswietlenia na ekranie FPS'ow i UPS'ow
 */
public class Performance {
    /** Atrybuty klasy */
    private final GameLoop gameLoop;
    private final Context context;

    /**
     * Konstruktor - uzywany do umieszczenia tekstu z informacja o FPS i UPS
     * @param gameLoop dostep do informacji o FPS i UPS z GameLoopa
     * @param context dostep do informacji o stanie aplikacji
     */
    public Performance(GameLoop gameLoop, Context context) {
        this.gameLoop = gameLoop;
        this.context = context;
    }

    /**
     * Rysowanie tekstu z UPS i FPS na ekranie
     * @param canvas umozliwia rysowanie grafiki
     */
    public void draw(Canvas canvas){
        drawUPS(canvas);
        drawFPS(canvas);
    }

    /**
     * Rysowanie tekstu z UPS na ekranie
     * @param canvas umozliwia rysowanie grafiki
     */
    public void drawUPS(Canvas canvas){
        String averageUPS = Double.toString(gameLoop.getAverageUPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context , R.color.magenta);
        paint.setColor(color );
        paint.setTextSize(50);
        canvas.drawText("UPS: "+averageUPS, 100, 100, paint);
    }

    /**
     * Rysowanie tekstu z FPS na ekranie
     * @param canvas umozliwia rysowanie grafiki
     */
    public void drawFPS(Canvas canvas){
        String averageFPS = Double.toString(gameLoop.getAverageFPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.magenta);
        paint.setColor(color );
        paint.setTextSize(50);
        canvas.drawText("FPS: "+averageFPS, 100, 200, paint);
    }

}
