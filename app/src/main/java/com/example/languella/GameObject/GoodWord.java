package com.example.languella.GameObject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.content.ContextCompat;
import com.example.languella.*;

/**
 * Klasa z dobrym okregiem
 */
public class GoodWord extends Circle{
    /** Atrybuty klasy */
    Player player;
    private final Context context;

    /**
     * Konstruktor - uzywany do umieszczenia okregu na ekranie
     * R.color.word jest ustawiony na przezroczysty
     * @param context dostep do informacji o stanie aplikacji
     * @param player uzywany do sprawdzania zderzenia
     * @param positionX pozycja slowa na osi x
     * @param positionY pozycja slowa na osi y
     * @param radius promien okregu
     */
    public GoodWord(Context context, Player player, double positionX, double positionY, double radius) {
        super(ContextCompat.getColor(context, R.color.word), positionX, positionY, radius);
        this.player = player;
        this.context = context;
    }

    /**
     * Metoda dzieki ktorej, wyswietlany jest tekst o przyznaniu punktu i wyswietlenie informacji o przejsciu do kolejnego poziomu
     * @param canvas umozliwia rysowanie grafiki
     */
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.goodWord);
        paint.setColor(color);
        float textSize = 100;
        paint.setTextSize(textSize);
        canvas.drawText("YOU GOT +1 POINT", 375, 200,  paint);
        canvas.drawText("PROCEEDING TO NEXT LEVEL...", 375, 300,  paint);
        canvas.drawText("TURN YOUR PHONE VERTICALLY", 375, 400,  paint);
    }
}
