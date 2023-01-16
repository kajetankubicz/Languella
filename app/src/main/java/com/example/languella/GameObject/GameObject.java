package com.example.languella.GameObject;


/**
 * Abstrakcyjna klasa, dzieki ktorej bohater i okregi sa wyswietlane
 */
public abstract class GameObject {
    /** Atrybuty klasy */
    protected double positionX;
    protected double positionY;
    protected double velocityX = 0;
    protected double velocityY = 0;

    /**
     * Konstruktor - ustawienie wspolrzednych
     * @param positionX pozycja na osi x
     * @param positionY pozycja na osi y
     */
    public GameObject(double positionX, double positionY){
        this.positionX = positionX;
        this.positionY = positionY;
    }

    /**
     * Odleglosc miedzy obiektami
     * @param object1 pierwszy obiekt
     * @param object2 drugi obiekt
     * @return odleglosc miedzy obiektami
     */
    public static double getDistanceBetweenObject(GameObject object1, GameObject object2) {
        return Math.sqrt(
                Math.pow(object2.getPositionX() - object1.getPositionX(), 2)+
                        Math.pow(object2.getPositionY() - object1.getPositionY(), 2));
    }

    /**
     *  Zwraca pozycyje
     * @return pozycja na osi x
     */
    public double getPositionX() {
        return  positionX;
    }

    /**
     *  Zwraca pozycyje
     * @return pozycja na osi y
     */
    public double getPositionY() {
        return  positionY;
    }

}
