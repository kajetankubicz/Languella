package com.example.languella.Map;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.example.languella.Graphics.Sprite;
import com.example.languella.Graphics.SpriteSheet;

/**
 * Klasa z kafelkiem - slowo
 */
public class WORD_16 extends Tile {
    /** Atrybuty klasy */
    private final Sprite sprite;

    /**
     * Pobiera informacje o polozeniu kafelka
     * @param spriteSheet dostep do informacji z jpeg'a
     * @param mapLocationRect  dostep do lokalizacji
     */
    public WORD_16(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        sprite = spriteSheet.getWORD_16Sprite();
    }

    /**
     * Metoda do rysowania
     * @param canvas dostep do informacji o stanie aplikacji
     */
    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
