package com.example.languella.GamePanel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.content.ContextCompat;
import com.example.languella.Game1.GameDisplay;
import com.example.languella.GameObject.Player;
import com.example.languella.*;

/**
 * Klasa ktora sluzy do wyswietlenia na ekranie ile zyc pozostalo graczowi
 */
public class HealthBar {
    /** Atrybuty klasy */
    private final Player player;
    private final int width, height, margin;
    private final Paint borderPaint, healthPaint;

    /**
     * Konstruktor - uzywany do umieszczenia znacznika z zyciem bohatera
     * @param context dostep do informacji o stanie aplikacji
     * @param player dostep do informacji o polozeniu bohatera
     */
    public HealthBar(Context context, Player player) {
        this.player = player;
        this.width = 100;
        this.height = 20;
        this.margin = 2;
        this.borderPaint = new Paint();
        int borderColor = ContextCompat.getColor(context, R.color.healthBarBorder);
        borderPaint.setColor(borderColor);
        this.healthPaint = new Paint();
        int healthColor = ContextCompat.getColor(context, R.color.healthBarHealth);
        healthPaint.setColor(healthColor);
    }

    /**
     * Rysowanie znacznika z zyciem na ekranie
     * @param canvas umozliwia rysowanie grafiki
     * @param gameDisplay dostep do informacji gdzie rysowac na mapie
     */
    public void draw(Canvas canvas, GameDisplay gameDisplay){
        float x = (float) player.getPositionX();
        float y = (float) player.getPositionY();
        float distanceToPlayer = 25;
        float heathPoints = player.getHealthPoints()/ Player.MAX_HEALTH_POINTS;
        float borderLeft, borderRight, borderTop, borderBottom;
        float healthLeft, healthRight, healthTop, healthBottom, healthWidth, healthHeight;

        borderLeft = x - width/2;
        borderRight = x + width/2;
        borderBottom = y - distanceToPlayer;
        borderTop = borderBottom - height;
        canvas.drawRect(
                (float) gameDisplay.gameToDisplayCoordinatesX(borderLeft),
                (float) gameDisplay.gameToDisplayCoordinatesY(borderTop),
                (float) gameDisplay.gameToDisplayCoordinatesX(borderRight),
                (float) gameDisplay.gameToDisplayCoordinatesY(borderBottom),
                borderPaint
        );

        healthWidth = width - 2*margin;
        healthHeight = height - 2*margin;
        healthLeft = borderLeft + margin;
        healthRight = healthLeft + healthWidth*heathPoints;
        healthBottom = borderBottom - margin;
        healthTop = healthBottom - healthHeight;
        canvas.drawRect(
                (float) gameDisplay.gameToDisplayCoordinatesX(healthLeft),
                (float) gameDisplay.gameToDisplayCoordinatesY(healthTop),
                (float) gameDisplay.gameToDisplayCoordinatesX(healthRight),
                (float) gameDisplay.gameToDisplayCoordinatesY(healthBottom),
                healthPaint
        );
    }
}
