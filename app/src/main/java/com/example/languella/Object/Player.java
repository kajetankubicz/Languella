package com.example.languella.Object;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.example.languella.GameLoop;
import com.example.languella.Joystick;
import com.example.languella.R;

public class Player extends Circle {
    public static final double SPEED_PIXEL_PER_SECONDS = 400.0;
    public static final double MAX_SPEED = SPEED_PIXEL_PER_SECONDS / GameLoop.MAX_UPS;
    private final Joystick joystick;



    public Player(Context context, Joystick joystick, double positionX, double positionY, double radius){
        super(context, ContextCompat.getColor(context, R.color.player), positionX, positionY, radius);
        this.joystick = joystick;
    }

    public void update() {
        velocityX = joystick.getActuatorX()*MAX_SPEED;
        velocityY = joystick.getActuatorY()*MAX_SPEED;

        positionX += velocityX;
        positionY += velocityY;
    }

    /*public void getPosition(double positionX, double positionY ) {
        this.positionX = positionX;
        this.positionY = positionY;
    }*/
}
