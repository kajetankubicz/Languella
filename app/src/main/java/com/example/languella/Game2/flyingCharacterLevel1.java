package com.example.languella.Game2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.example.languella.Activities.FlappyActivityLevel2;
import com.example.languella.Activities.MenuActivity;
import com.example.languella.GamePanel.QuitButton;
import com.example.languella.*;

/**
 * Klasa z druga gra
 * Level 1
 */
public class flyingCharacterLevel1 extends View {
    /** Atrybuty klasy */
    private final Bitmap[] character = new Bitmap[2];
    private final int characterX = 10;
    private int characterY;
    private int characterSpeed;
    private int circleX, circleY, circle1X, circle1Y, circle2X, circle2Y, circle3X, circle3Y;
    private final int circleSpeed = 20, circleSpeed1=22, circleSpeed2=24, circleSpeed3=26;
    private final Paint wordPaint = new Paint();
    private int goodWordX, goodWordY, goodWordSpeed = 16;
    private int lifeCounter;
    private boolean touch = false;
    private final Bitmap backgroundImage;
    private final Paint scorePaint = new Paint();
    private final Bitmap[] life = new Bitmap[2];
    private final QuitButton quitButton;

    /**
     * Konstruktor - ustawienie parametrow obiektow
     * @param context  dostep do informacji o stanie aplikacji
     */
    public flyingCharacterLevel1(Context context) {
        /**  Konstruktor klasy nadrzednej*/
        super(context);
        /** Dodanie pierwszej wersji bohatera  */
        character[0] = BitmapFactory.decodeResource(getResources(), R.drawable.character);
        /** Dodanie drugiej wersji bohatera */
        character[1] = BitmapFactory.decodeResource(getResources(), R.drawable.character1);
        /** Dodanie tla */
        backgroundImage = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        /** Ustawienie koloru kulek i slowa na czarny */
        wordPaint.setColor(Color.BLACK);
        /** Wylaczenie anty aliasingu czcionki */
        wordPaint.setAntiAlias(false);
        /** Ustawienie rozmiaru czcionki */
        wordPaint.setTextSize(50);
        /** Ustawienie koloru testu z wynikiem */
        scorePaint.setColor(Color.WHITE);
        /** Ustawienie rozmiaru czcionki */
        scorePaint.setTextSize(70);
        /** Ustawienie pogrubionej czionki */
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        /** Wlacznie anty aliasigu czcionki */
        scorePaint.setAntiAlias(true);
        /** Dodanie serca */
        life[0] = BitmapFactory.decodeResource(getResources(), R.drawable.hearts);
        /** Dodanie pustego serca */
        life[1] = BitmapFactory.decodeResource(getResources(), R.drawable.heart_grey);
        /** Ustawienie liczby zyc */
        lifeCounter = 3;
        /** Dodanie przycisku do menu glownego*/
        quitButton = new QuitButton(context);
    }

    /**
     * Metoda uzywana do tworzenia interfejsu
     * @param canvas umozliwia rysowanie grafiki
     */
    @Override
    protected void onDraw(Canvas canvas) {
        /**  Konstruktor klasy nadrzednej*/
        super.onDraw(canvas); //
        /**  Pobranie szerokosci*/
        int canvasWidth = getWidth();
        /**  Pobranie wysokosci*/
        int canvasHeight = getHeight();
        /**  Ustawienie tla*/
        canvas.drawBitmap(backgroundImage, 0, 0 , null);

        /**  Minimalna pozycja gdzie bohater moze spasc*/
        int minCharacterY= character[0].getHeight();
        int maxCharacterY = canvasHeight -character[0].getHeight() * 3;

        /**  Poruszanie sie bohatera po osi Y*/
        characterY = characterY + characterSpeed;
        characterSpeed = characterSpeed + 2;

        /**  Warunki zapewniajace ze bohater nie wypadnie poza obszar gry*/
        if(characterY < minCharacterY){
            characterY = minCharacterY;
        }
        if(characterY > maxCharacterY){
            characterY = maxCharacterY;
        }

        /**  Warunek podczas klikniecia gracza w ekran*/
        if(touch){
            /** rysowanie postaci*/
            canvas.drawBitmap(character[1], characterX, characterY, null);
            touch = false;
        }else{
            /** rysowanie postaci*/
            canvas.drawBitmap(character[0], characterX, characterY, null);
        }

        /**  Ustawienie wartosci kulki na osi x*/
        circleX = circleX - circleSpeed; //
        /**  Warunek jesli dojdzie do zderzenia bohatera z kulka*/
        if(hitWordChecker(circleX, circleY)){
            circleX =  -100;
            /**strata zycia */
            lifeCounter--;
        }
        /**  Jesli kulka wyleci poza obszar gry*/
        if(circleX < 0){
            circleX = canvasWidth + 19;
            circleY = (int) Math.floor(Math.random() * (maxCharacterY-minCharacterY)) + minCharacterY;
        }
        /** Rysowanie kulki na ekranie */
        canvas.drawCircle(circleX,circleY,30,wordPaint);

        /**  Ustawienie wartosci kulki na osi x*/
        circle1X = circle1X - circleSpeed1;
        /**  Warunek jesli dojdzie do zderzenia bohatera z kulka*/
        if(hitWordChecker(circle1X, circle1Y)){
            circle1X =  -100;
            /**strata zycia */
            lifeCounter--;
        }
        /**  Jesli kulka wyleci poza obszar gry*/
        if(circle1X < 0){
            circle1X = canvasWidth + 14;
            circle1Y = (int) Math.floor(Math.random() * (maxCharacterY-minCharacterY)) + minCharacterY;
        }
        /** Rysowanie kulki na ekranie */
        canvas.drawCircle(circle1X,circle1Y,30,wordPaint);

        /**  Ustawienie wartosci kulki na osi x*/
        circle2X = circle2X - circleSpeed2;
        /**  Warunek jesli dojdzie do zderzenia bohatera z kulka*/
        if(hitWordChecker(circle2X, circle2Y)){
            circle2X =  -100;
            /**strata zycia */
            lifeCounter--;
        }
        /**  Jesli kulka wyleci poza obszar gry*/
        if(circle2X < 0){
            circle2X = canvasWidth + 10;
            circle2Y = (int) Math.floor(Math.random() * (maxCharacterY-minCharacterY)) + minCharacterY;
        }
        /** Rysowanie kulki na ekranie */
        canvas.drawCircle(circle2X,circle2Y,30,wordPaint);

        /**  Ustawienie wartosci kulki na osi x*/
        circle3X = circle3X - circleSpeed3;
        /**  Warunek jesli dojdzie do zderzenia bohatera z kulka*/
        if(hitWordChecker(circle3X, circle3Y)){
            circle3X =  -100;
            /**strata zycia */
            lifeCounter--;
        }
        /**  Jesli kulka wyleci poza obszar gry*/
        if(circle3X < 0){
            circle3X = canvasWidth + 10;
            circle3Y = (int) Math.floor(Math.random() * (maxCharacterY-minCharacterY)) + minCharacterY;
        }
        /** Rysowanie kulki na ekranie */
        canvas.drawCircle(circle3X,circle3Y,30,wordPaint);

        /**  Ustawienie wartosci slowa na osi x*/
        goodWordX = goodWordX - goodWordSpeed;
        /**
         * Warunek jesli dojdzie do zderzenia bohatera ze slowem
         * Nastepuje przejscie do nowego poziomu
         */
        if(hitWordChecker(goodWordX, goodWordY)){
            Intent level2 = new Intent(getContext(), FlappyActivityLevel2.class);
            level2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            level2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getContext().startActivity(level2);
            System.exit(1);
        }
        /**  Jesli slowo wyleci poza obszar gry*/
        if(goodWordX < 0){
            goodWordX = canvasWidth + 25;
            goodWordY = (int) Math.floor(Math.random() * (maxCharacterY-minCharacterY)) + minCharacterY;
        }

        /** Rysowanie poprawnego slowa na ekranie */
        canvas.drawText("Soy de Polonia", goodWordX, goodWordY, wordPaint);
        /** Rysowanie odpwiednika poprawnego slowa w innym jezyku na ekranie */
        canvas.drawText("Jestem z Polski", 20, 200, scorePaint);
        /** Rysowanie wynikna ekranie */
        canvas.drawText("Overall score : 1 ", 20, 100, scorePaint);

        /** Petla dzieki ktorej serca sa dodawane i usuwane */
        for(int i=0; i<3; i++){
            /** Wspolrzedne na osi x gdzie znajduja sie serca na ekranie */
            int x = (int) (650 + life[0].getWidth() * 1.5 * i);
            /** Wspolrzedne na osi y gdzie znajduja sie serca na ekranie */
            int y = 30;
            if(i<lifeCounter){
                /** Rysowanie serca*/
                canvas.drawBitmap(life[0], x, y, null);
            }else{
                /** Rysowanie pustego serca*/
                canvas.drawBitmap(life[1], x, y, null);
            }
        }
        /** Warunek gdy gracz straci wszystkie zycia*/
        if(lifeCounter == 0){
            Toast.makeText(getContext(), "Game Over. You got: 2 points", Toast.LENGTH_SHORT).show();
            Intent gameOver = new Intent(getContext(), MenuActivity.class);
            gameOver.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            gameOver.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getContext().startActivity(gameOver);
            System.exit(1);
        }

        quitButton.drawFlappy(canvas);
    }

    /**
     * Metoda sprawdzajaca czy bohater i slowo czy kulka sie zderzaja
     * @param x wpolrzedne na osi x gdzie znajduje sie kulka/slowo
     * @param y wpolrzedne na osi y gdzie znajduje sie kulka/slowo
     * @return  doszlo do zderzenia to true, nie doszlo do zderzenia to false
     */
    public boolean hitWordChecker(int x, int y){
        if(characterX < x && x < (characterX+character[0].getWidth() ) && characterY < y && y < (characterY + character[0].getHeight())){
            return true;
        }
        return false;
    }

    /**
     * Metoda zajmujaca sie zdarzeniami dotykowymi
     * @param event zdarzenia ruchu
     * @return przekazanie darzenia do elemetnow interfejsu
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            touch = true;
            characterSpeed = -15;
            /** Przycisk wyjscia gry jest klikniety  > wlaczenie aktynosci menu glownego*/
        }else if(QuitButton.isPressedFlappy(event.getX(), event.getY())){
            Intent gameOver = new Intent(getContext(), MenuActivity.class);
            gameOver.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            gameOver.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getContext().startActivity(gameOver);
            System.exit(1);
        }
        return true;
    }
}
