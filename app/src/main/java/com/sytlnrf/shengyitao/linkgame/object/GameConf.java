package com.sytlnrf.shengyitao.linkgame.object;

import android.content.Context;

/**
 * Created by shengyitao on 15/7/6.
 */
public class GameConf {
    public static final int PIECE_WIDTH = 40;
    public static final int PIECE_HEIGHT = 40;
    public static final int DEFAULT_TIME = 100;

    private int xSize;
    private int ySize;
    private int beginImageX;
    private int beginImageY;
    private long gameTime;
    private Context context;

    public GameConf(int xSize, int ySize, int beginImageX,
                    int beginImageY, long gameTime, Context context){
        this.xSize = xSize;
        this.ySize = ySize;
        this.beginImageX = beginImageX;
        this.beginImageY = beginImageY;
        this.gameTime = gameTime;
        this.context = context;
    }

    public int getXSize(){
        return xSize;
    }

    public int getYSize(){
        return ySize;
    }

    public int getBeginImageX(){
        return beginImageX;
    }

    public int getBeginImageY(){
        return beginImageY;
    }

    public long getGameTime(){
        return gameTime;
    }

    public Context getContext(){
        return context;
    }
}
