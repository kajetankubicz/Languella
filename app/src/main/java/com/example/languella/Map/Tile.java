package com.example.languella.Map;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.example.languella.Graphics.SpriteSheet;

abstract class Tile{
    /** Atrybuty klasy */
    protected final Rect mapLocationRect;

    /**
     * Konstruktor - inicjowanie kafelka
     * @param mapLocationRect dostep do lokalizacji
     */
    public Tile(Rect mapLocationRect) {
        this.mapLocationRect = mapLocationRect;
    }

    /**
     * Rozroznienie kafelkow, wpisane po kolei z jpg'a
     */
    public enum TileType{
        START_TILE,
        WORD_TILE,
        GRASS_TILE,
        WORD_1, WORD_2, WORD_3, WORD_4, WORD_5, WORD_6, WORD_7, WORD_8, WORD_9, WORD_10,
        WORD_11, WORD_12, WORD_13, WORD_14, WORD_15, WORD_16, WORD_17, WORD_18,
    }

    /**
     * Metoda pozwalajaca uzyc kafelka
     * @param idTileType dostep do enuma
     * @param spriteSheet dostep do informacji z jpeg'a
     * @param mapLocationRect dostep do lokalizacji
     * @return kafelek ze spritem
     */
    public static Tile getTile(int idTileType, SpriteSheet spriteSheet, Rect mapLocationRect) {
        /** Zwracanie listy z powyzszego enuma*/
        switch(TileType.values()[idTileType]){
            case START_TILE:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new StartTile(spriteSheet, mapLocationRect);
            case WORD_TILE:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new WordTile(spriteSheet, mapLocationRect);
            case GRASS_TILE:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new GrassTile(spriteSheet, mapLocationRect);
            case WORD_1:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new WORD_1(spriteSheet, mapLocationRect);
            case WORD_2:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new WORD_2(spriteSheet, mapLocationRect);
            case WORD_3:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new WORD_3(spriteSheet, mapLocationRect);
            case WORD_4:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new WORD_4(spriteSheet, mapLocationRect);
            case WORD_5:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new WORD_5(spriteSheet, mapLocationRect);
            case WORD_6:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new WORD_6(spriteSheet, mapLocationRect);
            case WORD_7:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new WORD_7(spriteSheet, mapLocationRect);
            case WORD_8:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new WORD_8(spriteSheet, mapLocationRect);
            case WORD_9:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new WORD_9(spriteSheet, mapLocationRect);
            case WORD_10:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new WORD_10(spriteSheet, mapLocationRect);
            case WORD_11:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new WORD_11(spriteSheet, mapLocationRect);
            case WORD_12:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new WORD_12(spriteSheet, mapLocationRect);
            case WORD_13:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new WORD_13(spriteSheet, mapLocationRect);
            case WORD_14:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new WORD_14(spriteSheet, mapLocationRect);
            case WORD_15:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new WORD_15(spriteSheet, mapLocationRect);
            case WORD_16:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new WORD_16(spriteSheet, mapLocationRect);
            case WORD_17:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new WORD_17(spriteSheet, mapLocationRect);
            case WORD_18:
                /** Zwraca spirte'a i lokalizacje na mapie kafelka*/
                return new WORD_18(spriteSheet, mapLocationRect);
            default:
                return null;
        }
    }

    /**
     * Abstrakcyjna metoda do rysowania
     * @param canvas dostep do informacji o stanie aplikacji
     */
    public abstract void draw(Canvas canvas);
}
