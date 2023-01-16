package com.example.languella.Graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.example.languella.*;

/**
 * Klasa sluzaca do pobrania jpg'a i odkodowania go
 */
public class SpriteSheet {
    /** Atrybuty klasy */
    private static final int SPRITE_WIDTH_PIXELS = 64;
    private static final int SPRITE_HEIGHT_PIXELS = 64;
    private final Bitmap bitmap;

    /**
     * Konstruktor - ustawienie parametrow mapy
     * @param context dostep do informacji o stanie aplikacji
     */
    public SpriteSheet(Context context){
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inScaled = false;
        /** Uzyskanie obrazu z bohaterem i slowami */
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.sprite_sheet, bitmapOptions);
    }

    /**
     * Pobranie bohatera
     * @return  obraz na podstawie pikseli
     */
    public Sprite getPlayerSprite(){
        return new Sprite(this, new Rect(0,0,96,128));
    }

    /**
     * Zwracanie calej bitmapy
     * @return  bitmapa
     */
    public Bitmap getBitmap() {
        return bitmap;
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getStartSprite() {
        return getSpriteByIndex(0, 2);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getWordSprite() {
        return getSpriteByIndex(0, 3);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getGrassSprite() {
        return getSpriteByIndex(0, 4);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getWORD_1Sprite() {
        return getSpriteByIndex(1, 2);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getWORD_2Sprite() {
        return getSpriteByIndex(1, 3);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getWORD_3Sprite() {
        return getSpriteByIndex(1, 4);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getWORD_4Sprite() {
        return getSpriteByIndex(2, 0);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getWORD_5Sprite() {
        return getSpriteByIndex(2, 1);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getWORD_6Sprite() {
        return getSpriteByIndex(2, 2);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getWORD_7Sprite() {
        return getSpriteByIndex(2, 3);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getWORD_8Sprite() {
        return getSpriteByIndex(2, 4);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getWORD_9Sprite() {
        return getSpriteByIndex(3, 0);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getWORD_10Sprite() {
        return getSpriteByIndex(3, 1);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getWORD_11Sprite() {
        return getSpriteByIndex(3, 2);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getWORD_12Sprite() {
        return getSpriteByIndex(3, 3);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getWORD_13Sprite() {
        return getSpriteByIndex(3, 4);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getWORD_14Sprite() {
        return getSpriteByIndex(4, 0);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getWORD_15Sprite() {
        return getSpriteByIndex(4, 1);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getWORD_16Sprite() {
        return getSpriteByIndex(4, 2);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getWORD_17Sprite() {
        return getSpriteByIndex(4, 3);
    }

    /**
     * Pobranie z obrazu kafelkow, na podstawie metody, ktrora liczy piksele
     * @return obraz na podstawie pikseli
     */
    public Sprite getWORD_18Sprite() {
        return getSpriteByIndex(4, 4);
    }

    /**
     * Metoda ktora liczy gdzie znajduje sie odpowiedni sprite
     * @param row rzad  w jpg'u
     * @param col kolumna  w jpg'u
     * @return zwraca sprite'a
     */
    private Sprite getSpriteByIndex(int row, int col) {
        return new Sprite(this, new Rect(
                col*SPRITE_WIDTH_PIXELS,
                row*SPRITE_HEIGHT_PIXELS,
                (col+1)*SPRITE_WIDTH_PIXELS,
                (row+1)*SPRITE_HEIGHT_PIXELS
        ));
    }

}
