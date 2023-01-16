package com.example.languella.Game1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.example.languella.Activities.FlappyActivity;
import com.example.languella.Activities.MainActivity;
import com.example.languella.Activities.MenuActivity;
import com.example.languella.GameObject.Circle;
import com.example.languella.GameObject.GoodWord;
import com.example.languella.GameObject.Word;
import com.example.languella.GameObject.Player;
import com.example.languella.GamePanel.GameOver;
import com.example.languella.GamePanel.Joystick;
import com.example.languella.GamePanel.PauseButton;
import com.example.languella.GamePanel.Performance;
import com.example.languella.GamePanel.ResumeButton;
import com.example.languella.GamePanel.Timer;
import com.example.languella.GamePanel.QuitButton;
import com.example.languella.Graphics.SpriteSheet;
import com.example.languella.Map.TileMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Klasa zarzadzajaca wszystkimi obiektami w grze
 * Odpowiedzialna jest za aktualizowanie stanow i renderowanie obiektow na ekranie
 */
public class Game extends SurfaceView implements SurfaceHolder.Callback {
    /** Atrybuty klasy */
    private final Player player;
    private final Joystick joystick;
    private final TileMap tileMap;
    private GameLoop gameLoop;
    private MainActivity mainActivity;
    private final List<Word> wordList = new ArrayList<>();
    private int joystickPointerId = 0;
    private final GameOver gameOver;
    private final PauseButton pauseButton;
    private final ResumeButton resumeButton;
    private final QuitButton quitButton;
    private final Timer timer;
    private final Performance performance;
    private final GameDisplay gameDisplay;
    private final GoodWord goodWord;


    /**
     * Konstruktor - ustawienie parametrow obiektow
     * @param context  dostep do informacji o stanie aplikacji
     */
    public Game(Context context) {
        /**Konstruktor klasy nadrzednej*/
        super(context);

        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        SpriteSheet spriteSheet = new SpriteSheet(context);

        /** Silnik gry */
        gameLoop = new GameLoop(this, surfaceHolder);

        /** Parametry na ekranie */
        performance = new Performance(gameLoop, context);
        timer = new Timer(context);

        /** Napisu po skonczonym czasie */
        gameOver = new GameOver(context);

        /** Przyciski na ekranie */
        pauseButton = new PauseButton(context);
        resumeButton = new ResumeButton(context);
        quitButton = new QuitButton(context);

        /** Drazek do sterowania */
        joystick = new Joystick(300, 700, 70, 40);

        /** Bohater */
        player = new Player(context, joystick, 2*500, 500, 32, spriteSheet.getPlayerSprite());

        /** Miejsca zlych slow */
        wordList.add(new Word(getContext(), 2025, 1000, 65));
        wordList.add(new Word(getContext(), 350, 1450, 65));
        wordList.add(new Word(getContext(), 730, 2475, 65));
        wordList.add(new Word(getContext(), 1900, 1700, 65));
        wordList.add(new Word(getContext(), 2275, 2150, 65));
        wordList.add(new Word(getContext(), 1700, 2900, 65));
        wordList.add(new Word(getContext(), 675, 3425, 65));
        wordList.add(new Word(getContext(), 2275, 3425, 65));
        wordList.add(new Word(getContext(), 3485, 2600, 65));
        wordList.add(new Word(getContext(), 3485, 1325, 65));

        /** Granice mapy */
        for(int i=-0; i<3850; i++){
            wordList.add(new Word(getContext(), i, -160, 1));
            wordList.add(new Word(getContext(), i, 4010, 1));
            wordList.add(new Word(getContext(), -160, i, 1));
            wordList.add(new Word(getContext(), 4010, i, 1));
        }

        /** Miejsce poprawnego slowa */
        goodWord = new GoodWord(getContext(), player, 2975, 3475, 60);

        /** Mapa woklu bohatera */
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        gameDisplay = new GameDisplay(displayMetrics.widthPixels, displayMetrics.heightPixels, player);

        /** Mapa */
        tileMap = new TileMap(spriteSheet);
        setFocusable(true);
    }

    /**
     * Metoda zajmujaca sie zdarzeniami dotykowymi
     * @param event zdarzenia ruchu
     * @return  przekazanie darzenia do elemetnow interfejsu
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getActionMasked()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                /**  Joystick jest klikniety */
                if(joystick.isPressed(event.getX(), event.getY())) {
                   joystickPointerId = event.getPointerId(event.getActionIndex());
                    joystick.setIsPressed(true);
                    /** Przycisk pauzy jest klikniety, wtedy gameLoop zostaje wstrzymany */
                }else if(PauseButton.isPressed(event.getX(), event.getY())){
                    gameLoop.stopLoop();
                    /** Przycisk wznowienia gry jest klikniety, wtedy gameLoop zostaje uruchomiony*/
                }else if(ResumeButton.isPressed(event.getX(), event.getY())){
                    SurfaceHolder surfaceHolder = getHolder();
                    surfaceHolder.addCallback(this);
                    gameLoop = new GameLoop(this, surfaceHolder);
                    gameLoop.startLoop();
                    /** Przycisk wyjscia gry jest klikniety, wtedy wlaczenie aktywnosci menu glownego*/
                }else if(QuitButton.isPressed(event.getX(), event.getY())){
                    Intent gameOver = new Intent(getContext(), MenuActivity.class);
                    gameOver.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    gameOver.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getContext().startActivity(gameOver);
                    System.exit(1);
                }
                return true;

            case MotionEvent.ACTION_MOVE:
                /** Ruszanie drazka*/
                if(joystick.getIsPressed()){
                    joystick.setActuator( event.getX(),event.getY());
                }
                return true;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                /** Drazek nie jest uzywany*/
                if(joystickPointerId == event.getPointerId(event.getActionIndex())) {
                    joystick.setIsPressed(false);
                    joystick.resetActuator();
                }
                return true;
        }
        return super.onTouchEvent(event);
    }

    /**
     * Metoda wykonywana od razu po utworzeniu powierzchni
     * Rozpoczecie pracy silnika gry (gameLoop)
     * @param holder umozliwia edycje i sterowanie powierzchnia
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (gameLoop.getState().equals(Thread.State.TERMINATED)) {
            gameLoop = new GameLoop(this, holder);
        }
        gameLoop.startLoop();
        Log.d("Game.java", "surfaceCreated()");
    }

    /**
     * Metoda wykonywana gdy dojdzie do zmian powierzchni
     * @param holder umozliwia edycje i sterowanie powierzchnia
     * @param format PixelFormat powierzchni
     * @param width szerokosc powierzchni
     * @param height wysokosc powierzchni
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int  format, int width, int height) {
        Log.d("Game.java", "surfaceChanged()");
    }

    /**
     * Metoda wykonywana przed zniszczeniem powierzchni
     * @param holder umozliwia edycje i sterowanie powierzchnia
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d("Game.java", "surfaceDestroyed()");
    }

    /**
     * Metoda uzywana do tworzenia interfejsu
     * @param canvas umozliwia rysowanie grafiki
     */
    @Override
    public void draw(Canvas canvas) {
            super.draw(canvas);
            /** Rysowanie mapy*/
            tileMap.draw(canvas, gameDisplay);
            /** Rysowanie przycisku pauzy*/
            pauseButton.draw(canvas);
             /** Rysowanie przycisku wznowienia*/
            resumeButton.draw(canvas);
            /** Rysowanie przycisku do menu*/
            quitButton.draw(canvas);
            /** Rysowanie drazka*/
            joystick.draw(canvas);
            /** Rysowanie bohatera*/
            player.draw(canvas, gameDisplay);
             /** Rysowanie UPS i FPS */
            performance.draw(canvas);
            /** Rysowanie timera*/
            timer.drawTimer(canvas);

            /** Petla do wyrysowania wszystkich niepoprawnych slow*/
            for(Word word : wordList){
                word.draw(canvas, gameDisplay);
            }

            /** Rysowanie poprawnego slowa*/
            goodWord.draw(canvas, gameDisplay);

            /** Warunek jesli uplynie czas to rysowany jest napis o przegranej*/
            if(timer.getTime() == 1){
                gameOver.draw(canvas);
            }

             /** Warunek jesli gracz straci wszystkie zycia to rysowany jest napis o przegranej*/
            if(player.getHealthPoints() <= 0){
                gameOver.draw(canvas);
            }

            /** Warunek jesli gracz zgadnie slowo to rysowany jest napis o wygranej*/
            if(Circle.isColliding(goodWord, player)){
               goodWord.draw(canvas);
            }
    }

    /**
     * Aktualizowanie gry
     */
    public void update() {
        /**
         * Jeśli gracz straci wszystkie zycia to czas jest zatrzymywany i po 5 sekundach z glownej aktywnosci jest
         *  wywolywana funkcja, ktora ja zatrzymuje i przenosi do aktywnosci z menu glownym
         */
        if(player.getHealthPoints()<=0){
            gameLoop.pauseTimer();
            postDelayed(() -> {
                Intent gameOver = new Intent(getContext(), MenuActivity.class);
                gameOver.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                gameOver.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(gameOver);
                System.exit(1);

            }, 5000);
        }
        /**
         * Jeśli uplynie czas to po 5 sekundach z glownej aktywnosci jest  wywolywana
         * funkcja, ktora ja zatrzymuje i przenosi do aktywnosci z menu glownym
         */
        if(timer.getTime() == 1){
            postDelayed(() -> {
                Intent gameOver = new Intent(getContext(), MenuActivity.class);
                gameOver.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                gameOver.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(gameOver);
                System.exit(1);
            }, 5000);
        }

        /**Jesli gracz zgadnie slowo to czas jest zatrzymywany i po 5 sekundach uruchamia sie drugi poziom gry*/
        if(Circle.isColliding(goodWord, player)){
            gameLoop.pauseTimer();
            postDelayed(() -> {
                Intent newLevel = new Intent(getContext(), FlappyActivity.class);
                newLevel.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                newLevel.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(newLevel);
                System.exit(1);
            }, 5000);
        }

        /**Aktualizowanie pozycji drazka*/
        joystick.updateInnerCirclePosition();
        /**Aktualizowanie pozycji bohatera*/
        player.update();

        /**
         * Iterator sprawdza czy nie doszlo do zderzenia slowa z bohaterem, jeśli do takiego doszlo to bohater
         * traci jeden punkt zycia, ale po ponownym wejściu na slowo juz go nie straci bo ono znika
         */
        Iterator<Word> iteratorWord = wordList.iterator();
        while(iteratorWord.hasNext()){
            Circle word = iteratorWord.next();
            if(Circle.isColliding(word, player)){
                iteratorWord.remove();
                player.setHealthPoints((int) (player.getHealthPoints()-1));
            }
        }

        /** Aktualizowanie obiektow w grze */
        gameDisplay.update();
    }
}
