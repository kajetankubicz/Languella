package com.example.languella.GameObject;

import android.content.Context;
import android.graphics.Canvas;
import androidx.core.content.ContextCompat;
import com.example.languella.Game1.GameDisplay;
import com.example.languella.Game1.GameLoop;
import com.example.languella.GamePanel.HealthBar;
import com.example.languella.GamePanel.Joystick;
import com.example.languella.Graphics.Sprite;
import com.example.languella.*;

/**
 * Klasa z bohaterem
 */
public class Player extends Circle {
    /** Atrybuty klasy */
    public static final double SPEED_PIXEL_PER_SECONDS = 400.0;
    public static final double MAX_SPEED = SPEED_PIXEL_PER_SECONDS / GameLoop.MAX_UPS;
    public static final int MAX_HEALTH_POINTS = 3;
    private final Joystick joystick;
    private final HealthBar healthBar;
    private int healthPoints;
    private final Sprite sprite;

    /**
     * Konstruktor - uzywany do umieszczenia bohatera na ekranie
     * @param context dostep do informacji o stanie aplikacji
     * @param joystick sterowanie bohaterem za pomoca drazka
     * @param positionX pozycja bohatera na osi x
     * @param positionY pozycja bohatera na osi y
     * @param radius wielkosc bohatera
     * @param sprite grafika bohatera
     */
    public Player(Context context, Joystick joystick, double positionX, double positionY, double radius, Sprite sprite){
        super(ContextCompat.getColor(context, R.color.player), positionX, positionY, radius);
        this.joystick = joystick;
        this.healthBar = new HealthBar(context, this);
        this.healthPoints = MAX_HEALTH_POINTS;
        this.sprite = sprite;
    }

    /**
     * Aktualizowanie bohatera
     */
    public void update() {
        /** Aktualizowanie predkosci bohatera */
        velocityX = joystick.getActuatorX()*MAX_SPEED;
        velocityY = joystick.getActuatorY()*MAX_SPEED;

        /** Aktualizowanie pozycji bohatera */
        positionX += velocityX;
        positionY += velocityY;
    }

    /**
     * Rysowanie bohatera na ekranie
     * @param canvas umozliwia rysowanie grafiki
     * @param gameDisplay dostep do informacji gdzie rysowac na mapie
     */
    public void draw(Canvas canvas, GameDisplay gameDisplay) {
        sprite.draw(
                canvas,
                (int) gameDisplay.gameToDisplayCoordinatesX(getPositionX())-sprite.getWidth()/2,
                (int) gameDisplay.gameToDisplayCoordinatesY(getPositionY())-sprite.getHeight()/10
        );
        healthBar.draw(canvas, gameDisplay);
    }

    /**
     *  Zwraca stan zycia
     * @return ile zyc pozostalo bohaterowi
     */
    public float getHealthPoints() {
        return healthPoints;
    }

    /**
     * Ustawianie liczby zyc bohatera
     * @param healthPoints ile zyc dostaje bohater na start gry
     */
    public void setHealthPoints(int healthPoints) {
        if (healthPoints>=0){
            this.healthPoints = healthPoints;
        }
    }

}
