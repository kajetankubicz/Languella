package com.example.languella.Graphics;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Klasa sluzaca do rysowania spite'ow pobranych z jpg'a w grze
 */
public class Sprite {
    /** Atrybuty klasy */
    private final SpriteSheet spriteSheet;
    private final Rect rect;

    /**
     * Konstruktor - rysowanie spite'ow
     * @param spriteSheet dostep do informacji z jpeg'a
     * @param rect dostep do rysowania ksztaltow
     */
        public Sprite(SpriteSheet spriteSheet, Rect rect) {
        this.spriteSheet = spriteSheet;
        this.rect = rect;
    }

    /**
     * Metoda do do rysowania spite'ow
     * @param canvas dostep do informacji o stanie aplikacji
     * @param x polozenie spite'a na osi x
     * @param y polozenie spite'a na osi y
     */
    public void draw(Canvas canvas, int x, int y) {
        canvas.drawBitmap(spriteSheet.getBitmap(), rect, new Rect(x,y,x+getWidth(),y+getHeight()), null);
    }

    /**
     *  Zwraca szerokosc spite'a
     * @return szerokosc kwadratu
     */
    public int getWidth() {
        return rect.width();
    }

    /**
     *  Zwraca wysokosc spite'a
     * @return wysokosc kwadratu
     */
    public int getHeight() {
        return rect.height();
    }

}
