package com.example.languella.GamePanel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.content.ContextCompat;
import com.example.languella.*;

/**
 * Klasa z przyciskiem do wyjscia do menu glownego
 */
public class QuitButton {
    /** Atrybuty klasy */
    private final Context context;

    /**
     * Konstruktor - uzywany do umieszczenia tekstu z wyjsciem do menu glownego
     * @param context dostep do informacji o stanie aplikacji
     */
    public QuitButton(Context context) {
        this.context = context;
    }

    /**
     * Rysowanie tekstu z wyjsciem do menu glownego dla klasy Game
     * @param canvas umozliwia rysowanie grafiki
     */
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.spell);
        paint.setColor(color);
        float textSize = 50;
        paint.setTextSize(textSize);
        canvas.drawText("QUIT", 1950, 1000,  paint);
    }

    /**
     * Rysowanie tekstu z wyjsciem do menu glownego dla klasy flyingCharacterLevel1 i flyingCharacterLevel2
     * @param canvas umozliwia rysowanie grafiki
     */
    public void drawFlappy(Canvas canvas) {
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.spell);
        paint.setColor(color);
        float textSize = 50;
        paint.setTextSize(textSize);
        canvas.drawText("QUIT", 900, 2000,  paint);
    }

    /**
     * Metoda ktora sprawdza czy gracz dotknal tekstu z wyjsciem do menu glownego dla klasy Game
     * @param touchPositionX zwracanie gdzie na ekranie doszlo do zderzenia na osi x
     * @param touchPositionY zwracanie gdzie na ekranie doszlo do zderzenia na osi y
     * @return jesli gracz dotknal w odpowiednim miejscu to zwraca prawde, jesli nie do zwraca falsz
     */
    public static boolean isPressed(double touchPositionX, double touchPositionY) {
        if( ( touchPositionX >= 1750 && touchPositionX <= 2050 )&& ( touchPositionY >= 900 && touchPositionY <= 1100 )){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metoda ktora sprawdza czy gracz dotknal tekstu z wyjsciem do menu glownego dla klasy flyingCharacterLevel1 i flyingCharacterLevel2
     * @param touchPositionX zwracanie gdzie na ekranie doszlo do zderzenia na osi x
     * @param touchPositionY zwracanie gdzie na ekranie doszlo do zderzenia na osi y
     * @return jesli gracz dotknal w odpowiednim miejscu to zwraca prawde, jesli nie do zwraca falsz
     */
    public static boolean isPressedFlappy(double touchPositionX, double touchPositionY) {
        if( ( touchPositionX >= 700 && touchPositionX <= 1100 )&& ( touchPositionY >= 1900 && touchPositionY <= 2100 )){
            return true;
        }else{
            return false;
        }
    }
}
