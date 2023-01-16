package com.example.languella.Map;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.example.languella.Graphics.Sprite;
import com.example.languella.Graphics.SpriteSheet;

/**
 * Klasa z kafelkiem, ktory otacza slowo dla lepszego znalezienia go
 */
public class WordTile extends Tile {
    /** Atrybuty klasy */
    private final Sprite sprite;

    /**
     * Pobiera informacje o polozeniu kafelka
     * @param spriteSheet dostep do informacji z jpeg'a
     * @param mapLocationRect  dostep do lokalizacji
     */
    public WordTile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        sprite = spriteSheet.getWordSprite();
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
