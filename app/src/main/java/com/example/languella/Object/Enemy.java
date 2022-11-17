package com.example.languella.Object;

import android.content.Context;
import androidx.core.content.ContextCompat;

import com.example.languella.GameLoop;
import com.example.languella.R;

public class Enemy extends Circle{

    private final Player player;
    private static final double SPEED_PIXEL_PER_SECONDS = Player.SPEED_PIXEL_PER_SECONDS*0.7;
    private static final double MAX_SPEED = SPEED_PIXEL_PER_SECONDS / GameLoop.MAX_UPS;

    public Enemy(Context context, Player player, double positionX, double positionY, double radius) {
        super(context, ContextCompat.getColor(context, R.color.enemy), positionX, positionY, radius);
        this.player = player;
    }

    @Override
    public void update() {
        double distanceToPlayerX = player.getPositionX() - positionX;
        double distanceToPlayerY = player.getPositionY() - positionY;

        double distanceToPlayer = GameObject.getDistanceBetweenObject(this, player);

        double directionX = distanceToPlayerX/distanceToPlayer;
        double directionY = distanceToPlayerY/distanceToPlayer;

        if(distanceToPlayer > 0){
            velocityX = directionX*MAX_SPEED;
            velocityY = directionY*MAX_SPEED;
        }else{
            velocityX = 0;
            velocityY = 0;
        }

        positionX += velocityX;
        positionY += velocityY;
    }
}
