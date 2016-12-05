package com.epam.java.javafx.snake.java.model;

/**
 * Created by Aleksandr_Vaniukov on 11/24/2016.
 */
public class GreenFrog extends Frog {
    private int x;
    private int y;
    private int type;
    private Game game;

    public GreenFrog(int x,int y){
        this.x=x;
        this.y=y;
        this.type=Constants.GREEN_FROG;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getType(){
        return this.type;
    }

    public void run() {
        game=Game.getGame();
        while (Running.running && !Thread.currentThread().isInterrupted()){
            if(!Running.pause) {

                int[][] field = game.takeField();

                if (Thread.currentThread().isInterrupted()) {
                    break;
                }

                //Move
                game.leaveField();

                try {
                    Thread.sleep(Options.getSpeedFrog());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
