package com.example.languella.GameObject;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.example.languella.Game1.GameDisplay;

/**
 * Abstrakcyjna metoda, ktora implementuje metode rysowania z GameObject
 */
public abstract class Circle extends GameObject {
    /** Atrybuty klasy */
    protected double radius;
    protected Paint paint;

    /**
     *  Konstruktor - ustawienie wspolrzednych,  koloru i promienia
     * @param color kolor okregu
     * @param positionX pozycja na osi x
     * @param positionY pozycja na osi y
     * @param radius wielkosc promienia
     */
    public Circle(int color, double positionX, double positionY, double radius) {
        super(positionX, positionY);
        this.radius = radius;
        paint = new Paint();
        paint.setColor(color);
    }

    /**
     * Ta metoda sprawdza na podstawie pozycji gracza i okegu czy gracz i okregu sie nie zderzaja
     * @param object1 pierwszy obiekt
     * @param object2 drugi obiekt
     * @return true jesli sie zderzaja, false jesli nie
     */
    public static boolean isColliding(Circle object1, Circle object2) {
        double distance = getDistanceBetweenObject(object1, object2);
        double distanceToCollision = object1.getRadius() + object2.getRadius();
        if(distance<distanceToCollision){
            return true;
        }else{
            return false;
        }
    }

    /**
     *  Zwraca promien okegu
     * @return promien okegu
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Rysowanie okegu na ekranie
     * @param canvas umozliwia rysowanie grafiki
     * @param gameDisplay dostep do informacji gdzie rysowac na mapie
     */
    public void draw(Canvas canvas, GameDisplay gameDisplay) {
        canvas.drawCircle(
                (float) gameDisplay.gameToDisplayCoordinatesX(positionX),
                (float) gameDisplay.gameToDisplayCoordinatesY(positionY),
                (float) radius,
                paint
        );
    }
}
