package com.epam.java.javafx.snake.java.model;

import com.epam.java.javafx.snake.java.controller.Game;

/**
 * Created by Aleksandr on 11/27/2016.
 */
public class BlueFrog extends Frog {
    private int x;
    private int y;
    private int type;
    private Game game;

    public BlueFrog(int x,int y){
        this.x=x;
        this.y=y;
        this.type=Constants.BLUE_FROG;
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
    public void kill(){
    }
}
