package com.example.languella.Map;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.example.languella.Graphics.Sprite;
import com.example.languella.Graphics.SpriteSheet;

/**
 * Klasa z kafelkiem - miejsce poczatkowe
 */
public class StartTile extends Tile {
    /** Atrybuty klasy */
    private final Sprite sprite;

    /**
     * Pobiera informacje o polozeniu kafelka
     * @param spriteSheet dostep do informacji z jpeg'a
     * @param mapLocationRect  dostep do lokalizacji
     */
    public StartTile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        /** Zwracanie spirte'a na kafelek */
        sprite = spriteSheet.getStartSprite();
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
