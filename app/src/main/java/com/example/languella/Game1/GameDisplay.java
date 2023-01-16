package com.example.languella.Game1;

import android.graphics.Rect;
import com.example.languella.GameObject.GameObject;

/**
 * Klasa, ktora odpowiada rozstawienie obiektow
 */
public class GameDisplay {
    /** Atrybuty klasy */
    public final Rect DISPLAY_RECT;
    private final int widthPixels;
    private final int heightPixels;
    private final GameObject centerObject;
    private final double displayCenterX;
    private final double displayCenterY;
    private double gameToDisplayCoordinatesOffsetX;
    private double gameToDisplayCoordinatesOffsetY;
    private double gameCenterX;
    private double gameCenterY;

    /**
     * Konstruktor - do ustawienia obiektow w grze
     * @param widthPixels szerokosc gry
     * @param heightPixels wysokosc gry
     * @param centerObject obiekt do ustawienia
     */
    public GameDisplay(int widthPixels, int heightPixels, GameObject centerObject) {
        this.widthPixels = widthPixels;
        this.heightPixels = heightPixels;
        DISPLAY_RECT = new Rect(0, 0, widthPixels, heightPixels);
        this.centerObject = centerObject;
        displayCenterX = widthPixels/2.0;
        displayCenterY = heightPixels/2.0;
        update();
    }

    /**Aktualizacja polozenia obiektow w grze*/
    public void update() {
        gameCenterX = centerObject.getPositionX();
        gameCenterY = centerObject.getPositionY();

        gameToDisplayCoordinatesOffsetX = displayCenterX - gameCenterX;
        gameToDisplayCoordinatesOffsetY = displayCenterY - gameCenterY;
    }

    /**
     *  Liczenie odleglosci
     * @param x pozycja obiektu na osi x
     * @return zwraca odleglosc na osi x od "centrum' gry
     */
    public double gameToDisplayCoordinatesX(double x) {
        return x + gameToDisplayCoordinatesOffsetX;
    }

    /**
     *  Liczenie odleglosci
     * @param y pozycja obiektu na osi y
     * @return zwraca odleglosc na osi y od "centrum' gry
     */
    public double gameToDisplayCoordinatesY(double y) {
        return y + gameToDisplayCoordinatesOffsetY;
    }

    /**
     * Granice mapy
     * @return mapa
     */
    public Rect getGameRect() {
        return new Rect(
                (int) (gameCenterX - widthPixels/2),
                (int) (gameCenterY - heightPixels/2),
                (int) (gameCenterX + widthPixels/2),
                (int) (gameCenterY + heightPixels/2)
        );
    }
}