package com.example.languella.GameObject;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.example.languella.*;

/**
 * Klasa ze zlym slowem
 */
public class Word extends Circle{

    /**
     *  Konstruktor - uzywany do umieszczenia okregu na ekranie
     *  R.color.word jest ustawiony na przezroczysty
     * @param context dostep do informacji o stanie aplikacji
     * @param positionX pozycja okregu na osi x
     * @param positionY pozycja okregu na osi y
     * @param radius wielkosc promienia
     */
    public Word(Context context, double positionX, double positionY, double radius) {
        super(ContextCompat.getColor(context, R.color.word), positionX, positionY, radius);
    }
}
