package com.example.languella.GamePanel;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Klasa z drazkiem do sterowania
 */
public class Joystick {
    /** Atrybuty klasy */
    private final Paint outerCirclePaint;
    private final Paint innerCirclePaint;
    private final int outerCircleRadius;
    private final int innerCircleRadius;
    private final int outerCircleCenterPositionX;
    private final int outerCircleCenterPositionY;
    private int innerCircleCenterPositionX;
    private int innerCircleCenterPositionY;
    private boolean isPressed;
    private double actuatorX;
    private double actuatorY;

    /**
     * Konstruktor - uzywany do umieszczenia drazka na ekranie
     * @param centerPositionX pozycja drazka na osi x
     * @param centerPositionY pozycja drazka na osi y
     * @param outerCircleRadius promien zwenetrznego drazka
     * @param innerCircleRadius promien wewnetrznego drazka
     */
    public Joystick(int centerPositionX, int centerPositionY, int outerCircleRadius, int innerCircleRadius){
        /** Tworzenie zewnetrznego i wewnetrznego drazka */
        outerCircleCenterPositionX = centerPositionX;
        outerCircleCenterPositionY = centerPositionY;
        innerCircleCenterPositionX = centerPositionX;
        innerCircleCenterPositionY = centerPositionY;

        /** Promien drazka */
        this.outerCircleRadius = outerCircleRadius;
        this.innerCircleRadius = innerCircleRadius;

        /** Kolor drazka zewnetrznego */
        outerCirclePaint = new Paint();
        outerCirclePaint.setColor(Color.GRAY);
        outerCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);

        /** Kolor drazka wewnerznego */
        innerCirclePaint = new Paint();
        innerCirclePaint.setColor(Color.BLUE);
        innerCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);

    }

    /**
     * Rysowanie drazka na ekranie
     * @param canvas umozliwia rysowanie grafiki
     */
    public void draw(Canvas canvas) {
        /**Rysowanie zewnetrznego drazka*/
        canvas.drawCircle(
                outerCircleCenterPositionX,
                outerCircleCenterPositionY,
                outerCircleRadius,
                outerCirclePaint
        );

        /**Rysowanie wewnetrznego drazka*/
        canvas.drawCircle(
                innerCircleCenterPositionX,
                innerCircleCenterPositionY,
                innerCircleRadius,
                innerCirclePaint
        );
    }

    /** Aktualizacja polozenia wewnetrznego okregu drazka*/
    public void updateInnerCirclePosition() {
        innerCircleCenterPositionX = (int) (outerCircleCenterPositionX + actuatorX*outerCircleRadius);
        innerCircleCenterPositionY = (int) (outerCircleCenterPositionY + actuatorY*outerCircleRadius);
    }

    /**
     * Metoda ktora sprawdza czy drazek zostal dotkniety przez gracza
     * @param touchPositionX zwracanie gdzie na ekranie doszlo do zderzenia na osi x
     * @param touchPositionY zwracanie gdzie na ekranie doszlo do zderzenia na osi y
     * @return czy gracz dotknal drazka
     */
    public boolean isPressed(double touchPositionX, double touchPositionY) {
        double joystickCenterToTouchDistance = Math.sqrt(
                Math.pow(outerCircleCenterPositionX - touchPositionX, 2) +
                        Math.pow(outerCircleCenterPositionY - touchPositionY, 2)
        );
        return joystickCenterToTouchDistance < outerCircleRadius;
    }

    /**
     * Sprawdzanie dla onTouchEventu z klasy Game
     * Czy gracz dotknal drazka
     * @param isPressed czy dotknieto drazka
     */
    public void setIsPressed(boolean isPressed) {
        this.isPressed = isPressed;
    }

    /**
     * Sprawdzanie dla onTouchEventu z klasy Game
     * Czy gracz porusza drazkiem
     * @return czy doknieto drazka
     */
    public boolean getIsPressed() {
        return isPressed;
    }

    /**
     * Gdy drazek jest uzywany
     * @param touchPositionX wspolrzedna gdzie gracz dotyka drazka na osi x
     * @param touchPositionY wspolrzedna gdzie gracz dotyka drazka na osi y
     */
    public void setActuator(double touchPositionX, double touchPositionY) {
        double deltaX = touchPositionX - outerCircleCenterPositionX;
        double deltaY = touchPositionY - outerCircleCenterPositionY;
        double deltaDistance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));

        if(deltaDistance < outerCircleRadius){
            actuatorX = deltaX/outerCircleRadius;
            actuatorY = deltaY/outerCircleRadius;
        }else{
            actuatorX = deltaX/deltaDistance;
            actuatorY = deltaY/deltaDistance;
        }
    }

    /** Drazek nie jest uzywany*/
    public void resetActuator() {
        actuatorX = 0.0;
        actuatorY = 0.0;
    }

    /**
     * Zwraca odchylenie drazka na osi x
     * @return odchylenie na osi x
     */
    public double getActuatorX() {
        return actuatorX;
    }

    /**
     * Zwraca odchylenie drazka na osi y
     * @return odchylenie na osi y
     */
    public double getActuatorY() {
        return actuatorY;
    }
}
