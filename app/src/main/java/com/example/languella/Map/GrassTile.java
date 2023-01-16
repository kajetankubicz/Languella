package com.example.languella.Map;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.example.languella.Graphics.Sprite;
import com.example.languella.Graphics.SpriteSheet;

/**
 * Klasa z kafelkiem - trawa
 */
public class GrassTile extends Tile {
    /** Atrybuty klasy */
    private final Sprite sprite;

    /**
     * Pobiera informacje o polozeniu kafelka
     * @param spriteSheet dostep do informacji z jpeg'a
     * @param mapLocationRect  dostep do lokalizacji
     */
    public GrassTile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        /** Zwracanie spirte'a na kafelek */
        sprite = spriteSheet.getGrassSprite();
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
