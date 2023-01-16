package com.example.languella.GamePanel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.content.ContextCompat;
import com.example.languella.*;

/**
 * Klasa z przyciskiem do wznawiania gry
 */
public class ResumeButton {
    /** Atrybuty klasy */
    private final Context context;

    /**
     * Konstruktor - uzywany do umieszczenia tekstu z wznowieniem gry
     * @param context dostep do informacji o stanie aplikacji
     */
    public ResumeButton(Context context) {
        this.context = context;
    }

    /**
     * Rysowanie tekstu z wznowieniem gry na ekranie
     * @param canvas umozliwia rysowanie grafiki
     */
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.spell);
        paint.setColor(color);
        float textSize = 50;
        paint.setTextSize(textSize);
        canvas.drawText("RESUME", 1600, 100,  paint);
    }

    /**
     * Metoda ktora sprawdza czy gracz dotknal tekstu z wznowieniem gry
     * @param touchPositionX zwracanie gdzie na ekranie doszlo do zderzenia na osi x
     * @param touchPositionY zwracanie gdzie na ekranie doszlo do zderzenia na osi y
     * @return jesli gracz dotknal w odpowiednim miejscu to zwraca prawde, jesli nie do zwraca falsz
     */
    public static boolean isPressed(double touchPositionX, double touchPositionY) {
        if( ( touchPositionX >= 1400 && touchPositionX <= 1800 )&& ( touchPositionY >= 0 && touchPositionY <= 450 )){
            return true;
        }else{
            return false;
        }
    }
}
