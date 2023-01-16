package com.example.languella.Game1;

import android.graphics.Canvas;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.SurfaceHolder;

/**Silnik gry*/
public class GameLoop extends  Thread{
    /** Atrybuty klasy */
    public static final double MAX_UPS = 60;
    private static final double UPS_PERIOD = 1E+3/MAX_UPS;
    private final Game game;
    private final SurfaceHolder surfaceHolder;
    private boolean isRunning = false;
    private double averageUPS;
    private double averageFPS;
    int updateCount = 0;
    int frameCount = 0;
    long startTime;
    long elapsedTime;
    long sleepTime;
    Canvas canvas = null;
    private boolean mTimerRunning;
    private CountDownTimer mCountDownTimer;
    private static long time = 30000;

    /**
     * Zwraca czas
     * @return czas do konca gry
     */
    public static int getTime() {
        return (int) time;
    }

    /**
     *  Zwraca srednie UPS'y
     * @return srednia wartosc UPS'ow
     */
    public double getAverageUPS() {
        return averageUPS;
    }

    /**
     *  Zwraca srednie FPS'y
     * @return srednia wartosc FPS'ow
     */
    public double getAverageFPS() {
        return averageFPS;
    }

    /**
     * Konstruktor - sterowanie parametrami gry
     * @param game dostep do obiektow w grze
     * @param surfaceHolder  umozliwia edycje i sterowanie powierzchnia
     */
    public GameLoop(Game game, SurfaceHolder surfaceHolder) {
        this.game = game;
        this.surfaceHolder = surfaceHolder;
    }

    /**
     * Metoda ktora uruchamia silnik gry
     */
    public void startLoop() {
        Log.d("GameLoop.java", "startLoop()");
        isRunning = true;
        start();
        if (mTimerRunning) {
            pauseTimer();
        } else {
            startTimer();
        }
    }

    /** Silnik gry*/
    @Override
    public void run() {
        Log.d("GameLoop.java", "run()");
       super.run();
        startTime = System.currentTimeMillis();
        while(isRunning){
            try{
                canvas = surfaceHolder.lockCanvas();
                synchronized (surfaceHolder){
                    game.update();
                    updateCount++;
                    game.draw(canvas);
                }
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            } finally {
                if(canvas != null){
                    try{
                        surfaceHolder.unlockCanvasAndPost(canvas);
                        frameCount++;
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

            elapsedTime = System.currentTimeMillis() -startTime;
            sleepTime = (long)(updateCount*UPS_PERIOD - elapsedTime);
            if(sleepTime > 0 ){
                try {
                    sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            while(sleepTime <0 && updateCount < MAX_UPS -1 ){
                game.update();
                updateCount++;
                elapsedTime = System.currentTimeMillis() -startTime;
                sleepTime = (long)(updateCount*UPS_PERIOD - elapsedTime);
            }

            /** Obliczanie FPS'ow i UPS'ow */
            elapsedTime = System.currentTimeMillis() - startTime;
            if(elapsedTime >= 1000) {
                averageUPS = updateCount;
                averageFPS = frameCount ;
                updateCount = 0;
                frameCount = 0;
                startTime = System.currentTimeMillis();
            }
        }
    }

    /**
     * Metoda ktora zatrzymuje silnik gry
     */
    public void stopLoop() {
        Log.d("GameLoop.java", "stopLoop()");
        isRunning = false;
        pauseTimer();
        try{
            join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * Metoda dzieki ktorej dziala odliczanie czasu
     */
    public void startTimer() {
        mCountDownTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time = millisUntilFinished;
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
            }
        }.start();

        mTimerRunning = true;
    }

    /**
     * Zatrzymywanie odliczania czasu
     */
    public void pauseTimer() { //
        mCountDownTimer.cancel();
        mTimerRunning = false;
    }
}
